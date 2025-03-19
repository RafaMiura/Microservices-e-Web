package checkp1.service;

import checkp1.dto.EventoRequestDTO;
import checkp1.dto.EventoResponseDTO;
import checkp1.entities.Evento;
import checkp1.repositories.CidadeRepository;
import checkp1.repositories.EventoRepository;
import checkp1.service.exceptions.DatabaseException;
import checkp1.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//Produto --> Evento
@Service //Definie para o Spring que é um Service

public class EventoService {

    // A classe de serviço depende do repositório
    //para acessar dados
    // Injeta a dependência

    @Autowired
    private EventoRepository repository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(readOnly = true)
    public List<EventoResponseDTO> findAll() {
        List<Evento> list = repository.findAll();
        return list.stream().map(EventoResponseDTO::new).toList();

        //utilizando expressão lambda
        // return list.stream().map(x -> new EventoResponseDTO(x)).toList();
    }


    @Transactional(readOnly = true)
    public EventoResponseDTO findById(Long id) {
        Evento entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("O Recurso não foi encontrado. Id:" + id)
        );

        return new EventoResponseDTO(entity);
    }

    @Transactional
    public EventoResponseDTO insert(EventoRequestDTO requestDTO) {
        try {Evento entity = new Evento();

            toEntity(requestDTO, entity);

            entity = repository.save(entity);

            return new EventoResponseDTO(entity);
        } catch (DataIntegrityViolationException ex) {
           throw new DatabaseException("Integridade referencial foi violada: "
                   + requestDTO.cidade().getId());
        }
    }

    @Transactional
    public EventoResponseDTO update(Long id, @Valid EventoRequestDTO requestDTO){
        try{
            Evento entity = repository.getReferenceById(id);
            toEntity(requestDTO, entity);
            entity = repository.save(entity);
            return new EventoResponseDTO(entity);
        } catch (EntityNotFoundException ex){
            throw  new ResourceNotFoundException("Recurso não foi encontrado. Id: " + id);
        }
    }

    //código omitido
    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não foi encontrado. Id: " + id);
        }
        repository.deleteById(id);
    }

    private void toEntity(EventoRequestDTO requestDTO, Evento entity) {
        entity.setNome(requestDTO.nome());
        entity.setData(requestDTO.data());
        entity.setUrl(requestDTO.url());

        /*Cidade cidade = CidadeRepository.getReferenceById(requestDTO.cidade().getId());
        entity.setCidade(cidade);*/
    }



}
