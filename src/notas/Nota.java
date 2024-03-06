package notas;

import faturas.Fatura;

public class Nota {
    private String nomeCliente;
    private Double valorNota;
    private Double valorImposto;

    public Nota(Fatura fatura){
        this.nomeCliente = fatura.getNome();
        this.valorNota = fatura.getValor();
        this.valorImposto = calculaImposto(fatura.getServico());
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
        return nomeCliente;
    }


    public Double getValorNota() {
        return valorNota;
    }


    public Double getValorImposto() {
        return valorImposto;
    }

    public String toString(){
        return this.nomeCliente + "-" + this.valorNota;
    }


}
