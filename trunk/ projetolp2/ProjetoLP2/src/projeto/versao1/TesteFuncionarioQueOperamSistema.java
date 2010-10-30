package projeto.versao1;


import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;


public class TesteFuncionarioQueOperamSistema {
	
	FuncionarioQueOperamSistema funcionario1;
	
	@Before public void testeFuncionario1(){
		try {
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com","login","senha");
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com","      ","senha");
		} catch (Exception e) {
			Assert.assertEquals("Login nao pode conter apenas espacos",e.getMessage());
			
		}
		
		try{
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com","login","     ");
		} catch (Exception e) {
			Assert.assertEquals("Senha nao pode conter apenas espacos",e.getMessage());
			
		}
		
		try{
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com","","senha");
		} catch (Exception e) {
			Assert.assertEquals("Login nao pode ser vazio ou nulo",e.getMessage());
			
		}
		
		try{
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com",null,"senha");
		} catch (Exception e) {
			Assert.assertEquals("Login nao pode ser vazio ou nulo",e.getMessage());
			
		}
		
		try{
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com","login","");
		} catch (Exception e) {
			Assert.assertEquals("Senha nao pode ser vazia ou nula",e.getMessage());
			
		}
		
		try{
			funcionario1 = new FuncionarioQueOperamSistema("naturalidade","estadoCivil","00000000000","nome","0000000",null,"00000000","semEmail@.com","login",null);
		} catch (Exception e) {
			Assert.assertEquals("Senha nao pode ser vazia ou nula",e.getMessage());
			
		}
	}
	
	@Test public void tesFuncionario2(){
		//Testando metodo get()
		Assert.assertEquals("login",funcionario1.getLogin());
    	Assert.assertEquals("senha",funcionario1.getSenha());
		
    	//Testando metodo set()
    	
    	//--------------------------Login--------------------
    	try{
    		funcionario1.setLogin("novoLogin");
    		funcionario1.setLogin("");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Login nao pode ser vazio ou nulo",e.getMessage());
    	}
    	
    	Assert.assertEquals("novoLogin",funcionario1.getLogin());
    	
    	try{
    		funcionario1.setLogin(null);
    	}
    	catch(Exception e){
    		Assert.assertEquals("Login nao pode ser vazio ou nulo",e.getMessage());
    	}
    	
    	Assert.assertEquals("novoLogin",funcionario1.getLogin());
		
    	try{
    		funcionario1.setLogin("         ");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Login nao pode conter apenas espacos",e.getMessage());
    	}
    	
    	Assert.assertEquals("novoLogin",funcionario1.getLogin());
    	
    	//-----------------------Senha----------------------------
    	
    	try{
    		funcionario1.setSenha("novaSenha");
    		funcionario1.setSenha("");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Senha nao pode ser vazia ou nula",e.getMessage());
    	}
    	
    	Assert.assertEquals("novaSenha",funcionario1.getSenha());
    	
    	try{
    		funcionario1.setSenha(null);
    	}
    	catch(Exception e){
    		Assert.assertEquals("Senha nao pode ser vazia ou nula",e.getMessage());
    	}
    	
    	Assert.assertEquals("novaSenha",funcionario1.getSenha());
		
    	try{
    		funcionario1.setSenha("                    ");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Senha nao pode conter apenas espacos",e.getMessage());
    	}
    	
    	Assert.assertEquals("novaSenha",funcionario1.getSenha());
    	
    	//Testando metodo toString()
    	Assert.assertEquals("Pessoa: nomeCompleto = nome ,cpf = 00000000000 ,rg = 0000000, endereco=null ,telefone = 00000000 ,email = semEmail@.com Estado civil = estadoCivil Naturalidade = naturalidade Login = novoLogin Senha = novaSenha",funcionario1.toString());
	}
}