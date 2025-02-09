package entidades;

public class Exame {
    private String tipo, 
                   dataPrescricao, dataRealizacao, resultado, dataValidade; 
    private int custo; 

    // Construtor sem parâmetros
    public Exame() {
        // Usado para criar um objeto vazio, caso necessário
    }

    // Construtor com parâmetros
    public Exame(String tipo, String dataPrescricao, String dataRealizacao, String resultado, String dataValidade, int custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
        this.dataValidade = dataValidade;
        this.custo = custo;
    }

    // Método para deletar (resetar) dados do exame
    public void deletarExame() {
        this.tipo = "";
        this.dataPrescricao = "";
        this.dataRealizacao = "";
        this.resultado = "";
        this.dataValidade = "";
        this.custo = 0;
    }

    // Método para exibir os dados do exame
    public void lerExame() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Data da Prescrição: " + dataPrescricao);
        System.out.println("Data de Realização: " + dataRealizacao);
        System.out.println("Resultado: " + resultado);
        System.out.println("Data de Validade: " + dataValidade);
        System.out.println("Custo: " + custo);
    }

    // Método para atualizar os dados do exame
    public void atualizarExame(String tipo, String dataPrescricao, String dataRealizacao, String resultado, String dataValidade, int custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
        this.dataValidade = dataValidade;
        this.custo = custo;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(String dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public String getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
}
