package projeto.versao1;

/**
 * 
 * @author ARTHUR SENA, IGOR GOMES, LUIZ HENRIQUE
 * @version 1.0
 */

public class Cliente extends Pessoa {
	
	Pacote pacote;
	
	/**
	 * Inicia os Atributos da Classe
	 * @param cpf
	 * @param nomeCompleto
	 * @param rg
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param pacote
	 * @throws Exception
	 */
	
	public Cliente(String cpf       , String nomeCompleto, String rg   ,  
			       Endereco endereco, String telefone    , String email,
			       Pacote pacote)  throws Exception{
		
		super(cpf, nomeCompleto, rg, endereco, telefone, email);
		this.pacote = pacote;
	}
	
	/**
	 * Recupera o pacote do cliente
	 * @return Recupera o pacote do cliente
	 */
	
	public Pacote getPacote(){
		return pacote;
	}
	
	/**
	 * Altera o Pacote do cliente
	 * @param novoPacote
	 */
	
	public void setPacote(Pacote novoPacote){
		this.pacote = novoPacote;
	}

}