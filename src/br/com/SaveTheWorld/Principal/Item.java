package br.com.SaveTheWorld.Principal;

public class Item {

	private String nome;
	private String tipo;
	private Integer atributo;
	private String categoria;
	private Double preco;
	
	//MÉTODOS GETTERS & SETTERS
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
}
