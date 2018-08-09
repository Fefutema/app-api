package br.com.futema.appapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futema.appapi.persistence.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{


}
