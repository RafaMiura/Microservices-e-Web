package checkp1.dto;

import checkp1.entities.Evento;

import java.time.LocalDate;

public record EventoResponseDTO(
        Long id,
        String nome,
        LocalDate data,
        String url,
        CidadeDTO cidade
) {

    public EventoResponseDTO(Evento entity) {
        this(entity.getId(),
                entity.getNome(),
                entity.getData(),
                entity.getUrl(),
                new CidadeDTO(entity.getCidade()));
    }



}

