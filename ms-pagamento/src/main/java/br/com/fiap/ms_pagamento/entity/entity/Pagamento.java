package br.com.fiap.ms_pagamento.entity.entity;


import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valor;
    private String nome;                //nome no cartão
    private String numeroDoCartao;      //xxxx xxxx xxxx xxxx
    private String validade;            //MM/AA

    private String codigoDeSeguranca;   // xxx
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)

    private Status status;
    @Column(nullable = false)
    private Long pedidoId;
    @Column(nullable = false)
    private Long formaDePagamentoId;    // 1 - dinheiro | 2 - cartão | 3 - pix


    public void setStatus(br.com.fiap.ms_pagamento.entity.entity.Status status) {
    }

    public void setStatus(Status status) {
    }
}
