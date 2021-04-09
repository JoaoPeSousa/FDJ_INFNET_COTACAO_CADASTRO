package Classes;

public class Fornecedor {
    private int id;
    private String nomeFornecedor;
    public static int addId = 1;
//construtores

    public Fornecedor() {
        super();
    }

    public Fornecedor(String nomeFornecedor) {
        this.id = Fornecedor.addId;
        Fornecedor.addId++;
        this.nomeFornecedor = nomeFornecedor;
    }
//getter e setters

    public int getId() {
        return this.id;
    }

    public String getNomeFornecedor() {
        return this.nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public void setId(int id) {
        this.id = id;
    }
}
