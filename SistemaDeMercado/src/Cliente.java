public class Cliente extends Pessoa{
    private int numero;
    private String endereço;

    public Cliente(int cpf, String nome, int numero, String endereço) {
        super(cpf, nome);
        this.numero = numero;
        this.endereço = endereço;
    }

    public String informacoesCliente(){
        return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nTelefone: " + getNumero() + "\nEndereço: " + getEndereço();
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
