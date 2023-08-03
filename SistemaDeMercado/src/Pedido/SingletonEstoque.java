package Pedido;

import Backup.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SingletonEstoque {//TEORICAMENTE TA TUDO FUNFANDO AQUI
    Scanner sc = new Scanner(System.in);
    private static SingletonEstoque instancia = null;
    private List<Produto> ListaDeProdutos;
    private ItemPedido item;

    private SingletonEstoque(){
        ListaDeProdutos = new ArrayList<Produto>();
    }
    public static SingletonEstoque criarEstoque(){
        if(instancia == null){
            return instancia = new SingletonEstoque();
        }else{
            return instancia;
        }
    }
    public void AddProduto(Produto produto){
        ListaDeProdutos.add(produto);
    }
    public void ProcurarProduto(String id, int quant , Pedido pedido){
        ItemPedido item;
        for(Produto prod: ListaDeProdutos){
            if(id.equals(prod.getID())){
               if(quant > prod.getQuantidade()){
                   System.out.println("O estoque nao possue essa quantidade" + "\n");
                   System.out.println("(1)-Pegar tudo no estonque ? \n(0)-Nao Pegar o Pedido.Produto ! " );
                    int resp = sc.nextInt();
                   if(resp == 1){
                       item = new ItemPedido(prod.getID(), prod.getNome(), prod.getQuantidade(), prod.getPreco());
                       prod.setQuantidade(0);
                       pedido.AddItem(item);
                       break;
                   }else{
                       item = new ItemPedido(prod.getID(), prod.getNome(), 0, prod.getPreco());
                       pedido.AddItem(item);
                       break;
                   }
               }
                item = new ItemPedido(prod.getID(), prod.getNome(), quant, prod.getPreco());
                prod.setQuantidade(prod.getQuantidade() - quant);
                pedido.AddItem(item);
            }
        }
    }

    public void VerificacaoDoEstoque(){
        String s="";
        int i=0, j=1;
        System.out.println("//----------Produtos----------//");
        for(Produto prod : ListaDeProdutos){
            System.out.printf("------------Produtor de numero %d", j);
            i = prod.getQuantidade();
            s = prod.InformacoesProduto();
             if(i < 10) {
                 s = "\n!!---Este produto estao em falta ou quase acabando no estoque---!!\n" + s + "\n";
                 System.out.printf(s);
             }else{
                 s = "\n" + s + "\n";
                 System.out.printf(s);
             }
             j++;
        }
    }
    public void Repor(String id, int quant){
        for(Produto prod: ListaDeProdutos){
            if(id.equals(prod.getID())){
                System.out.printf("O Pedido.Produto: %s de ID: %s tinha em estoque uma quantia de: %d ", prod.getNome(), prod.getID(), prod.getQuantidade());
                prod.setQuantidade(prod.getQuantidade() + quant);
                System.out.printf("\nAgora ele tem: %d\n", prod.getQuantidade());
                break;
            }
        }
    }
    public Boolean ExisteProduto(String id){
        for(Produto prod: ListaDeProdutos) {
            if (id.equals(prod.getID())) {
                return true;
            }
        }
        return false;
    }
    public void Limpar(){
        ListaDeProdutos.clear();
    }
    public Memento CriarBackup(){
        return new Memento(this, ListaDeProdutos);
    }

    public static SingletonEstoque getInstancia() {
        return instancia;
    }

    public static void setInstancia(SingletonEstoque instancia) {
        SingletonEstoque.instancia = instancia;
    }
}
