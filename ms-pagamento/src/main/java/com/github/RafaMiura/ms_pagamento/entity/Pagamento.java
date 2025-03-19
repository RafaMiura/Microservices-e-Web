package com.github.RafaMiura.ms_pagamento.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valor;
    private String nome;                // nome do cartão
    private String numeroCartao;        // xxxx xxxx xxxx xxxx
    private String validade;            //MM/AA
    private String codigoDeSeguranca;   // xxx
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Long pedidoId;
    @Column(nullable = false)
    private Long formaDePagamento;   // 1 - Dinheiro | 2 - cartão | 3 - pix

}
