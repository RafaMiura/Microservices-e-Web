package checkp1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;





@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_evento")
public class Evento {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate data;
    private String url;


    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;


}
