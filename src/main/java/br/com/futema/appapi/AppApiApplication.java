package br.com.futema.appapi;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.futema.appapi.persistence.model.Categoria;
import br.com.futema.appapi.persistence.model.Produto;
import br.com.futema.appapi.persistence.repository.CategoriaRepository;
import br.com.futema.appapi.persistence.repository.ProdutoRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class AppApiApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Banho");
		
		Produto p1 = new Produto(null, "Computador", new BigDecimal(2000));
		Produto p2 = new Produto(null, "Impressora", new BigDecimal(800));
		Produto p3 = new Produto(null, "Mouse", new BigDecimal(80));
		Produto p4 = new Produto(null, "Tapete de banho", new BigDecimal(35));
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		c3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		p4.getCategorias().addAll(Arrays.asList(c3));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}
}
