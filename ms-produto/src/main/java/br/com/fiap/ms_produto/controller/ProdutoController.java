package br.com.fiap.ms_produto.controller;

import br.com.fiap.ms_produto.dto.ProdutoResponseDTO;
import br.com.fiap.ms_produto.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<ProdutoResponseDTO> getProduto(){
        // Utilizando record com dados mockados
        // somente para entendimento e testes
        ProdutoResponseDTO dto = ProdutoResponseDTO.createMock();
        return ResponseEntity.ok(dto);

    }






}
