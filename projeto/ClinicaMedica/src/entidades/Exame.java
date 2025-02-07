package entidades;

public class Exame {
	String tipo, 
			dataPrescrição, dataRealização, resultado, dataValidade; 
	int custo; 
	
	
	public Exame() // C - create and U - update
	{
		
	}
	public Exame(String tipo, String dataPrescrição, String dataRealização, String resultado, String dataValidade, int custo) { // C - create and U - update
		this.tipo = tipo;
		this.dataPrescrição = dataPrescrição;
		this.dataRealização = dataRealização;
		this.resultado = resultado;
		this.dataValidade = dataValidade;
		this.custo = custo;
	}
	
	public void deletarExame() {
	    if (this.tipo != null) {
	        this.tipo = null;
	    }
	    if (this.dataPrescrição != null) {
	        this.dataPrescrição = null;
	    }
	    if (this.dataRealização != null) {
	        this.dataRealização = null;
	    }
	    if (this.resultado != null) {
	        this.resultado = null;
	    }
	    if (this.dataValidade != null) {
	        this.dataValidade = null;
	    }
	    this.custo = 0;
	}
	
	public void lerExame() { // R - read
        System.out.println("Tipo: " + tipo);
        System.out.println("Data da Prescrição: " + dataPrescrição);
        System.out.println("Data de Realização: " + dataRealização);
        System.out.println("Resultado: " + resultado);
        System.out.println("Data de Validade: " + dataValidade);
        System.out.println("Custo: " + custo);
    }
	
	public void atualizarExame(String tipo, String dataPrescrição, String dataRealização, String resultado, String dataValidade, int custo) { // U
        this.tipo = tipo;
        this.dataPrescrição = dataPrescrição;
        this.dataRealização = dataRealização;
        this.resultado = resultado;
        this.dataValidade = dataValidade;
        this.custo = custo;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataPrescrição() {
		return dataPrescrição;
	}

	public void setDataPrescrição(String dataPrescrição) {
		this.dataPrescrição = dataPrescrição;
	}

	public String getDataRealização() {
		return dataRealização;
	}

	public void setDataRealização(String dataRealização) {
		this.dataRealização = dataRealização;
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
