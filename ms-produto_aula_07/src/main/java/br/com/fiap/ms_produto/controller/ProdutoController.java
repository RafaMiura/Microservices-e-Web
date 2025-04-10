package br.com.fiap.ms_produto.controller;

import br.com.fiap.ms_produto.dto.ProdutoRequestDTO;
import br.com.fiap.ms_produto.dto.ProdutoResponseDTO;
import br.com.fiap.ms_produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Controller para produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Operation(
            description = "Listar Produtos",
            summary = "Retorna uma lista de produtos",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {

        List<ProdutoResponseDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Retorna um produto a partir do identificador (id)",
            summary = "Consulta produto por id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Not Found", responseCode = "404"
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) {

        ProdutoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Cria um novo produto",
            summary = "Salva um novo produto",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
//                    @ApiResponse(description = "Forbidden", responseCode = "403"),
//                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422"),
            })


    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> insert(@Valid @RequestBody ProdutoRequestDTO requestDTO) {

        ProdutoResponseDTO dto = service.insert(requestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @Operation(
            description = "Cria um novo produto",
            summary = "Salva um novo produto",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "201"),
                    @ApiResponse(description = "Not found", responseCode = "400"),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
//                    @ApiResponse(description = "Forbidden", responseCode = "403"),
//                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422"),

            })



    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Long id,
                                                     @Valid @RequestBody ProdutoRequestDTO requestDTO) {

        ProdutoResponseDTO dto = service.update(id, requestDTO);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Cria um novo produto",
            summary = "Salva um novo produto",
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "204"),
                    @ApiResponse(description = "Bad request", responseCode = "400"),
                    @ApiResponse(description = "Not found", responseCode = "404"),
//                  @ApiResponse(description = "Unauthorized", responseCode = "401"),
//                  @ApiResponse(description = "Forbidden", responseCode = "403"),
//                  @ApiResponse(description = "Unprocessable Entity", responseCode = "422"),

            })


    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}






