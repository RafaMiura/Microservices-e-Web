package com.github.cidarosa.ms_pagamento.dto;


import com.github.cidarosa.ms_pagamento.entity.Pagamento;
import com.github.cidarosa.ms_pagamento.entity.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.Message;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoDTO {

    private Long id;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor do pagamento deve ser um número positivo")
    private BigDecimal valor;

    @Size(min = 2, max = 6, message = "O nome deve ter entre 2 e 6 caracteres")
    private String nome;

    @Size(min = 16, max = 19, message = "O número do cartão deve ter entre 16 e 19 carcteres")
    private String numeroDoCartao;

    @Size(min = 5, max = 5, message = "A validade do cartão deve ter 5 caracteres")
    private String validade;
    @Size(min = 3, max = 3, message = "O código de segurança deve ter 3 caracteres")
    private String codigoDeSeguranca;

    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull(message = "Pedido ID é obrigatório")

    private Long pedidoId;

    @NotNull(message = "Forma de pagamento ID é obrigatório")
    private Long formaDePagamentoId;

        public PagamentoDTO(Pagamento entity){
         id = entity.getId();
         valor = entity.getValor();
         nome = entity.getNome();
         numeroDoCartao = entity.getNumeroDoCartao();
         validade = entity.getValidade();
         codigoDeSeguranca = entity.getCodigoDeSeguranca();
         status = entity.getStatus();
         pedidoId = entity.getId();
         formaDePagamentoId = entity.getFormaDePagamentoId();
    }
}
