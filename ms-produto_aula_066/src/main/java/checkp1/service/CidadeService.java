package checkp1.service;

import checkp1.dto.CidadeDTO;
import checkp1.entities.Cidade;
import checkp1.repositories.CidadeRepository;
import checkp1.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

   @Transactional(readOnly = true)
    public List<CidadeDTO> findAll(){
        return repository.findAll()
                .stream().map(CidadeDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CidadeDTO findById(Long id){
        Cidade entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("A cidade não foi encontrada!" + id)
        );
        return new CidadeDTO(entity);
    }

    @Transactional
    public CidadeDTO create (CidadeDTO dto){
       Cidade entity = new Cidade();
       copyDtoToEntity(dto, entity);
       entity = repository.save(entity);
       return new CidadeDTO(entity);
    }

    @Transactional
    public CidadeDTO update(Long id, CidadeDTO dto){
       try {
           Cidade entity = repository.getReferenceById(id);
           copyDtoToEntity(dto, entity);
           entity = repository.save(entity);
           return new CidadeDTO(entity);
       } catch (EntityNotFoundException ex){
           throw new ResourceNotFoundException("O recurso não foi encontrado. id" + id);
       }
    }

    @Transactional
    public void delete (Long id){
       if(!repository.existsById(id)){
           throw new ResourceNotFoundException("O recurso não foi econtrado. id" + id);
       }
       repository.deleteById(id);

    }


    private void copyDtoToEntity(CidadeDTO dto, Cidade entity) {
       entity.setNome(dto.getNome());
    }


}
