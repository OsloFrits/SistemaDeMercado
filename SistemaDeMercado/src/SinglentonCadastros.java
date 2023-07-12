import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SinglentonCadastros {
    private static SinglentonCadastros instancia = null;
    private List<Cliente> cadastros;

    private SinglentonCadastros() {
      cadastros = new ArrayList<Cliente>();
    }

    public static SinglentonCadastros criarCadastro() {
        if (instancia == null) {
            return instancia = new SinglentonCadastros();
        } else {
            return instancia;
        }
    }

    public void AddCliente(Cliente cliente){
        cadastros.add(cliente);
    }
    public Cliente BuscarCliente(int numero){
        for(Cliente cliente: cadastros){
            if(numero == cliente.getNumero()){
                return cliente;
            }
        }
        return null;
    }
    public boolean existeCliente(int numero){
        for(Cliente cliente: cadastros){
            if(numero == cliente.getNumero()){
                return true;
            }
        }
        return false;
    }
    public void VerificacaoDosCadastros(){
        String s="";
        int j=1;
        System.out.println("//----------Clientes----------//");
        for(Cliente cliente : cadastros){
            System.out.printf("------------Cliente numero: %d", j);
            s = cliente.informacoesCliente();
            s = "\n" + s + "\n";
            System.out.printf(s);
            j++;
        }
    }
    public static SinglentonCadastros getInstancia() {
        return instancia;
    }

    public static void setInstancia(SinglentonCadastros instancia) {
        SinglentonCadastros.instancia = instancia;
    }

    public List<Cliente> getCadastros() {
        return cadastros;
    }

    public void setCadastros(List<Cliente> cadastros) {
        this.cadastros = cadastros;
    }
}