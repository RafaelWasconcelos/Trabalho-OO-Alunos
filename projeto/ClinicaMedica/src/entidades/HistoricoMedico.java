//package entidades;
//
//public class HistoricoMedico {
//	Consulta consultas[],consulta; 
//	Exame exames[],exame;
//	
//	public HistoricoMedico()
//	{
//		this.exame = new Exame ();
//		this.exames = new Exame [100000]; 
//		this.consulta= new Consulta();
//		this.consultas= new Consulta [100000]; // tamanho da lista consultas, inicializei para esses valores n ficarem nulos
//	}
//	
//	public Consulta[] getConsultas() {
//		return consultas;
//	}
//	public void setConsultas(Consulta[] consultas) { 
//		this.consultas = consultas;
//	}
//	public Exame[] getExames() {
//		return exames;
//	}
//	public void setExames(Exame[] exames) {
//		this.exames = exames;
//	}
//	public Consulta getConsulta() {
//		return consulta;
//	}
//	public void setConsulta(Consulta consulta) {
//		this.consulta = consulta;
//	}
//	public Exame getExame() {
//		return exame;
//	}
//	public void setExame(Exame exame) {
//		this.exame = exame;
//	} 
//	
//	
//}

	package entidades;
	
	public class HistoricoMedico {
	    Consulta consultas[];
	    Exame exames[];
	
	    public HistoricoMedico() {
	        this.consultas = new Consulta[100000];
	        this.exames = new Exame[100000];
	    }
	
	    public Consulta[] getConsultas() {
	        return consultas;
	    }
	
	    public void setConsultas(Consulta[] consultas) {
	        this.consultas = consultas;
	    }
	
	    public Exame[] getExames() {
	        return exames;
	    }
	
	    public void setExames(Exame[] exames) {
	        this.exames = exames;
	    }
	}


