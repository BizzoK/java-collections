package main.java.list.OperacoesBasicas;

public class Tarefa  {
    //atributo
    private String descricao;
    //constructor
    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
