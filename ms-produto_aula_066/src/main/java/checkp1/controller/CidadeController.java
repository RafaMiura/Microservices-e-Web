package checkp1.controller;


import checkp1.dto.CidadeDTO;
import checkp1.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {


    @Autowired
    private CidadeService service;



    @GetMapping
    public ResponseEntity<List<CidadeDTO>> findAll(){
        List<CidadeDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> findById(@PathVariable Long id){

        CidadeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    /*@PostMapping
    public ResponseEntity<CidadeDTO> insert (@RequestBody CidadeDTO dto){
        Cidade entity = new Cidade();
        copyDtoToEntity(dto, entity);
        return new CidadeDTO(entity);
    }*/

    @PostMapping
    public ResponseEntity<CidadeDTO> create (@RequestBody @Valid CidadeDTO dto){

         dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("{/id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping
    public ResponseEntity<CidadeDTO> update (@PathVariable Long id, @RequestBody @Valid CidadeDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
