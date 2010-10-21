import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

public class TestePacote {
	
	private Pacote pacote1;
	private Pacote pacote2;
	private Pacote pacote3;

	@Before public void testePacote1(){
		try {
			pacote1 = new Pacote(6,7);
			pacote2 = new Pacote(5,12);
			pacote3 = new Pacote(13,19);
			pacote1 = new Pacote(0,20);
		} catch (Exception e) {
			 Assert.assertEquals("Quantidade de Dias nao pode ser igual ou menor que zero",e.getMessage());
		}
		
		try{
			pacote1 = new Pacote(10,-1);
		}
		 catch (Exception e) {
			 Assert.assertEquals("Quantidade de Pessoas nao pode ser igual ou menor que zero",e.getMessage());
		}
		 
		try{
				pacote1 = new Pacote(10,99);
			}
		catch (Exception e) {
				 Assert.assertEquals("Quantidade de Pessoas invalida",e.getMessage());
		}
	
		try{
			pacote1 = new Pacote(100,15);
		}
		catch (Exception e) {
			 Assert.assertEquals("Quantidade de Dias invalida",e.getMessage());
		}
		
	}
	
	@Test public void testePacote2(){
		//Testando metodo get()
		 Assert.assertEquals(6,pacote1.getQuantidadeDeDias());
		 Assert.assertEquals(7,pacote1.getQuantidadeDePessoas());
		 Assert.assertEquals(0.1,pacote1.getDesconto(),0.5);
		 
		 Assert.assertEquals(5,pacote2.getQuantidadeDeDias());
		 Assert.assertEquals(12,pacote2.getQuantidadeDePessoas());
		 Assert.assertEquals(0.15,pacote2.getDesconto(),0.5);
		 
		 Assert.assertEquals(13,pacote3.getQuantidadeDeDias());
		 Assert.assertEquals(19,pacote3.getQuantidadeDePessoas());
		 Assert.assertEquals(0.15,pacote3.getDesconto(),0.5);
		 
		 //Testando toString()
		 Assert.assertEquals("Desconto: 0.1 Quantidade de Dias: 6 Quantidade de Pessoas: 7",pacote1.toString());
		 Assert.assertEquals("Desconto: 0.15 Quantidade de Dias: 5 Quantidade de Pessoas: 12",pacote2.toString());
		 Assert.assertEquals("Desconto: 0.15 Quantidade de Dias: 13 Quantidade de Pessoas: 19",pacote3.toString());
		 
		//Testando metodo equals()
		 Assert.assertFalse(pacote1.equals(pacote2));
		 Assert.assertFalse(pacote1.equals(pacote3));
		 Assert.assertFalse(pacote2.equals(pacote3));
		 
		 Assert.assertTrue(pacote1.equals(pacote1));
		 Assert.assertTrue(pacote2.equals(pacote2));
		 Assert.assertTrue(pacote3.equals(pacote3));
	}
}
