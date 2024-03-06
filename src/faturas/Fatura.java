package faturas;

import java.util.UUID;


public class Fatura {
    private String nomeCliente;
    private String enderecoCliente;
    private String tipoServico;
    private Double valor;
    private String id;

    public Fatura(String nomeCliente, String enderecoCliente, String tipoServico, Double valor) {
        this.setNome(nomeCliente);
        this.setEndereco(enderecoCliente);
        this.setServico(tipoServico);
        this.setValor(valor);
        this.id = generateUniqueId();
    }


    public String getNome() { return this.nomeCliente;}

    public String getEndereco() {return this.enderecoCliente;}

    public String getServico() {return this.tipoServico;}

    public Double getValor() {return this.valor;}

    public String getId(){return this.id;}

    public void setNome(String nomeCliente) {this.nomeCliente = nomeCliente;}

    public void setEndereco(String enderecoCliente) {this.enderecoCliente = enderecoCliente;}

    public void setServico(String tipoServico) {this.tipoServico = tipoServico;}

    public void setValor(Double valor) {this.valor = valor;}

    public String toString(){
        return this.nomeCliente + "-" + this.enderecoCliente + "-" + this.tipoServico +"-" +this.valor;
    }

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
