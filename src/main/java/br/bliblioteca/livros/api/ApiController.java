package br.bliblioteca.livros.api;

import static br.bliblioteca.livros.conversor.LivroConverter.toDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bliblioteca.livros.dto.AvaliacaoDTO;
import br.bliblioteca.livros.dto.LivroDTO;
import br.bliblioteca.livros.exception.LivroNotFoundException;
import br.bliblioteca.livros.facade.ApiFacade;
import br.bliblioteca.livros.model.Livro;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ApiFacade apiController;

	@GetMapping("/livros/list")
	public ResponseEntity<List<LivroDTO>> livros() {
		List<Livro> listaLivros = apiController.listaTodosLivros();
		return ResponseEntity.ok(toDTO(listaLivros));
	}

	@PostMapping("/livro/avaliacao/{id}")
	public ResponseEntity<Long> comentario(@PathVariable("id") Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
		try {
			return ResponseEntity.ok(apiController.salvarAvaliacao(id, avaliacaoDTO));
		} catch (LivroNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}