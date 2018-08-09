package br.com.futema.appapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futema.appapi.exception.ObjectNotFoundException;
import br.com.futema.appapi.persistence.model.Categoria;
import br.com.futema.appapi.persistence.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscar() {
		return categoriaRepository.findAll();
	}
	
	public Categoria buscar(Long id) {
		Categoria categoria = 
					categoriaRepository.findById(id)
						.orElseThrow(() -> new ObjectNotFoundException
											("Object não encontrado id:" + id + 
														", class:" + Categoria.class.getName()));
		
		
		return categoria;
	}
	
	
	
}
