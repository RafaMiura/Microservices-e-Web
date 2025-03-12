package br.com.fiap.ms_produto.controller;

import br.com.fiap.ms_produto.dto.CategoriaDTO;
import br.com.fiap.ms_produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriaController {


    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
