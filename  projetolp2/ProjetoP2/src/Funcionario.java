
public class Funcionario extends Pessoa{
	String naturalidade, estadoCivil;
	
	
	
	public Funcionario(
			           String naturalidade, String estadoCivil,
			           String cpf, String nomeCompleto, String rg,  
			           Endereco endereco, String telefone, 
			           String email)throws Exception{
		
		
		
		super(cpf, nomeCompleto, rg, endereco, telefone, email);
		
		if(naturalidade == null || naturalidade.isEmpty()){
			throw new Exception("Naturalidade nao pode ser vazia ou nula");
		}
		else if(soEspaco(naturalidade)){
			throw new Exception("Naturalidade nao pode conter apenas espacos");
		}
		
		else if(!stringValida(naturalidade)){
			throw new Exception("Naturalidade contem caracteres Invalidos");
		}
		
		else if(estadoCivil == null || estadoCivil.isEmpty()){
			throw new Exception("Estado Civil nao pode ser vazia ou nula");
		}
		else if(soEspaco(estadoCivil)){
			throw new Exception("Estado Civil nao pode conter apenas espacos");
		}
		else if(!stringValida(estadoCivil)){
			throw new Exception("Estado Civil contem caracteres Invalidos");
		}
		
		this.naturalidade = naturalidade;
		this.estadoCivil = estadoCivil;
		
		
	}
	
	/**
	 * Recupera a naturalidade do funcionario
	 * @return Recupera a naturalidade do funcionario
	 */
	
	public String getNaturalidade(){
		return naturalidade;
	}
	
	/**
	 * Recupera o estado civil do funcionario
	 * @return Recupera o estado civil do funcionario
	 */
	
	public String getEstadoCivil(){
		return estadoCivil;
	}
	
	
	/**
	 * Altera a Naturalidade
	 * @param novaNaturalidade
	 */
	
	public void setNaturalidade(String novaNaturalidade)throws Exception{
		if(novaNaturalidade == null || novaNaturalidade.isEmpty()){
			throw new Exception("Naturalidade nao pode ser vazia ou nula");
		}
		else if(soEspaco(novaNaturalidade)){
			throw new Exception("Naturalidade nao pode conter apenas espacos");
		}
		else if(!stringValida(novaNaturalidade)){
			throw new Exception("Naturalidade contem caracteres Invalidos");
		}
		this.naturalidade = novaNaturalidade;
	}
	
	/**
	 * Altera o EstadoCivil
	 * @param novoEstadoCivil
	 * @throws Exception 
	 */
	
	public void setEstadoCivil(String novoEstadoCivil) throws Exception{
		if(novoEstadoCivil == null || novoEstadoCivil.isEmpty()){
			throw new Exception("Estado Civil nao pode ser vazia ou nula");
		}
		else if(soEspaco(novoEstadoCivil)){
			throw new Exception("Estado Civil nao pode conter apenas espacos");
		}
		else if(!stringValida(novoEstadoCivil)){
			throw new Exception("Estado Civil contem caracteres Invalidos");
		}
		this.estadoCivil = novoEstadoCivil;
	}
	/**
	 * Retorna uma String que representa a classe
	 */
	public String toString(){
		return super.toString() + " Estado civil = " + estadoCivil + 
		" Naturalidade = " + naturalidade ;		
	}
	
	/**
	 * Analiza se dois funcionarios sao iguais
	 */
	
	public boolean equals(Object obj){
		if (!(obj instanceof Funcionario)){
			return false;
		}
		
		Funcionario func = (Funcionario) obj;
		
		return super.equals(func) && func.getNaturalidade().equals(naturalidade) && func.getEstadoCivil().equals(estadoCivil);
	}
	
	  private boolean soEspaco(String s){
	      try{
	    	  String x = s.split(" ")[0];
	    	  return false;
	      }
	      catch(Exception e){
	    	  return true;
	      }
		 
	 }
	  
	  private boolean stringValida(String s){
		  String caracteresInvalidos = "! @ # $ % & * ( ) _ - 1 2 3 4 5 6 7 8 9 0 / + = { } [ ] ? | > < : ;";
		  for (String caracteres : caracteresInvalidos.split(" ")){
			  if(s.contains(caracteres)){
				  return false;
			  }
		  }
		  return true;
	  }
}

	
