import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Arquivo implements Serializable {
    public static void GravarBackup(List<Object> listaDeProdutos, String nome){
        File arq = new File(nome);
        try{
            arq.delete();
            arq.createNewFile();
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(listaDeProdutos);
            objOutput.close();
        } catch(IOException printStackTrace){
            System.out.printf("Erro: %s", printStackTrace);

        }
    }
    public static List<Object> RecuperarBackup(String nome){
        List<Object> listinha = new ArrayList<>();
        try{
            File arq = new File(nome);
            if(arq.exists()){
                ObjectInputStream objImput = new ObjectInputStream(new FileInputStream(arq));
                listinha = (List<Object>) objImput.readObject();
                objImput.close();
            }
        }catch(IOException erro1){
            System.out.printf("Erro %s ", erro1.getMessage());
        }catch (ClassNotFoundException erro2){
            System.out.printf("Erro %s ", erro2.getMessage());
        }
        return listinha;
    }
}
