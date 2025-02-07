package entidades;

public abstract class Usuario {
	String nome,
			dataNascimento,cpf;
	HistoricoMedico historico; 
	
	public abstract void deletarCadastro();  // D
	public abstract void lerCadastro(); // R
	public void atualizarCadastro(String nome, String dataNascimento, String cpf) {
		// TODO Auto-generated method stub
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public HistoricoMedico getHistorico() {
		return historico;
	}

	public void setHistorico(HistoricoMedico historico) {
		this.historico = historico;
	}
	

	
}
