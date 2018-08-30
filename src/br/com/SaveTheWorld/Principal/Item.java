package br.com.SaveTheWorld.Principal;

public class Item {

	private Integer id;
	private String nome;
	private String tipo;
	private Integer atributo;
	private String categoria;
	private Double preco;
	
	//MÉTODO CONSTRUCTOR
	public Item(Integer id, String nome, String tipo, Integer atributo, String categoria, Double preco){
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.atributo = atributo;
		this.categoria = categoria;
		this.preco = preco;
	}
	
	//MÉTODOS GETTERS & SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getAtributo() {
		return atributo;
	}
	public void setAtributo(Integer atributo) {
		this.atributo = atributo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "-" + " Nome: " + nome + " | Categoria: " + categoria + " | Atributo: "
				+ atributo + " - " + tipo + " | Preço: " + preco;
	}
	
}
