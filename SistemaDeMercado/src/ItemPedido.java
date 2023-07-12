public class ItemPedido {
    private Produto produto;
    private String ID, nome;
    private int quantidade;
    private double preco;

    public ItemPedido(String ID, String nome, int quantidade, double preco) {
        this.ID = ID;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
