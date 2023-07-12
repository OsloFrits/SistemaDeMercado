import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Pedido {
    Scanner sc = new Scanner(System.in);
    private Cliente cliente;
    private List<ItemPedido> pedidos = new ArrayList<ItemPedido>();
    private double taxa, valor=0, troco;
    private int formapag, entrega, numero;
    private  String dataAtual;

    public Pedido(){//CONSTRUCTOR PARA USAR NO FACADE

    }

    public Pedido(int entrega, double troco) {
        SinglentonCadastros cadastros = SinglentonCadastros.getInstancia();
       do {
           System.out.println("PorFavor digite o numero de telefone do cliente:");
           numero = sc.nextInt();
           if (cadastros.existeCliente(numero)) {
               cliente = cadastros.BuscarCliente(numero);
               this.entrega = entrega;
               if (entrega == 1) {
                   taxa = 20;
               } else {
                   taxa = 00;
               }
               this.troco = troco;
               dataAtual = getDateTime();
           } else {
               System.out.println("Cleinte nao consta nos casdastros :(");
           }
       }while(!cadastros.existeCliente(numero));
    }
    public void ProcuraDeProduto(String id, int quant){
       SingletonEstoque estoque = SingletonEstoque.getInstancia();
       estoque.ProcurarProduto(id, quant ,this);
    }
    public void AddItem(ItemPedido item){
        pedidos.add(item);
    }
    public double obterPrecoTotal(){
        for(ItemPedido prod : pedidos) {
            valor = valor + prod.getQuantidade() * prod.getPreco() + getTaxa();
        }
        return valor;
    }
    public String toString(){
        String s = "";
        for(ItemPedido prod: pedidos){
            s = s + prod.getPreco() + " " + prod.getQuantidade() + " " + prod.getID() + " " + prod.getProduto() + " ";
            return "produto: " + s;
        }
        return "0";
    }
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public String informacoes(){
        String s="";
        s = String.format("%sNome: %s\nCpf: %d\nNumero: %d\nEndereço: %s", s, cliente.getNome(), cliente.getCpf(), cliente.getNumero(), cliente.getEndereço());
        return s;
    }

    public List<ItemPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemPedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public int isEntrega() {
        return entrega;
    }

    public void setEntrega(int entrega) {
        this.entrega = entrega;
    }

    public int getFormapag() {
        return formapag;
    }

    public void setFormapag(int formapag) {
        this.formapag = formapag;
    }

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
