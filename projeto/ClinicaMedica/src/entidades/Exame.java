package entidades;

public class Exame {
    private String tipo; 
    private String dataPrescricao; 
    private String dataRealizacao; 
    private String resultado; 
    private String dataValidade; 
    private int custo; 

    // Construtor vazio
    public Exame() {}

    // Construtor completo
    public Exame(String tipo, String dataPrescricao, String dataRealizacao, String resultado, String dataValidade, int custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
        this.dataValidade = dataValidade;
        this.custo = custo;
    }

    // Método para deletar o exame
    public void deletarExame() {
        this.tipo = null;
        this.dataPrescricao = null;
        this.dataRealizacao = null;
        this.resultado = null;
        this.dataValidade = null;
        this.custo = 0;
    }

    // Ler informações do exame
    public void lerExame() { 
        if (tipo != null && dataPrescricao != null && dataRealizacao != null && resultado != null && dataValidade != null) {
            System.out.println("Tipo: " + tipo);
            System.out.println("Data da Prescrição: " + dataPrescricao);
            System.out.println("Data de Realização: " + dataRealizacao);
            System.out.println("Resultado: " + resultado);
            System.out.println("Data de Validade: " + dataValidade);
            System.out.println("Custo: " + custo);
        } else {
            System.out.println("Exame incompleto ou não disponível.");
        }
    }

    // Atualizar exame
    public void atualizarExame(String tipo, String dataPrescricao, String dataRealizacao, String resultado, String dataValidade, int custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
        this.dataValidade = dataValidade;
        this.custo = custo;
    }

    // Sobrescrevendo o método toString para exibir a informação do exame de forma simplificada
    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Prescrição: " + dataPrescricao + ", Realização: " + dataRealizacao + ", Resultado: " + resultado + ", Validade: " + dataValidade + ", Custo: " + custo;
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
