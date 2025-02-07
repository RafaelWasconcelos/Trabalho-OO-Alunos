package entidades;

public class Medicamento {
	String nomeMedicamento;
	
	public Medicamento()
	{
		
	}
	public Medicamento(String nomeMedicamento) { //CU - create and update
		this.nomeMedicamento = nomeMedicamento;
	}
	
	public void atualizarMedicamento(String nomeMedicamento) { // U
        this.nomeMedicamento = nomeMedicamento;
	}
	
	public void deletarMedicamento() { // D - delete 
		nomeMedicamento=null; 
	}
	
	public void lerMedicamento() { // R - read
    System.out.println("Nome do Medicamento: " + nomeMedicamento);
}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	} 
	


	
}
