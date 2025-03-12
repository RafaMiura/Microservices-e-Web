package br.com.fiap.ms_produto.service;

import br.com.fiap.ms_produto.dto.CategoriaDTO;
import br.com.fiap.ms_produto.repositories.CategoriaRepository;
import org.hibernate.internal.util.collections.ReadOnlyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

   @Transactional(readOnly = true)
    public List<CategoriaDTO> findAll(){
        return repository.findAll()
                .stream().map(CategoriaDTO::new).toList();
    }
}
