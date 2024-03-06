package notas;

import faturas.Fatura;

import java.util.UUID;

public class Nota {
    private String nomeCliente;
    private Double valorNota;
    private Double valorImposto;

    private String id;

    public Nota(Fatura fatura){
        this.nomeCliente = fatura.getNome();
        this.valorNota = fatura.getValor();
        this.valorImposto = calculaImposto(fatura.getServico());
        this.id = generateUniqueId();
    }

    public Double calculaImposto(String tipoServico) {
        final double taxaConsultoria = 0.25;
        final double taxaTreinamento = 0.15;
        final double taxaOutros = 0.06;
        double taxa = taxaOutros;


        if ("CONSULTORIA".equalsIgnoreCase(tipoServico)) {
            taxa = taxaConsultoria;
        } else if ("TREINAMENTO".equalsIgnoreCase(tipoServico)) {
            taxa = taxaTreinamento;
        }

        return taxa;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }


    public Double getValorNota() {
        return this.valorNota;
    }


    public Double getValorImposto() {
        return this.valorImposto;
    }

    public String getId(){
        return this.id;
    }

    public String toString(){
        return this.nomeCliente + "-" + this.valorNota;
    }

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }


}
