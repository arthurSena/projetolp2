
import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

public class TestandoFuncionario {
	
	private Funcionario funcionario;
	
    @Before public void testandoFuncionario1(){
    	try{
    		funcionario = new Funcionario("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com");
    		funcionario = new Funcionario("         ","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Naturalidade nao pode conter apenas espacos");
    	}
    	
    	try{
    		funcionario = new Funcionario("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Email Invalido");
    	}
    	
    	try{
    		funcionario = new Funcionario("naturalidade","","00000000000","nome","0000000",null,"00000000","semEmail@.com");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Estado Civil nao pode ser vazia ou nula");
    	}
    	
    	try{
    		funcionario = new Funcionario("naturalidade",null,"00000000000","nome","0000000",null,"00000000","semEmail@.com");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Estado Civil nao pode ser vazia ou nula");
    	}
    	
    	try{
    		funcionario = new Funcionario(null,"estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Naturalidade nao pode ser vazia ou nula");
    	}
    	try{
    		funcionario = new Funcionario("6545652345@#$%@#$%","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Naturalidade contem caracteres Invalidos");
    	}
    	try{
    		funcionario = new Funcionario("naturalidade","!@@#$!@#$!@#¨%¨&","00000000000","nome","0000000",null,"00000000","semEmail@.com");
    	}
    	catch(Exception e){
    		Assert.assertEquals(e.getMessage(),"Estado Civil contem caracteres Invalidos");
    	}
    }
    
    @Test public void testandoFuncionario2(){
    	//Testando metodo get()
    	Assert.assertEquals("naturalidade",funcionario.getNaturalidade());
    	Assert.assertEquals("estadoCivil",funcionario.getEstadoCivil());
    	
    	//Testando metodo set()
    	
    	//-------------Naturalidade------------
    	try{
    		funcionario.setNaturalidade("novaNaturalidade");
    		funcionario.setNaturalidade(null);
    		
    	}
    	catch(Exception e){
    		Assert.assertEquals("Naturalidade nao pode ser vazia ou nula",e.getMessage());
    		
    	}
    	
    	Assert.assertEquals("novaNaturalidade",funcionario.getNaturalidade());
    	
    	//-------------Estado Civil -----------------------
    	try{
    		funcionario.setEstadoCivil("novoEstadoCivil");
    		funcionario.setEstadoCivil("                 ");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Estado Civil nao pode conter apenas espacos",e.getMessage());
    	}
    	
    	Assert.assertEquals("novoEstadoCivil",funcionario.getEstadoCivil());
    	
    	//Testanto o metodo toString()
    	Assert.assertEquals("Pessoa: nomeCompleto = nome ,cpf = 00000000000 ,rg = 0000000, endereco=null ,telefone = 00000000 ,email = semEmail@.com Estado civil = novoEstadoCivil Naturalidade = novaNaturalidade",funcionario.toString());
    }
}
