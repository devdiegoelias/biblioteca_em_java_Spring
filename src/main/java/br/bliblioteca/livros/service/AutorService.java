package br.bliblioteca.livros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bliblioteca.livros.model.Autor;
import br.bliblioteca.livros.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;

	public List<Autor> listaAutores() {
		return autorRepository.findAll();
	}

	public void salvarAutor(Autor autor) {
		autorRepository.save(autor);
	}

	public Autor buscaAutor(Long id) {
		return autorRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public void excluiAutor(Long id) {
		autorRepository.deleteById(id);
	}

}
