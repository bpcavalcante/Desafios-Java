package TrabalhandoComArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;

public class Principal {

	public static void main(String[] args) throws IOException {

		String path = "C:\\Users\\bruno\\Documents\\produtosjava.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Product product;
			ArrayList<Product> produtos = new ArrayList<Product>();

			String[] nomes;
			String line = br.readLine();
			while (line != null) {

				nomes = line.split(",");
				String nomeProduto = nomes[0];
				double valorProduto = Double.parseDouble(nomes[1]);
				int quantidadeProduto = Integer.parseInt(nomes[2]);
				product = new Product(nomeProduto, valorProduto, quantidadeProduto);
				produtos.add(product);
				line = br.readLine();
			}

			System.out.println(produtos.get(0).getTipoProduto());
			System.out.println(produtos.get(0).getValor());
			System.out.println(produtos.get(0).getQuantidade());

			String path1 = "C:\\Users\\bruno\\Documents";
			boolean paste = new File(path1 + "\\out").mkdir();
			String path2 = "C:\\Users\\bruno\\Documents\\out\\summary.csv";
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
				for (int i = 0; i <= 3; i++) {
					bw.write(produtos.get(i).getTipoProduto() + ","
							+ (produtos.get(i).getValor() * produtos.get(i).getQuantidade()));
					bw.newLine();
				}
			}

		} catch (IIOException e) {
			System.out.println("Erro:" + e.getMessage());
		}

	}

}
