import java.util.Scanner;
public class Facade {//ACHO QUE FUNCIONA
    Scanner sc = new Scanner(System.in);
    private int resp=0;
    private Pedido pedido = null;
    private SubFacade subFacade = null;
    private double troco;

    public Facade(){
        this.pedido =  new Pedido();
        this.subFacade = new SubFacade();
    }

    public void RealizarVenda(){
        System.out.println("Sera nescessario entregar:\n(1)-SIM\n(2)-NAO");
        int entrega = sc.nextInt();
        System.out.println("Forma de pagamento:\n(1)-Dinheiro\n(2)-Cartão");
        int formaPag = sc.nextInt();
        if(formaPag == 1){
            System.out.println("Troco para quanto:");
            troco = sc.nextDouble();
        }else{
            troco = 0;
        }
        sc.nextLine();
        this.pedido = new Pedido(entrega, troco );
        do{
            System.out.println("//--Por Favor digite o codigo do item que sera adicionado (ID) e a quantidade desejada--//");
            String id = sc.nextLine();
            int quant = sc.nextInt();
            sc.nextLine();
            pedido.ProcuraDeProduto(id, quant);
            System.out.println("//--!!(0)!! para sair--//");
            resp = sc.nextInt();
            sc.nextLine();
        }while(resp!=0);
        double valorFinal = pedido.obterPrecoTotal();
        System.out.printf("Valor Final da compra: %2f" ,valorFinal);
        if(pedido.getTroco() > 0){
                do {
                    if (valorFinal > troco) {
                        System.out.printf("\nValor insuficiente para pagar a conta:\n digite novo que esteja acima do valor final: %2f \n", valorFinal);
                        troco = sc.nextDouble();
                        pedido.setTroco(troco);
                    }
                } while (valorFinal > troco);
                System.out.printf("O seu troco foi de: $%2f ", troco-valorFinal);
        }
        String s = pedido.informacoes();
        System.out.printf("\n%s", s ,"\nData e hora Atuais %s:" ,pedido.getDataAtual());
    }

    public SubFacade Subfacade(){//NAO SEI OQ COLOCAR AQUI
        return new SubFacade();
    }

}
