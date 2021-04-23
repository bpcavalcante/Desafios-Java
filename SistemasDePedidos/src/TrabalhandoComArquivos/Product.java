package TrabalhandoComArquivos;

public class Product {
	
	private String tipoProduto;
	private double valor;
	private int quantidade;
	
	public Product(String tipoProduto,double valor,int quantidade) {
		this.tipoProduto = tipoProduto;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
