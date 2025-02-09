package entidades;

import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private boolean pago;
    private LocalDate dataPagamento;
    private String metodoPagamento; // Ex: "Cartão", "Dinheiro", "PIX"

    public Pagamento(double valor, String metodoPagamento) {
        this.valor = valor;
        this.pago = false; // Por padrão, pagamento inicia como pendente.
        this.metodoPagamento = metodoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void realizarPagamento() {
        if (!pago) {
            this.pago = true;
            this.dataPagamento = LocalDate.now();
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.println("Pagamento já foi realizado anteriormente.");
        }
    }
}
