package domain;

public class Filme {
    private int id;
    private String nome;
    private String descricao;
    private int ano;

    public Filme(int id, String nome, String descricao, int ano) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ano = ano;
    }

    public void mostrarFilme() {
        System.out.println("( " + this.id + " ) Filme: " + this.nome + "| " + this.descricao + "| ano: " + this.ano);
    }
}
