package br.bliblioteca.livros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bliblioteca.livros.exception.LivroNotFoundException;
import br.bliblioteca.livros.model.Livro;
import br.bliblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	public List<Livro> listaTodosLivros() {
		return livroRepository.listaLivros();
	}

	public void salvarLivro(Livro livro) {
		livroRepository.save(livro);
	}

	public Livro buscaLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new LivroNotFoundException());
	}

	public void excluiLivro(Long id) {
		livroRepository.deleteById(id);
	}

}