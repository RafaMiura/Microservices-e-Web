package br.com.fiap.ms_produto.repositories;

import br.com.fiap.ms_produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
