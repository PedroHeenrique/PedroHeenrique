package webService.livraria_virtual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioLivros {

	private Map<Long, Livro> livros = new HashMap<>();

	private static RepositorioLivros repositorio;

	public static RepositorioLivros getInstance() {
		if (repositorio == null) {
			repositorio = new RepositorioLivros();
		}

		return repositorio;

	}

	private RepositorioLivros() {
		Livro livroUm = new Livro(1l, "Java", "ISBN-1234", 150.00, "Peter Jandl");
		Livro livro2 = new Livro(1l, "Banco", "ISBN-5678", 35.0, "asdfasdf sadf");

		livros.put(livroUm.getId(), livroUm);
		livros.put(livro2.getId(), livro2);
	}

	public List<Livro> getLivros() {
		return new ArrayList<Livro>(livros.values());
	}

	public Livro getLivroPorIsbn(String isbn) {
		for (Livro livro : livros.values()) {
			if (isbn.equals(livro.getIsbn())) {
				return livro;
			}
		}
		throw new LivroNaoEncontradoException();

	}

	public void adicionaLivro(Livro livro) {
		if (livros.containsKey(livro.getId())) {
			throw new LivroExistenteException();
		}
		livros.put(livro.getId(), livro);
	}

	public void atualizaLivro(Livro livro) {
		livros.put(livro.getId(), livro);
	}
	
	public void removerLivro (Long idLivro) {
		if(livros.containsKey(idLivro)) {
			livros.remove(idLivro);
		}else {
			throw new LivroNaoEncontradoException();
		}
	}
}
