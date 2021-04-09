package Classes;

public class ProdutoCotacao {
    private int idProdutoCotacao;
    private int idProduto;
    private int idCotacao;
    private Float preco;
    public static int addId = 1;
//construtores

    public ProdutoCotacao(int idProduto, int idCotacao, Float preco) {
        this.idProdutoCotacao = ProdutoCotacao.addId;
        ProdutoCotacao.addId++;
        this.setId_cotacao(idCotacao);
        this.setId_produto(idProduto);
        this.setPreco(preco);
    }
//getter e setters
    public int getIdProdutoCotacao() {
        return this.idProdutoCotacao;
    }

    public void setIdProdutoCotacao(int idProdutoCotacao) {
        this.idProdutoCotacao = idProdutoCotacao;
    }

    public int getId_cotacao() {
        return this.idCotacao;
    }

    public void setId_cotacao(int idCotacao) {
        this.idCotacao = idCotacao;
    }

    public int getId_produto() {
        return this.idProduto;
    }

    public void setId_produto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
