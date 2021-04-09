package Repositorios;

import Classes.Produto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class repositorioProduto {


    private static final ArrayList<Produto> arrayProdutos = new ArrayList<Produto>();
    String garantia = "";

    public repositorioProduto(String nome, String dataValidade) {
        super();
    }

    public Produto getId(int id) {
        boolean variavelAuxiliar = true;
        Produto produto = new Produto();
        for(Produto item : arrayProdutos) {
            if (item.getId() == id) {
                produto = item;
                variavelAuxiliar = true;
                break;
            }else {
                variavelAuxiliar = false;
            }
        }
        if (!variavelAuxiliar){
            System.out.println("Nada foi encontrado");
        }
        return produto;
    }

    public void dadosIniciais() {
        arrayProdutos.add(new Produto("Notebook", "23/04/2022", dataHoje()));
        arrayProdutos.add(new Produto("Iphone", "13/11/2023", dataHoje()));
        arrayProdutos.add(new Produto("Smart Watch", "12/04/2023", dataHoje()));
    }

    public Produto showById(int id) {
        boolean variavelAux = true;
        Produto produto = new Produto();
        for(Produto item : arrayProdutos) {
            if (item.getId() == id) {
                produto = item;
                System.out.println("[ID do produto]: " +item.getId());
                System.out.println("[Nome do produto]: " + item.getNome());
                System.out.println("[Garantia do produto]: " + item.getData());
                System.out.println("[Data (inserido no estoque]: " + item.getDataCadastro());
                variavelAux = true;
                break;
            }else {
                variavelAux = false;
            }
        }
        if (!variavelAux){
            System.out.println("Nada foi encontrado");
        }
        return produto;
    }

    public int addProduto(Produto produto){
        arrayProdutos.add(produto);
        return produto.getId();
    }

    public void deleteProduto(int id) {
        boolean variavelAux = true;
        for(Produto item : arrayProdutos) {
            if (item.getId() == id) {
                arrayProdutos.remove(item);
                variavelAux = true;
                showList();
                break;
            }else {
                variavelAux = false;
            }
        }

        if (!variavelAux){
            System.out.println("Nada foi encontrado");
        }
    }

    public void showDatas(String data) {
        for(Produto item : arrayProdutos) {
            if(item.getData().equals(data)) {
                System.out.println("[ID do Produto]: " + item.getId());
                System.out.println("[Nome do Produto]: " + item.getNome());
                System.out.println("[Garantia até]: " + item.getData());
                System.out.println("[Data (inserido no estoque]: " + item.getDataCadastro());
            }
        }
        if (!arrayProdutos.contains(data)) {
            System.out.println("Data não é valida.");
        }
    }

    public void editProduto(Produto produto, int id){
        Produto produtoExistente = getId(id);

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setData(produto.getData());
        produtoExistente.setDataCadastro(dataHoje());
        showList();
    }

    public void listarPorDataInsercao(String data) {
        for(Produto item : arrayProdutos) {
            if(item.getDataCadastro().equals(data)) {
                System.out.println("-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.println("");
                System.out.println("[ID do Produto]: " + item.getId());
                System.out.println("[Nome do Produto]: " + item.getNome());
                System.out.println("[Garantia até]: " + item.getData());
                System.out.println("[Data (inserido no estoque]: " + item.getDataCadastro());
                System.out.println("");
                System.out.println("-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            }
        }
        if (!arrayProdutos.contains(data)) {
            System.out.println("Data inválida!");
        }
    }

    public int showByName(String nomeProduto) {

        Produto produto = null;
        boolean variavelAuxiliar = true;
        if(arrayProdutos.size() > 0) {
            for(Produto item : arrayProdutos) {
                if(item.getNome().equalsIgnoreCase(nomeProduto)) {
                    System.out.println("ID do Produto: " + item.getId());
                    System.out.println("Nome do produto: " + item.getNome());
                    System.out.println("Garantia até: " + item.getData());
                    System.out.println("Data (inserido no estoque): " + item.getDataCadastro());
                    produto = item;
                    variavelAuxiliar = true;
                }else {
                    variavelAuxiliar = false;
                }
            }
            if(!variavelAuxiliar) {

                System.out.println("Produto não existe, cadastrando...");
                int idProduto = addProduto(new Produto(nomeProduto, garantia, dataHoje()));
                showList();
                return idProduto;

            }

        }

        if(produto != null) {
            return produto.getId();
        }else {
            return addProduto(new Produto(nomeProduto, "sem garantia", dataHoje()));
        }

    }

    public int showByGarantia(String garantiaProd) {

        Produto produto = null;
        boolean variavelAuxiliar = true;
        if(arrayProdutos.size() > 0) {
            for(Produto item : arrayProdutos) {
                if(item.getNome().equalsIgnoreCase(garantiaProd)) {
                    System.out.println("ID do Produto: " + item.getId());
                    System.out.println("Nome do produto: " + item.getNome());
                    System.out.println("Garantia até: " + item.getData());
                    System.out.println("Data (inserido no estoque): " + item.getDataCadastro());
                    produto = item;
                    variavelAuxiliar = true;
                }else {
                    variavelAuxiliar = false;
                }
            }
            if(!variavelAuxiliar) {

                System.out.println("Produto não existe, cadastrando...");
                int garantiaProduto = addProduto(new Produto(garantiaProd, garantia, dataHoje()));
                showList();
                return garantiaProduto;

            }

        }

        if(produto != null) {
            return produto.getId();
        }else {
            return addProduto(new Produto(garantiaProd, "sem garantia", dataHoje()));
        }

    }

    public void showList(){
        for(Produto produto : arrayProdutos) {
            System.out.println("-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Garantia: " + produto.getData());
            System.out.println("Data (inserido no estoque): " + produto.getDataCadastro());
            System.out.println("");
            System.out.println("-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

        }
    }

    public int searchByName(String nomeProduto) {
        boolean variavelAuxiliar = true;
        Produto produto = null;
        if(arrayProdutos.size() > 0) {
            for(Produto item : arrayProdutos) {
                if(item.getNome().equalsIgnoreCase(nomeProduto)) {
                    produto = item;
                    variavelAuxiliar = true;
                    break;
                }else {
                    variavelAuxiliar = false;
                }
            }
        }

        if(variavelAuxiliar) {
            assert produto != null;
            System.out.println("[ID do produto]: " + produto.getId());
            System.out.println("[Nome do produto]: " + produto.getNome());
            System.out.println("[Garantia do produto]: " + produto.getData());
            System.out.println("[Data do cadastro]: " + produto.getDataCadastro());
            return produto.getId();
        }else {
            return addProduto(new Produto(nomeProduto, "Sem garantia", dataHoje()));
        }
    }

    public String dataHoje() {
        Date hoje = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(hoje);
    }

}
