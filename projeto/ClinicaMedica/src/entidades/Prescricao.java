package entidades;

import java.util.ArrayList;
import java.util.List;

public class Prescricao {
	
	private Consulta consultaAssociada; 
	private List<Exame> examesPrescritos;
	private List<Medicamento> medicamentoPrescritos;
	private String tipo, 
		dataPrescricao, dataRealizacao, resultado, dataValidade; 
	private int custo; 
	
	// Construtor
	public Prescricao() {
        this.examesPrescritos = new ArrayList<>();
        this.medicamentoPrescritos = new ArrayList<>();
    }

	
	public Prescricao(String tipo, String dataPrescricao, String dataRealizacao, 
			String dataValidade, String nomeMedicamento, Consulta consultaAssociada, int custo) {
		
		this.examesPrescritos = new ArrayList<>();
		this.medicamentoPrescritos = new ArrayList<>();
		
		// Criando um novo Exame e Medicamento para a prescrição
		Exame exame = new Exame();
		exame.setTipo(tipo); 
		exame.setDataPrescricao(dataPrescricao);
		exame.setDataRealizacao(dataRealizacao); 
		exame.setDataValidade(dataValidade); 
		exame.setCusto(custo);
		
		Medicamento medicamento = new Medicamento();
		medicamento.setNomeMedicamento(nomeMedicamento);
		
		// Adicionando à lista de prescrições
		this.examesPrescritos.add(exame);
		this.medicamentoPrescritos.add(medicamento);
		
		this.consultaAssociada = consultaAssociada;
	}

	// Getters e Setters
	public Consulta getConsultaAssociada() {
		return consultaAssociada;
	}

	public void setConsultaAssociada(Consulta consultaAssociada) {
		this.consultaAssociada = consultaAssociada;
	}

	public List<Exame> getExamesPrescritos() {
		return examesPrescritos;
	}

	public void setExamesPrescritos(List<Exame> examesPrescritos) {
		this.examesPrescritos = examesPrescritos;
	}

	public void adicionarExame(Exame exame) {
		this.examesPrescritos.add(exame);
	}

	public List<Medicamento> getMedicamentoPrescritos() {
		return medicamentoPrescritos;
	}

	public void setMedicamentoPrescritos(List<Medicamento> medicamentoPrescritos) {
		this.medicamentoPrescritos = medicamentoPrescritos;
	}

	public void adicionarMedicamento(Medicamento medicamento) {
		this.medicamentoPrescritos.add(medicamento);
	}

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
