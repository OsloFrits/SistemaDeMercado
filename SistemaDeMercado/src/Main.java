import Pedido.SingletonEstoque;
import Clientes.Cliente;
import Clientes.SinglentonCadastros;

import java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        int resp = 0;

        SingletonEstoque estoque = SingletonEstoque.criarEstoque();

        Cliente cliente = new Cliente(123456789, "Joao", 32503200, "rua irma dulce");
        SinglentonCadastros cadastros = SinglentonCadastros.criarCadastro();
        cadastros.AddCliente(cliente);

        System.out.println("  __  __                              _   _          _                 _                               ____      \n" +
                " |  \\/  |  ___   _ _   __   __ _   __| | (_)  _ _   | |_    ___     __| |  ___     ___  ___   _  _    |_  /  ___ \n" +
                " | |\\/| | / -_) | '_| / _| / _` | / _` | | | | ' \\  | ' \\  / _ \\   / _` | / _ \\   (_-< / -_) | || |    / /  / -_)\n" +
                " |_|  |_| \\___| |_|   \\__| \\__,_| \\__,_| |_| |_||_| |_||_| \\___/   \\__,_| \\___/   /__/ \\___|  \\_,_|   /___| \\___| V3.02.14.10\n\n");
        System.out.println("BEM VINDO!!");
        do{
            Facade fachada = new Facade();
            System.out.println("///----//-------------------------COMANDOS-------------------------//----///");

            System.out.println("(1)-Realizar Uma Venda\n(2)-Ir para o Sub-Sistema\n(0)-Para sair do programa");
            resp = sc.nextInt();
            switch(resp){
                case(1):{

                    fachada.RealizarVenda();
                    break;
                }
                case(2): {
                    SubFacade fachadinha = fachada.Subfacade();
                    int resp1;
                    do {
                        System.out.println("///----//-------------------------Sub-Sistema-------------------------//----///");
                        System.out.println("(1)-Cadastrar um Pedido.Produto\n(2)-Cadastrar um Clientes.Cliente\n(3)-Verificar Estoque\n(4)-Verificar Cadastros\n(5)-Criar Backup do estoque\n(6)-Restaurar backup do estoque\n(7)-Exportar Estoque\n(8)-Importar Estoque\n(0)-Voltar para menu principal");
                        resp1 = sc.nextInt();
                        switch (resp1) {
                            case (1): {
                                fachadinha.CadastrarProduto();
                                break;
                            }
                            case (2): {
                                fachadinha.CadastrarCliente();
                                break;
                            }
                            case (3): {
                                fachadinha.VerificarEstoque();
                                break;
                            }
                            case (4): {
                                fachadinha.VerificarCadastros();
                                break;
                            }
                            case (5): {
                                fachadinha.CriarBackup();
                                break;
                            }
                            case (6): {
                                fachadinha.RestaurarEstoque();
                                break;
                            }
                            case (7): {
                                fachadinha.FazerBackupBin();
                                break;
                            }
                            case (8): {
                                fachadinha.RestaurarBackupBin();
                                break;
                            }
                        }
                        System.in.read();//Usado para pausar a tela e possibilitar a leitura das saidas
                    } while (resp1 != 0);
                }
            }
            sc.nextLine();
            System.out.println("\n\n\n");
        }while(resp!=0);
    }
}
        //Usado para preencher o estaoque de maneira manual
        /*Pedido.Produto prod =  new Pedido.Produto("esponja", "1234", 32,10);
        Pedido.Produto prod2 = new Pedido.Produto("vrido", "4321", 300, 432);
        Pedido.Produto prod3 =  new Pedido.Produto("Pá", "3200", 2,100);
        Pedido.Produto prod4 = new Pedido.Produto("Balas", "2547", 3000, 1.5);
        Pedido.Produto prod5 =  new Pedido.Produto("Melancia", "9865", 10,15);
        Pedido.Produto prod6 = new Pedido.Produto("Carne", "2222", 11, 10000);
        estoque.AddProduto(prod);
        estoque.AddProduto(prod2);
        estoque.AddProduto(prod3);
        estoque.AddProduto(prod4);
        estoque.AddProduto(prod5);
        estoque.AddProduto(prod6);*/