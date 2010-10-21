
/**
 * 
 * @author ARTHUR SENA, IGOR GOMEZ, LUIZ HENRIQUE
 * @version 1.0
 */

public class Pessoa {

    private String cpf;
    private String nomeCompleto;
    private String rg;
    private Endereco endereco;
    private String telefone;
    private String email;
   
    /**
     * Inicia os atributos da classe
     * @param cpf
     * @param nomeCompleto
     * @param rg
     * @param naturalidade
     * @param estadoCivil
     * @param endereco
     * @param telefone
     * @param email
     * @throws Exception
     */
   
    public Pessoa(String cpf, String nomeCompleto, String rg,  Endereco endereco, String telefone, String email)throws Exception{
    	if (!ehCPF(cpf) || cpf.isEmpty() || cpf==null || soEspaco(cpf)){
            throw new Exception("CPF Invalido");
        }
        else if(!ehInteiro(telefone) || telefone.isEmpty() || telefone==null || soEspaco(telefone)){
        	throw new Exception("Telefone Invalido");
        }
        else if(nomeSemDigitos(nomeCompleto)==false || nomeCompleto.isEmpty() || nomeCompleto==null || soEspaco(nomeCompleto)){
        	throw new Exception("Nome Invalido");
        }
        else if(rg==null || rg.isEmpty() || soEspaco(rg)){
    		throw new Exception("RG Invalido");
    	}
        else if (email.isEmpty() || email==null || soEspaco(email) || !(ehEmail(email))){
    		throw new Exception("Email Invalido");
    	}
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
       
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.telefone = telefone;
    }
   
    /**
     * Recupera o CPF do funcionario
     * @return Recupera o CPF do funcionario
     */
   
    public String getCPF(){
        return cpf;
    }
   
    /**
     * Recupera o Telefone do funcionario
     * @return Recupera o Telefone do funcionario
     */
   
    public String getTelefone(){
        return telefone;
    }
   
    /**
     * Recupera o nome completo do funcionario
     * @return Recupera o nome completo do funcionario
     */
   
    public String nomeCompleto(){
        return nomeCompleto;
    }
   
    /**
     * Recupera o RG do funcionario
     * @return Recupera o RG do funcionario
     */
   
    public String getRg(){
        return rg;
    }
    
    /**
     * Recupera o endereco do funcionario
     * @return Recupera o endereco do funcionario
     */
   
    public Endereco getEndereco(){
        return endereco;
    }
   
    /**
     * Recupera o email do funcionario
     * @return Recupera o email do funcionario
     */
   
    public String getEmail(){
        return email;
    }
    
    /**
     * Altera o Email da Pessoa
     * @param novoEmail
     * @throws Exception
     */
    public void setEmail(String novoEmail) throws Exception{
    	if (novoEmail.isEmpty() || novoEmail==null || soEspaco(novoEmail) || !(ehEmail(novoEmail))){
    		throw new Exception("Email Invalido");
    	}
    	this.email = novoEmail;
    }
    
    /**
     * Altera o CPF do funcionario
     * @param novoCPF
     * @throws Exception
     */
   
    public void setCPF(String novoCPF)throws Exception{
    	if (!ehCPF(novoCPF) || novoCPF.isEmpty() || novoCPF==null || soEspaco(novoCPF)){
    		throw new Exception("CPF Invalido");
    	}
        this.cpf = novoCPF;
    }
   
    /**
     * Altera o nome do funcionario
     * @param novoNome
     * @throws Exception 
     */
   
    public void setNome(String novoNome) throws Exception{
    	if(!nomeSemDigitos(novoNome) || novoNome.isEmpty() || novoNome==null || soEspaco(novoNome)){
        	throw new Exception("Nome Invalido");
        }
    	else{
    		this.nomeCompleto = novoNome;
    	}
    }
   
    /**
     * Altera o RG do funcionario
     * @param novoRG
     * @throws Exception 
     */
   
    public void setRG(String novoRG) throws Exception{
    	if(novoRG==null || novoRG.isEmpty() || soEspaco(novoRG)){
    		throw new Exception("RG Invalido");
    	}
        this.rg = novoRG;
    }
    
    /**
     * Altera o Telefone da Pessoa
     * @param novoTelefone
     * @throws Exception
     */
    
    public void setTelefone(String novoTelefone) throws Exception{
    	if(!ehInteiro(novoTelefone) || novoTelefone.isEmpty() || novoTelefone==null || soEspaco(novoTelefone)){
    		throw new Exception("Telefone Invalido");
    	}
    	this.telefone = novoTelefone;
    }
   
    /**
     * Altera a Rua do funcionario
     * @param novaRua
     * @throws Exception 
     */
   
    public void setRua(String novaRua) throws Exception{
    	if(!nomeSemDigitos(novaRua) || novaRua.isEmpty() || novaRua==null || soEspaco(novaRua)){
        	throw new Exception("Rua Invalida");
        }
        endereco.setRua(novaRua);
    }
   
    /**
     * Aleta o Bairro da Pessoa
     * @param novoBairro
     * @throws Exception
     */
    
    public void setBairro(String novoBairro)throws Exception{
    	if(!nomeSemDigitos(novoBairro) || novoBairro.isEmpty() || novoBairro == null || soEspaco(novoBairro)){
        	throw new Exception("Bairro Invalido");
        }
    	endereco.setBairro(novoBairro);
    }
    
    /**
     * Altera o Numero da Casa da Pessoa
     * @param numeroDaCasa
     * @throws Exception
     */
    
    public void setNumeroDaCasa(String numeroDaCasa)throws Exception{
    	if(!ehInteiro(numeroDaCasa) || numeroDaCasa.isEmpty() || numeroDaCasa==null || soEspaco(numeroDaCasa)){
        	throw new Exception("Numero Invalido");
        }
    	endereco.setNumero(numeroDaCasa);
    }
    
    /**
     * Altera o CEP da Pessoa
     * @param novoCEP
     * @throws Exception
     */
    
    public void setCEP(String novoCEP) throws Exception{
    	if(!ehInteiro(novoCEP) || novoCEP.isEmpty() || novoCEP ==null || soEspaco(novoCEP)){
        	throw new Exception("CEP Invalido");
        }
    	endereco.setCEP(novoCEP);
    }
    
    /**
     * Altera o Estado da Pessoa
     * @param novoEstado
     * @throws Exception
     */
    
    public void setEstado(String novoEstado)throws Exception{
    	if(!nomeSemDigitos(novoEstado) || novoEstado.isEmpty() || novoEstado==null || soEspaco(novoEstado)){
        	throw new Exception("Estado Invalido");
        }
    	endereco.setEstado(novoEstado);
    }
    
    /**
     * Altera a Cidade da Pessoa
     * @param novaCidade
     * @throws Exception
     */
    
    public void setCidade(String novaCidade)throws Exception{
    	if(!nomeSemDigitos(novaCidade) || novaCidade.isEmpty() || novaCidade==null || soEspaco(novaCidade)){
        	throw new Exception("Cidade Invalida");
        }
    	endereco.setCidade(novaCidade);
    }
    
    
    /**
     * Retorna uma String que representa a classe
     */
   
    public String toString() {
        return "Pessoa: nomeCompleto = " + nomeCompleto + " ,cpf = " + cpf +
                              " ,rg = " + rg  + ", endereco=" + endereco  +
                              " ,telefone = " + telefone + " ,email = " + email ;
    }
    
    /**
     * Compara duas Pessoas, se forema iguais retorna true caso contrario retorna false
     */
    
    public boolean equals(Object obj){
    	if(!(obj instanceof Pessoa)){
    		return false;
    	}
    	
    	Pessoa pessoa = (Pessoa) obj;
    	
    	return pessoa.getCPF().equals(cpf) && pessoa.getEmail().equals(email) && pessoa.getRg().equals(rg) &&
    	       pessoa.getTelefone().equals(telefone);
    }
   
    private boolean ehCPF(String cpf){
    	
    	if(ehInteiro(cpf) && cpf.length()==11){
    		
    		return true;
    	}
    	
    	return false;
    }
   
    private boolean ehInteiro(String cpf){
        try{
            Long.parseLong(cpf);
            return true;
        }
       
        catch(NumberFormatException e){
            return false;
        }
    }
    
    private boolean nomeSemDigitos(String nome){
    	for (int i = 0 ; i< nome.toCharArray().length ; i++){
    		if (Character.isDigit(nome.toCharArray()[i])){
    			return false;
    		}
    	}
    	return true;
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
    
    private boolean ehEmail(String email){
        if(email.contains(".com") && email.contains("@")){
                return true;
        }
        return false;
}
}