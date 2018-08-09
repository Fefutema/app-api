package br.com.futema.appapi.controller;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@GetMapping("")
	public ResponseEntity<?> listar() {
		
		return  ResponseEntity.ok(Arrays.asList("Pao", "Ovo", "Feijao"));
	}
	
}
