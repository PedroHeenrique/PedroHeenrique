package webService.livraria_virtual;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "livro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Livro {

	@XmlAttribute
	private Long id;
	@XmlElement
	private String isbn;
	@XmlElement
	private String genero;
	@XmlElement
	private Double preco;
	@XmlElement
	private List<Autor> autor = new ArrayList<>();

	public Livro() {
	}

	public Livro(Long id, String isbn, String genero, Double preco, String... autor ) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.genero = genero;
		this.preco = preco;

		for (String nome : autor) {
			this.autor.add(new Autor(nome));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}

}
