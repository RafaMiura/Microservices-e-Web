package com.github.cidarosa.ms_pagamento.service;


import com.github.cidarosa.ms_pagamento.dto.PagamentoDTO;
import com.github.cidarosa.ms_pagamento.entity.Pagamento;
import com.github.cidarosa.ms_pagamento.repository.PagamentoRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;



//@Transactional(readOnly = true)

    @Transactional(readOnly = true)
public List<PagamentoDTO> getAll(){
   List<Pagamento> pagamentos = repository.fincAll();

return pagamentos.stream()map(PagamentoDTO::new).colect(Collectors.toList());
}

}
