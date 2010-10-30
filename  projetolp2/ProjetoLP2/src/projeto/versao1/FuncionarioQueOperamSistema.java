package projeto.versao1;


/**
 * 
 * @author ARTHUR SENA, IGOR GOMES, LUIZ HENRIQUE
 * @version 1.0
 */

public class FuncionarioQueOperamSistema extends Funcionario{
	
	private String login, senha;
	
	/**
	 * Inicia os Atributos da classe
	 * @param naturalidade
	 * @param estadoCivil
	 * @param cpf
	 * @param nomeCompleto
	 * @param rg
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param login
	 * @param Senha
	 * @throws Exception
	 */
	
	public FuncionarioQueOperamSistema(String naturalidade, String estadoCivil,
			String cpf, String nomeCompleto, String rg, Endereco endereco,
			String telefone, String email, String login, String senha) throws Exception {
		
		super(naturalidade, estadoCivil, cpf, nomeCompleto, rg, endereco, telefone,
				email);
		if(login == null || login.isEmpty()){
			throw new Exception("Login nao pode ser vazio ou nulo");
		}
		else if(soEspaco(login)){
			throw new Exception("Login nao pode conter apenas espacos");
		}
		
		else if(senha == null || senha.isEmpty()){
			throw new Exception("Senha nao pode ser vazia ou nula");
		}
		else if(soEspaco(senha)){
			throw new Exception("Senha nao pode conter apenas espacos");
		}
		
		this.login = login;
		this.senha = senha;
	}
	
	/**
	 * Recupera o login do funcionario
	 * @return Recupera o login do funcionario
	 */
	public String getLogin(){
		return login;
	}
	
	/**
	 * Recupera a senha do funcionario
	 * @return Recupera a senha do funcionario
	 */
	
	public String getSenha(){
		return senha;
	}
	

	/**
	 * Altera a senha
	 * @param novaSenha
	 * @throws Exception
	 */
	public void setSenha(String novaSenha)throws Exception{
		if(novaSenha == null || novaSenha.isEmpty()){
			throw new Exception("Senha nao pode ser vazia ou nula");
		}
		else if(soEspaco(novaSenha)){
			throw new Exception("Senha nao pode conter apenas espacos");
		}
		else{
			senha = novaSenha;
		}
			
		
	}
	
	/**
	 * Altera o login
	 * @param novoLogin
	 * @throws Exception
	 */
	public void setLogin(String novoLogin)throws Exception{
		if(novoLogin == null || novoLogin.isEmpty()){
			throw new Exception("Login nao pode ser vazio ou nulo");
		}
		else if(soEspaco(novoLogin)){
			throw new Exception("Login nao pode conter apenas espacos");
		}
		else{
			login = novoLogin;
		}
	}
	
	/**
	 * Retorna uma String que representa a classe
	 */
	
	
	public String toString(){
		return super.toString() + " Login = " + login + " Senha = " + senha;
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

}