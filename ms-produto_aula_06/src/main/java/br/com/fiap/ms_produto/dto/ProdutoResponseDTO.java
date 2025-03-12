package br.com.fiap.ms_produto.dto;

import br.com.fiap.ms_produto.entities.Categoria;
import br.com.fiap.ms_produto.entities.Produto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor,
        CategoriaDTO categoria
) {

    // Construtor retorna um Entity
    public ProdutoResponseDTO(Produto entity) {
        this(entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getValor(),
                new CategoriaDTO(entity.getCategoria()));
    }
}
