package br.bliblioteca.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.bliblioteca.livros.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	@Query(value = " from #{#entityName} l left join fetch l.autor a order by l.nome asc ")
	List<Livro> listaLivros();
}