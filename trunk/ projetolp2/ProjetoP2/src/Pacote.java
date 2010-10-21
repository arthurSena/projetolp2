
/**
 * 
 * @author ARTHUR SENA, IGOR GOMEZ, LUIZ HENRIQUE
 * @version 1.0
 */


public class Pacote {
   
	private double desconto;
	private int quantidadeDePessoas, quantidadeDeDias;
	
	/**
	 * Inicia osatributos da Classe
	 * @param quantidadeDeDias
	 * @param quantidadeDePessoas
	 * @throws Exception
	 */
	
	public Pacote(int quantidadeDeDias, int quantidadeDePessoas)throws Exception{
		if (quantidadeDeDias<=0){
			throw new Exception ("Quantidade de Dias nao pode ser igual ou menor que zero");
		}
		else if (quantidadeDeDias>14){
			throw new Exception ("Quantidade de Dias invalida");
		}
		else if(quantidadeDePessoas<=0){
			throw new Exception ("Quantidade de Pessoas nao pode ser igual ou menor que zero");
		}
		else if(quantidadeDePessoas>20){
			throw new Exception ("Quantidade de Pessoas invalida");
		}
		this.quantidadeDeDias = quantidadeDeDias;
		this.quantidadeDePessoas = quantidadeDePessoas;
		this.desconto = geraDesconto();
	}
	
	/**
	 * Recupera o desconto 
	 * @return Recupera o desconto
	 */
	
	public double getDesconto(){
		return desconto;
	}
	
	/**
	 * Recupera a quantidade de dias do Pacote 
	 * @return Recupera a quantidade de dias do Pacote 
	 */
	
	public int getQuantidadeDeDias(){
		return quantidadeDeDias;
	}
	
	/**
	 * Recupera a quantidade de pessoas do pacote
	 * @return Recupera a quantidade de pessoas do pacote
	 */
	
	public int getQuantidadeDePessoas(){
		return quantidadeDePessoas;
	}
	
	/**
	 * Retorna uma String que representa a classe
	 */
	
	public String toString(){
		return "Desconto: " + desconto + " Quantidade de Dias: " + quantidadeDeDias + " Quantidade de Pessoas: " + quantidadeDePessoas;
	}
	
	/**
	 * Analiza se dois pacote sao ou nao iguais
	 */
	
	public boolean equals(Object obj){
		if (!(obj instanceof Pacote)){
			return false;
		}
		
		Pacote pacote = (Pacote) obj;
		
		return pacote.getDesconto()==desconto && pacote.getQuantidadeDeDias()==quantidadeDeDias && pacote.getQuantidadeDePessoas() == quantidadeDePessoas;
	}

	private double geraDesconto(){
		if (quantidadeDePessoas <= 10 && quantidadeDeDias <= 7){
			desconto = 0.1;
		
		}else if (quantidadeDePessoas > 10 && quantidadeDePessoas <= 15 && quantidadeDeDias <= 7){
			desconto = 0.15;
		
		}else if (quantidadeDePessoas > 15 && quantidadeDePessoas <= 20 && quantidadeDeDias <= 14){
			desconto = 0.15;
		}
		return desconto;
	}
	
}
