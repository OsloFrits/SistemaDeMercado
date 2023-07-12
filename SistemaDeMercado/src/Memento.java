import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Memento implements Serializable {//NAO TIVE COMO TESTAR PQ PRECISA DO SUBFACADE
    private SingletonEstoque estoque = null;
    private List<Produto> ListaDeProdutos;
    public Memento(){
        estoque = SingletonEstoque.criarEstoque();
    }
    public Memento(SingletonEstoque estoque, List<Produto> ListaDeProdutos){
        this.estoque = estoque;
        this.ListaDeProdutos = ListaDeProdutos;
    }
    public void restore(){
            estoque.Limpar();
            for(Produto prod: ListaDeProdutos){
                estoque.AddProduto(prod);
            }
    }
    public void RecuperaBackupBin(){
        List<Object> listinha = Arquivo.RecuperarBackup("Estoque.bin");
        for(Object recupera: listinha){
            Produto prod = (Produto) recupera;
            estoque.AddProduto(prod);
        }
    }
    public void FazerBackupBin(){
        List<Object> listinha = new ArrayList<Object>();
        for(Produto prod: ListaDeProdutos){
            Object grava = (Object)prod;
            listinha.add(grava);
        }
        Arquivo.GravarBackup(listinha, "Estoque.bin");
    }
}
