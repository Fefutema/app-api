package br.com.futema.appapi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futema.appapi.persistence.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{


}
