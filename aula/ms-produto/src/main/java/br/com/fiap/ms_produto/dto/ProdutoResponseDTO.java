package br.com.fiap.ms_produto.dto;

import br.com.fiap.ms_produto.entities.Produto;

import java.util.List;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor
) {
    public ProdutoResponseDTO(Produto entity){
        this(entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getValor());
    }


    }


