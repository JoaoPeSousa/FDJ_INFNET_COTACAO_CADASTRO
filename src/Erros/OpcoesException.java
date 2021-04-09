package Erros;

public class OpcoesException extends Exception{
    private String msgError = "";

    public OpcoesException(String msg) {
        super(msg);
        if ("id".equals(msg)) {
            msgError = "Input de ID inválido, tente novamente";
        } else if ("nome".equals(msg)) {
            msgError = "Insira um nome valido!.";
        } else if ("cotacao".equals(msg)) {
            msgError = "Cotacao invalida";
        } else if ("marca".equals(msg)) {
            msgError = "É necessário inserir uma marca!";
        }
    }

    OpcoesException() {
        msgError = "Erro desconhecido";
    }

    @Override
    public String getMessage() {
        return msgError;
    }
}
