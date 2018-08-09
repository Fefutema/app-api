package br.com.futema.appapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futema.appapi.persistence.model.Produto;
import br.com.futema.appapi.persistence.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscar() {
		return produtoRepository.findAll();
	}
	
	public Produto buscar(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	
	
}
