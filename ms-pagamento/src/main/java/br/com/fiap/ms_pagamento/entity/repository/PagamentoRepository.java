package br.com.fiap.ms_pagamento.entity.repository;

import br.com.fiap.ms_pagamento.entity.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
