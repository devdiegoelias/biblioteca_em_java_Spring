package br.bliblioteca.livros.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bliblioteca.livros.conversor.AvaliacaoConverter;
import br.bliblioteca.livros.dto.AvaliacaoDTO;
import br.bliblioteca.livros.model.Avaliacao;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.service.AvaliacaoService;
import br.bliblioteca.livros.service.LivroService;

@Service
public class ApiFacade {

	@Autowired
	LivroService livrosService;

	@Autowired
	AvaliacaoService avaliacaoServico;

	public List<Livro> listaTodosLivros() {
		return livrosService.listaTodosLivros();
	}

	public Long salvarAvaliacao(Long idLivro, AvaliacaoDTO avaliacaoDTO) {
		Livro livro = livrosService.buscaLivro(idLivro);
		Avaliacao avaliacao = AvaliacaoConverter.toModel(avaliacaoDTO, livro);
		return avaliacaoServico.salvaAvaliacao(avaliacao);
	}

}
