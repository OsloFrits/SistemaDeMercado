import java.io.Serializable;

public class Produto implements Serializable { //TA FUNCIONADO
    private String nome, ID;
    private int quantidade;
    private double preco;

    public Produto(String nome, String ID, int quantidade, double preco) {
        this.nome = nome;
        this.ID = ID;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String InformacoesProduto(){
        return "Nome: " + getNome() + "\nID: " + getID() + "\nQuantidade em estoque: " + getQuantidade() + "\nPreço: $" + getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
