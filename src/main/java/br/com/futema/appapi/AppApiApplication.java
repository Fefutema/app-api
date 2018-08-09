package br.com.futema.appapi;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.futema.appapi.persistence.model.Categoria;
import br.com.futema.appapi.persistence.model.Cidade;
import br.com.futema.appapi.persistence.model.Estado;
import br.com.futema.appapi.persistence.model.Produto;
import br.com.futema.appapi.persistence.repository.CategoriaRepository;
import br.com.futema.appapi.persistence.repository.CidadeRepository;
import br.com.futema.appapi.persistence.repository.EstadoRepository;
import br.com.futema.appapi.persistence.repository.ProdutoRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class AppApiApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//-
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", new BigDecimal(2000));
		Produto p2 = new Produto(null, "Impressora", new BigDecimal(800));
		Produto p3 = new Produto(null, "Mouse", new BigDecimal(80));
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//--
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
	}
}
