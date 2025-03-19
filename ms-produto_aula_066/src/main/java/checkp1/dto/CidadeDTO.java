package checkp1.dto;

import checkp1.entities.Cidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class CidadeDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio, nulo ou em branco")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres")
    private String nome;


    @NotBlank(message = "O estado não pode ser vazio, nulo ou em branco")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres")
    private String estado;


    @NotBlank(message = "A uf não pode ser vazia, nula ou em branco")
    @Size(min = 2, max = 2, message = "A uf deve ter somente 2 caracteres")
    private String uf;

    public CidadeDTO(Cidade entity) {
        id = entity.getId();
        nome = entity.getNome();
        estado = entity.getEstado();
        uf = entity.getUf();
    }
}
