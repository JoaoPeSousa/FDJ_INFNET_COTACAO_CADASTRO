package Repositorios;

import Classes.Fornecedor;

import java.util.ArrayList;

public class repositorioFornecedor {
    private static final ArrayList<Fornecedor> arrayFornecedores = new ArrayList<>();
    private final repositorioProduto repositorioProduto = new repositorioProduto(null, null);

    public repositorioFornecedor(String marca) {
        super();
    }

    public void dadosIniciais() {
        arrayFornecedores.add(new Fornecedor("Vaio"));
        arrayFornecedores.add(new Fornecedor("Apple"));
        arrayFornecedores.add(new Fornecedor("Xiaomi"));
    }

    public int addFornecedor(Fornecedor fornecedor) {
        arrayFornecedores.add(fornecedor);
        return fornecedor.getId();
    }

    public void editMarca(String marca, int idFornecedor) {
        var fornecedorExistente = getById(idFornecedor);
        if (fornecedorExistente == null) {
            System.out.println("Fornecedor não encontrado");
        } else {
            fornecedorExistente.setNomeFornecedor(marca);
        }
    }

    public Fornecedor showById(int id) {
        boolean variavelAuxiliar = true;
        for (Fornecedor item : arrayFornecedores) {
            if (item.getId() == id) {
                System.out.println("[ID do Produto]: " + item.getId());
                System.out.println("[Nome da marca]: " + item.getNomeFornecedor());
                return item;
            } else {
                variavelAuxiliar = false;
            }
        }

        if (!variavelAuxiliar) {
            System.out.println("Nada foi encontrado");
        }
        return null;
    }

    public Fornecedor getById(int id) {
        boolean variavelAux = true;
        for (Fornecedor item : arrayFornecedores) {
            if (item.getId() == id) {
                return item;
            } else {
                variavelAux = false;
            }
        }

        if (!variavelAux) {
            System.out.println("Nada foi encontrado");
        }
        return null;
    }

    public void deleteById(int id) {
        boolean variavelAux = true;
        for (Fornecedor item : arrayFornecedores) {
            if (item.getId() == id) {
                arrayFornecedores.remove(item);
                variavelAux = true;
                showList();
                break;
            } else {
                variavelAux = false;
            }
        }
        if (!variavelAux) {
            System.out.println("Nada foi encontrado");
        }
    }

    public int showByName(String nome) {
        Fornecedor fornecedor = null;
        if (arrayFornecedores.size() > 0) {
            for (Fornecedor item : arrayFornecedores) {
                if (item.getNomeFornecedor().equalsIgnoreCase(nome)) {
                    fornecedor = item;
                    System.out.println("Fornecedor: ");
                    System.out.println("[ID do produto]" + item.getId());
                    System.out.println("[Nome da marca]" + item.getNomeFornecedor());
                    break;
                }
            }
        }
        if (fornecedor != null) {
            return fornecedor.getId();
        } else {
            System.out.println("O fornecedor não existe, sera adicionado.");
            int idFornecedor = addFornecedor(new Fornecedor(nome));
            showList();
            return idFornecedor;
        }
    }

    public void showList() {
        for (Fornecedor item : arrayFornecedores) {
            System.out.println("-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println();

            System.out.println("[ID da marca]: " + item.getId());
            System.out.println("[Nome da marca]: " + item.getNomeFornecedor());
            System.out.println();

            System.out.println("-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

        }
    }


}
