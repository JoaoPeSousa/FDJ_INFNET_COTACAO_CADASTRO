package Classes;

public class Produto {
    private int id;
    private String nome;
    private String garantia;
    private String data;
    public static int addId = 1;
//construtores
    public Produto() {
        super();
    }


    public Produto(String nome, String garantia, String data) {
        this.id = Produto.addId;
        Produto.addId++;
        this.nome = nome;
        this.garantia = garantia;
        this.data = data;
    }
//getter e setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCadastro() {
        return this.data = data;
    }

    public void setDataCadastro(String data) {
        this.data = data;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return this.garantia;
    }

    public void setData(String data) {
        this.garantia = data;
    }
}
