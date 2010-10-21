
import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

public class TestePessoa {
   
    private Pessoa pessoa1;
    private Pessoa pessoa2;
    private Endereco endereco;
   
    @Before public void Teste(){
        try{
            pessoa1 = new Pessoa("00000000000","nome","0000000",null,"00000000","semEmail@.com");
            pessoa1 =  new Pessoa("cpfNaoPodeConterLetra","nome","0000000",null,"00000000","semEmail@.com");
        }
        catch(Exception e){
            Assert.assertEquals("CPF Invalido",e.getMessage());
        }
        
        try{
        	endereco = new Endereco("estado",  "cidade",  "rua",  "bairro",  "numero",  "12345");
        	endereco = new Endereco("estado",  "cidade",  "rua",  "bairro",  "numero",  "12345s");
        }
        
        catch(Exception e){
        	Assert.assertEquals(e.getMessage(),"Dado(s) Invalido(s)");
        }
        
        try{
        	 pessoa2=new Pessoa("00000000000","nome","0000000",endereco,"00000000","semEmail@.com");
        	 pessoa2=new Pessoa("00000000000","nome","0000000",null,"telefoneNaoPodeConterNumeros101","semEmail@.com");
        }
        catch(Exception e){
        	 Assert.assertEquals("Telefone Invalido",e.getMessage());
        }
    }

    @Test public void testandoPessoa1(){
    	//Testando o Metodo get()
        Assert.assertEquals(pessoa1.getCPF(),"00000000000");
        Assert.assertEquals(pessoa1.nomeCompleto(),"nome");
        Assert.assertEquals(pessoa1.getRg(), "0000000");
        Assert.assertEquals(pessoa1.getTelefone(),"00000000");
        Assert.assertEquals(pessoa1.getEmail(),"semEmail@.com");
        
        //Testando o toString()
        Assert.assertEquals(pessoa1.toString(),"Pessoa: nomeCompleto = nome ,cpf = 00000000000 ,rg = 0000000, endereco=null ,telefone = 00000000 ,email = semEmail@.com");
        
       //Testando o metodo set()
        
       try{
    	   pessoa1.setCPF("10000000000");
    	   pessoa1.setCPF("123");
       }
       catch(Exception e){
    	   Assert.assertEquals(e.getMessage(),"CPF Invalido");
       }
       Assert.assertEquals("10000000000",pessoa1.getCPF());
       
       try{
    	   pessoa1.setNome("novoNome");
    	   pessoa1.setNome("novoNome1");
       }
       catch(Exception e){
    	   Assert.assertEquals("Nome Invalido",e.getMessage());
       }
       Assert.assertEquals(pessoa1.nomeCompleto(),"novoNome");
       
       try{
    	   pessoa1.setTelefone("10000000");
    	   pessoa1.setTelefone("telefoneNaoPodeConterLetras");
       }
       catch(Exception e){
    	   Assert.assertEquals("Telefone Invalido",e.getMessage());
       }
       
       try{
    	   pessoa1.setEmail("novoEmail@.com");
    	   pessoa1.setEmail("");
       }
       catch(Exception e){
    	   Assert.assertEquals("Email Invalido",e.getMessage());
       }
       
       //Testando o metodo equals()
       Assert.assertFalse(pessoa1.equals(pessoa2));
       
    }
    @Test public void testandoPessoa2(){
    	//Testando o Metodo get()
        Assert.assertEquals(pessoa2.getCPF(),"00000000000");
        Assert.assertEquals(pessoa2.nomeCompleto(),"nome");
        Assert.assertEquals(pessoa2.getRg(), "0000000");
        Assert.assertEquals(pessoa2.getTelefone(),"00000000");
        Assert.assertEquals(pessoa2.getEmail(),"semEmail@.com");
        
        //Testando Metodo set()
        
        //-----------------------------Bairro--------------
       try{
        	pessoa2.setBairro("novoBairro");

        	pessoa2.setBairro("novoBairroNaoPodeConterNumero101");
        	
        }
        catch(Exception e){
        	 Assert.assertEquals("Bairro Invalido",e.getMessage());
        }
        
        Assert.assertTrue(pessoa2.getEndereco().getBairro().equals("novoBairro"));
        
        //-----------------------------CEP----------------------
        try{
        	pessoa2.setCEP("50000000");
        	pessoa2.setCEP("cepNaoPodeConterLetra");
        }
        catch(Exception e){
        	Assert.assertEquals("CEP Invalido",e.getMessage());
       }
        
        Assert.assertTrue(pessoa2.getEndereco().getCep().equals("50000000"));
        
        //----------------------------Cidade---------------------
        try{
        	pessoa2.setCidade("nova Cidade");
        	pessoa2.setCidade("CidadeNaoPodeConterDigitos101");
        }
        catch(Exception e){
        	Assert.assertEquals("Cidade Invalida",e.getMessage());
        }
        
        Assert.assertTrue(pessoa2.getEndereco().getCidade().equals("nova Cidade"));
        
        //--------------------------Estado-----------------------
        try{
        	pessoa2.setEstado("novoEstado");
        	pessoa2.setEstado("EstadoNaoPodeConterNumeros101");
        }
        catch(Exception e){
        	Assert.assertEquals("Estado Invalido",e.getMessage());
        }

        Assert.assertTrue(pessoa2.getEndereco().getEstado().equals("novoEstado"));
        
        //---------------------------Rua----------------------------------
        try{
        	pessoa2.setRua("novaRua");
        	pessoa2.setRua("RuaNaoPodeConterDigitos101");
        }
        catch(Exception e){
        	Assert.assertEquals("Rua Invalida",e.getMessage());
        }

        Assert.assertTrue(pessoa2.getEndereco().getRua().equals("novaRua"));
        
        //--------------------------Numero da Casa---------------------
        try{
        	pessoa2.setNumeroDaCasa("101");
        	pessoa2.setNumeroDaCasa("          ");
        }
        
        catch(Exception e){
        	Assert.assertEquals("Numero Invalido",e.getMessage());
        }

        Assert.assertTrue(pessoa2.getEndereco().numero().equals("101"));
        
        //Testando o metodo toString()
        Assert.assertEquals(pessoa2.toString(), "Pessoa: nomeCompleto = nome ,cpf = 00000000000 ,rg = 0000000, endereco=Estado: novoEstadoCidade: nova CidadeBairro: novoBairroRua: novaRuaNumero: 101CEP: 50000000 ,telefone = 00000000 ,email = semEmail@.com");
     
        
        //Testando Equals
        
        Assert.assertTrue(pessoa1.equals(pessoa2));
        
        
    }
}
