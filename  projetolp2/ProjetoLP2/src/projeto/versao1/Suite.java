package projeto.versao1;


/**
 * 
 * @author ARTHUR SENA,IGOR GOMES,LUIZ HENRIQUE
 * @version 1.0
 */

public class Suite {
	private Estado estado;
	
	public enum Estado{
		livre, reservado, ocupado;
	
	}
	/**
	 * Inicializa os Atributos da classe
	 * @param estado
	 */
	
	public Suite(Estado estado){
		this.estado = estado;
	}
	
	/**
	 * Recupera o estado da suite
	 * @return Recupera o estado da suite
	 */
	public Estado getEstado(){
		return estado;
	}
	
	/**
	 * Altera o estado da Suite
	 * @param novoEstado
	 */
	public void setEstado(Estado novoEstado){
		estado = novoEstado;		
		
	}
}