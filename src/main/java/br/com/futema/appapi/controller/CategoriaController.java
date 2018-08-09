package br.com.futema.appapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.futema.appapi.persistence.model.Categoria;
import br.com.futema.appapi.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping()
	public ResponseEntity<?> listar() {
		
		return ResponseEntity.ok(categoriaService.buscar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		
		Categoria categoria = categoriaService.buscar(id);
		
		return ResponseEntity.ok(categoria);			
		
	}
	
}
