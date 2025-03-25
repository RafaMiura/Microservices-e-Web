package br.com.fiap.ms_pagamento.entity.dto;



import br.com.fiap.ms_pagamento.entity.entity.Pagamento;
import ch.qos.logback.core.status.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoDTO {

    private Long id;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor do pagamento deve ser um número positivo")
    private BigDecimal valor;

    @Size(max = 100, message = "O nome deve até 100 caracteres")
    private String nome;

    @Size(max = 19, message = "O número do cartão deve ter no máximo 19 carcteres")
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

     public PagamentoDTO (Pagamento entity){
         id = entity.getId();
         valor = entity.getValor();
         nome = entity.getNome();
         numeroDoCartao = entity.getNumeroDoCartao();
         validade = entity.getValidade();
         codigoDeSeguranca = entity.getCodigoDeSeguranca();
         status = entity.getStatus();
         pedidoId = entity.getPedidoId();
         formaDePagamentoId = entity.getId();

    }
}
