package br.com.fiap.ms_produto.dto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor
) {
    /*static fact
     */

    public static ProdutoResponseDTO createMock(){
        return new ProdutoResponseDTO(1L, "Smart TV", "Smart TC LG LED 29 polegadas", 2990.0);
    }

}
