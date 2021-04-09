package Repositorios;

import Classes.Fornecedor;
import Classes.Produto;
import Classes.ProdutoCotacao;

import java.util.ArrayList;

public class repositorioFornecedorProd {
    private final ArrayList<ProdutoCotacao> arrayProdCota = new ArrayList<ProdutoCotacao>();
    private final repositorioProduto repositorioProduto = new repositorioProduto(null, null);
    private final repositorioFornecedor repositorioFornecedor = new repositorioFornecedor(null);

    public void dadosIniciais() {
        arrayProdCota.add(new ProdutoCotacao(1, 1, 5000.0f));
        arrayProdCota.add(new ProdutoCotacao(2, 2, 7000.0f));
        arrayProdCota.add(new ProdutoCotacao(3, 3, 2000.5f));
    }

    public void addProdCota(ProdutoCotacao produtoCotacao) {
        arrayProdCota.add(produtoCotacao);
        showList();
    }

    public void showList(){
        for(ProdutoCotacao item : arrayProdCota) {
            Produto produto = repositorioProduto.getId(item.getId_produto());
            Fornecedor fornecedor = repositorioFornecedor.getById(item.getId_cotacao());
            System.out.println("-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_");
            System.out.println("");

            System.out.println("ID do produto: " + item.getIdProdutoCotacao());
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Marca: " + fornecedor.getNomeFornecedor());
            System.out.println("Preço do produto: R$" + String.format("%.2f", item.getPreco()));
            System.out.println("");

            System.out.println("-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_");
        }
    }

    public void getCotaId(int idCotacao){
        for(ProdutoCotacao item : arrayProdCota) {
            if (item.getId_cotacao()==idCotacao) {
                Produto produto = repositorioProduto.getId(item.getId_produto());
                Fornecedor fornecedor = repositorioFornecedor.getById(item.getId_cotacao());
                System.out.println("-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_");

                System.out.println("");
                System.out.println("Nome do produto: " + produto.getNome());
                System.out.println("Data: " + produto.getData());
                System.out.println("Marca: " + fornecedor.getNomeFornecedor());
                System.out.println("Preço do produto: R$ " + String.format("%.2f", item.getPreco()));
                System.out.println("");
                System.out.println("-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_-_-_-___-_-_-_");

            }
        }
    }

    public void getProdById(int idProduto){
        for(ProdutoCotacao item : arrayProdCota) {
            if(item.getId_produto() == idProduto) {
                Produto produto = repositorioProduto.getId(item.getId_produto());
                Fornecedor fornecedor = repositorioFornecedor.showById(item.getId_cotacao());

                System.out.println("Nome do produto: " + produto.getNome());
                System.out.println("Data: " + produto.getData());
                System.out.println("Marca: " + fornecedor.getNomeFornecedor());
                System.out.println("Preço do produto: R$ " + String.format("%.2f", item.getPreco()));
                System.out.println("");
            }
        }
    }

    public void deleteId(int id) {
        boolean variavelAux = true;
        for (ProdutoCotacao item : arrayProdCota) {
            if(item.getIdProdutoCotacao() == id) {
                arrayProdCota.remove(item);
                variavelAux = true;
                showList();
                break;
            }else {
                variavelAux = false;
            }
        }
        if (!variavelAux){
            System.out.println("O item buscado não existe!");
        }
    }
}
