package Main;

import Classes.Fornecedor;
import Classes.Produto;
import Classes.ProdutoCotacao;
import Erros.OpcoesException;
import Repositorios.repositorioFornecedor;
import Repositorios.repositorioFornecedorProd;
import Repositorios.repositorioProduto;

import java.util.Scanner;

public class Menu {
    repositorioProduto repositorioProduto = new repositorioProduto(null, null);
    repositorioFornecedor repositorioFornecedor = new repositorioFornecedor(null);
    repositorioFornecedorProd repositorioFornecedorProd = new repositorioFornecedorProd();
    Scanner sc = new Scanner(System.in);

    public Menu() throws OpcoesException {
        repositorioProduto.dadosIniciais();
        repositorioFornecedor.dadosIniciais();
        repositorioFornecedorProd.dadosIniciais();
    }

    public void MainMenu() throws Exception, OpcoesException {

        int id;
        String nome = "";
        String garantia = "";
        String data;
        int opcao = 0;
        boolean Erro = true;

        do {
            try {

                System.out.println("-_-_-_Menu do Assessment-_-_-_");
                System.out.println("");

                System.out.println("-_-_-_Produto-_-_-_");
                System.out.println("");

                System.out.println("[1] - Cadastrar Produtos");
                System.out.println("[2] - Excluir Produtos");
                System.out.println("[3] - Lista de Produtos Cadastrados");
                System.out.println("[4] - Editar Produtos");
                System.out.println("[5] -  Produto por ID");
                System.out.println("[6] -  Produto por Garantia");
                System.out.println("[7] -  produto por data (inserido no estqoue)");
                System.out.println("[8] -  Produto por Nome");
                System.out.println("");

                System.out.println("-_-_-Fornecedores-_-_-_");
                System.out.println("");

                System.out.println("[9] -  Fornecedores");
                System.out.println("[10] - Listar Fornecedores");
                System.out.println("[11] - Excluir Fornecedores");
                System.out.println("[12] - Editar Fornecedores");
                System.out.println("");
                System.out.println("-_-_-Consultar por-_-_-_");
                System.out.println("");

                System.out.println("[13] - Consultar Fornecedores por ID");
                System.out.println("[14] - Consultar Fornecedores por Nome");
                System.out.println("[15] - Cadastrar produto com cota????es");
                System.out.println("[16] - Cota????o por Produto");
                System.out.println("[17] - Cota????o por Fornecedor");
                System.out.println("[18] - Excluir Produto com Cota????o por Id");
                System.out.println("[19] - Listar Produtos com as cota????es");
                System.out.println("[20] - Sair do menu");
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.print("Insira o n??mero da op????o desejada: ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1:
                        do {
                            System.out.println("Nome do produto: ");
                            nome = sc.nextLine();

                            System.out.println("Garantia at?? (formato dd/mm/yy): ");
                            garantia = sc.nextLine();

                            if (garantia.isEmpty()) {
                                garantia = "Sem garantia";
                            }

                            if (nome.isEmpty()) {
                                System.out.println("?? necess??rio um nome!");
                            } else {
                                Erro = false;
                                repositorioProduto.addProduto(new Produto(nome, garantia, repositorioProduto.dataHoje()));
                                repositorioProduto.showList();
                            }
                        } while (Erro);
                        break;

                    case 2:
                        try {
                            System.out.println("ID do produto para exclus??o: ");
                            id = Integer.parseInt(sc.nextLine());
                            repositorioProduto.deleteProduto(id);

                        } catch (Exception e) {
                            throw new OpcoesException("?? necess??rio um ID para exclus??o");
                        }
                        break;


                    case 3:
                        repositorioProduto.showList();
                        break;
                    case 4:
                        try {
                            System.out.println("ID do produto para edi????o: ");
                            id = Integer.parseInt(sc.nextLine());
                            var produto = repositorioProduto.showById(id);

                            if (produto == null) {
                                System.out.println("Tente novamente");
                            } else {
                                System.out.println("Novo nome: ");
                                nome = sc.nextLine();

                                System.out.println("Insira uma nova garantia no formato(dd/mm/yyyy): ");
                                garantia = sc.nextLine();

                                if (garantia.isEmpty()) {
                                    garantia = "Sem garantia";
                                }
                                repositorioProduto.editProduto(new Produto(nome, garantia, repositorioProduto.dataHoje()), id);
                            }
                        } catch (Exception e) {
                            System.err.println("?? necess??rio um ID para prosseguir");
                        }
                        break;

                    case 5:
                        try {
                            System.out.println("ID do produto: ");
                            id = Integer.parseInt(sc.nextLine());
                            repositorioProduto.showById(id);
                        } catch (Exception e) {
                            System.out.println("?? necess??rio uma ID para prosseguir.");
                        }
                        break;

                    case 6:
                        try {
                            System.out.println("Insira a garantia no formato (dd/mm/yyyy): ");
                            garantia = sc.nextLine();
                            if (garantia.isEmpty()) {
                                garantia = "Sem garantia";
                            }
                            repositorioProduto.showDatas(garantia);
                        } catch (Exception e) {
                            System.out.println("Erro");
                        }
                        break;

                    case 7:
                        try {
                            System.out.println("Insira a data em que o produto foi inserido no estoque: ");
                            data = sc.nextLine();
                            if (data.isEmpty()) {
                                System.out.println("?? necess??rio inserir a data!");
                            }
                            repositorioProduto.listarPorDataInsercao(data);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 8:
                        try {
                            System.out.println("Qual produto deseja buscar? : ");
                            nome = sc.nextLine();
                            repositorioProduto.showByName(nome);

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 9:
                        do {
                            System.out.println("Nome da marca: ");
                            nome = sc.nextLine();

                            if (nome.isEmpty()) {
                                System.out.println("?? necess??rio um nome!");
                            } else {
                                Erro = false;
                                repositorioFornecedor.addFornecedor(new Fornecedor(nome));
                                repositorioFornecedor.showList();
                            }
                        } while (Erro);

                        break;

                    case 10:
                        repositorioFornecedor.showList();
                        break;

                    case 11:
                        try {
                            System.out.println("ID da marca para exclus??o: ");
                            id = Integer.parseInt(sc.nextLine());
                            repositorioFornecedor.deleteById(id);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 12:
                        try {
                            repositorioFornecedor.showList();
                            System.out.println("ID do fornecedor que deseja editar: ");
                            id = Integer.parseInt(sc.nextLine());
                            var fornecedor = repositorioFornecedor.getById(id);

                            if (fornecedor == null) {
                                System.out.println("Tente novamente");
                            } else {
                                System.out.println("Insira o novo nome: ");
                                nome = sc.nextLine();

                                repositorioFornecedor.editMarca(nome, id);
                                repositorioFornecedor.showList();
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 13:

                        try {
                            System.out.println("Insira o id da marca: ");
                            id = Integer.parseInt(sc.nextLine());
                            repositorioFornecedor.showById(id);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 14:

                        try {
                            System.out.println("Insira o nome da marca que deseja buscar: ");
                            nome = sc.nextLine();
                            repositorioFornecedor.showByName(nome);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;

                    case 15:

                        System.out.println("Insira o nome do produto: ");
                        nome = sc.nextLine();
                        int idProduto = repositorioProduto.showByName(nome);

                        System.out.println("Insira o fornecedor: ");
                        String nomeFornecedor = sc.nextLine();
                        int idCotacao = repositorioFornecedor.showByName(nomeFornecedor);

                        float preco = 0.0f;
                        System.out.print("Digite o valor do produto: ");
                        String precoProd = sc.nextLine();
                        if (precoProd.contains(",")) {
                            precoProd = precoProd.replace(",", ".");
                        }
                        preco = Float.parseFloat(precoProd);

                        repositorioFornecedorProd.addProdCota(new ProdutoCotacao(idProduto, idCotacao, preco));

                        break;

                    case 16:
                        System.out.println("Insira o nome do produto: ");
                        nome = sc.nextLine();
                        idProduto = repositorioProduto.searchByName(nome);
                        System.out.println("-_-_-_-_-_-_-_-_-_-_-_");
                        System.out.println("Cota????es:");
                        repositorioFornecedorProd.getProdById(idProduto);

                        break;

                    case 17:
                        System.out.println("Insira uma marca: ");
                        nome = sc.nextLine();
                        id = repositorioFornecedor.showByName(nome);

                        repositorioFornecedorProd.getCotaId(id);
                        break;

                    case 18:
                        repositorioFornecedorProd.showList();
                        System.out.println("Insira um id: ");
                        int idProdutoCotacao = Integer.parseInt(sc.nextLine());
                        repositorioFornecedorProd.deleteId(idProdutoCotacao);
                        break;

                    case 19:
                        repositorioFornecedorProd.showList();
                        break;
                    case 20:
                        return;

                    default:
                        System.out.println("Op????o n??o existe");
                }

            } catch (NumberFormatException e) {
                System.err.println("Digite um caracter v??lido (somente n??meros)");
                MainMenu();
            } catch (Exception e) {
                System.out.println("O valor n??o ?? v??lido. tente novamente." + e);
                MainMenu();
            } finally {
                System.out.println("Fim do programa" + "\n");
            }
        } while (opcao != 0);
        sc.close();
    }
}
