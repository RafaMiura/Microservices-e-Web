package checkp1.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EventoRequestDTO(

        Long id,

        @NotBlank(message = "Campo requerido!")
        @Size(min=3, max = 100, message = "O nome deve ter entre 3 e 100 caracters")
        String nome,


        @NotBlank(message = "Campo requerido!")
        @Future(message = "O evento deve ser mo formato ano-mês-dia")
        LocalDate data,

        @NotNull(message = "Campo requerido!")
        @Size(min=10, max = 255, message = "A url deve ter entre 10 a 255 caracteres")
        String url,

        @NotNull(message = "Campo requerido!")
        CidadeDTO cidade) {
}
