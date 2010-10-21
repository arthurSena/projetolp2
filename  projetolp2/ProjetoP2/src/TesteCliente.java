import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

public class TesteCliente {
	
	private Cliente cliente1;
    private Cliente cliente2;
    private Endereco endereco;
   
    @Before public void Teste(){
        try{
            cliente1 = new Cliente("00000000000","nome","0000000",null,"00000000","semEmail@.com",null);
            cliente1 =  new Cliente("cpfNaoPodeConterLetra","nome","0000000",null,"00000000","semEmail@.com",null);
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
        	 cliente2=new Cliente("00000000000","nome","0000000",endereco,"00000000","semEmail@.com",null);
        	 cliente2=new Cliente("00000000000","nome","0000000",null,"telefoneNaoPodeConterNumeros101","semEmail@.com",null);
        }
        catch(Exception e){
        	 Assert.assertEquals("Telefone Invalido",e.getMessage());
        }
    }

    @Test public void testandoCliente1(){
    	//Testando o Metodo get()
        Assert.assertEquals(cliente1.getCPF(),"00000000000");
        Assert.assertEquals(cliente1.nomeCompleto(),"nome");
        Assert.assertEquals(cliente1.getRg(), "0000000");
        Assert.assertEquals(cliente1.getTelefone(),"00000000");
        Assert.assertEquals(cliente1.getEmail(),"semEmail@.com");
        
        //Testando o toString()
        Assert.assertEquals(cliente1.toString(),"Pessoa: nomeCompleto = nome ,cpf = 00000000000 ,rg = 0000000, endereco=null ,telefone = 00000000 ,email = semEmail@.com");
        
       //Testando o metodo set()
        
       try{
    	   cliente1.setCPF("10000000000");
    	   cliente1.setCPF("123");
       }
       catch(Exception e){
    	   Assert.assertEquals(e.getMessage(),"CPF Invalido");
       }
       Assert.assertEquals(cliente1.getCPF(),"10000000000");
       
       try{
    	   cliente1.setNome("novoNome");
    	   cliente1.setNome("novoNome1");
       }
       catch(Exception e){
    	   Assert.assertEquals("Nome Invalido",e.getMessage());
       }
       Assert.assertEquals(cliente1.nomeCompleto(),"novoNome");
       
       try{
    	   cliente1.setTelefone("10000000");
    	   cliente1.setTelefone("telefoneNaoPodeConterLetras");
       }
       catch(Exception e){
    	   Assert.assertEquals("Telefone Invalido",e.getMessage());
       }
       
       try{
    	   cliente1.setEmail("novoEmail@.com");
    	   cliente1.setEmail("");
       }
       catch(Exception e){
    	   Assert.assertEquals("Email Invalido",e.getMessage());
       }
       
       //Testando o metodo equals()
       Assert.assertFalse(cliente1.equals(cliente2));
       
    }
    @Test public void testandoCliente2(){
    	//Testando o Metodo get()
        Assert.assertEquals(cliente2.getCPF(),"00000000000");
        Assert.assertEquals(cliente2.nomeCompleto(),"nome");
        Assert.assertEquals(cliente2.getRg(), "0000000");
        Assert.assertEquals(cliente2.getTelefone(),"00000000");
        Assert.assertEquals(cliente2.getEmail(),"semEmail@.com");
        
        //Testando Metodo set()
        
        //-----------------------------Bairro--------------
       try{
        	cliente2.setBairro("novoBairro");

        	cliente2.setBairro("novoBairroNaoPodeConterNumero101");
        	
        }
        catch(Exception e){
        	 Assert.assertEquals("Bairro Invalido",e.getMessage());
        }
        
        Assert.assertTrue(cliente2.getEndereco().getBairro().equals("novoBairro"));
        
        //-----------------------------CEP----------------------
        try{
        	cliente2.setCEP("50000000");
        	cliente2.setCEP("cepNaoPodeConterLetra");
        }
        catch(Exception e){
        	Assert.assertEquals("CEP Invalido",e.getMessage());
       }
        
        Assert.assertTrue(cliente2.getEndereco().getCep().equals("50000000"));
        
        //----------------------------Cidade---------------------
        try{
        	cliente2.setCidade("nova Cidade");
        	cliente2.setCidade("CidadeNaoPodeConterDigitos101");
        }
        catch(Exception e){
        	Assert.assertEquals("Cidade Invalida",e.getMessage());
        }
        
        Assert.assertTrue(cliente2.getEndereco().getCidade().equals("nova Cidade"));
        
        //--------------------------Estado-----------------------
        try{
        	cliente2.setEstado("novoEstado");
        	cliente2.setEstado("EstadoNaoPodeConterNumeros101");
        }
        catch(Exception e){
        	Assert.assertEquals("Estado Invalido",e.getMessage());
        }

        Assert.assertTrue(cliente2.getEndereco().getEstado().equals("novoEstado"));
        
        //---------------------------Rua----------------------------------
        try{
        	cliente2.setRua("novaRua");
        	cliente2.setRua("RuaNaoPodeConterDigitos101");
        }
        catch(Exception e){
        	Assert.assertEquals("Rua Invalida",e.getMessage());
        }

        Assert.assertTrue(cliente2.getEndereco().getRua().equals("novaRua"));
        
        //--------------------------Numero da Casa---------------------
        try{
        	cliente2.setNumeroDaCasa("101");
        	cliente2.setNumeroDaCasa("          ");
        }
        
        catch(Exception e){
        	Assert.assertEquals("Numero Invalido",e.getMessage());
        }

        Assert.assertTrue(cliente2.getEndereco().numero().equals("101"));
        
        //Testando o metodo toString()
        Assert.assertEquals(cliente2.toString(), "Pessoa: nomeCompleto = nome ,cpf = 00000000000 ,rg = 0000000, endereco=Estado: novoEstadoCidade: nova CidadeBairro: novoBairroRua: novaRuaNumero: 101CEP: 50000000 ,telefone = 00000000 ,email = semEmail@.com");
     
        
        //Testando Equals
        
        Assert.assertTrue(cliente1.equals(cliente2));
        
        
    }

}
