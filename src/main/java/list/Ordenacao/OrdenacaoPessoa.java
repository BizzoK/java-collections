package main.java.list.Ordenacao;

import main.java.list.OperacoesBasicas.ListaTarefa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoa {
    //atributo
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    //métodos
    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }
    public List<Pessoa> ordenarPorIdade(){
        //duplicando lista de pessoas para ordenar
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }
    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }
    //métod alternativo pelo chatGPT
    public List<Pessoa> ordenarPorNome() {
        List<Pessoa> pessoasPorNome = new ArrayList<>(pessoaList);
        pessoasPorNome.sort(Comparator.comparing(Pessoa::getNome));
        return pessoasPorNome;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adicionarPessoa("Carlos", 20, 1.60);
        ordenacaoPessoa.adicionarPessoa("Bianca", 30, 1.56);
        ordenacaoPessoa.adicionarPessoa("André", 22, 1.70);
        ordenacaoPessoa.adicionarPessoa("Danilo", 18, 1.80);

        System.out.println(ordenacaoPessoa.pessoaList);

        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println(ordenacaoPessoa.ordenarPorAltura());
        System.out.println(ordenacaoPessoa.ordenarPorNome());
    }

}
