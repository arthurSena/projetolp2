package projeto.versao1;

import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

public class TesteSuite {
	
	Suite suite1 ;
	Suite suite2 ;
	Suite suite3 ;
	
	@Before public void Test(){
		suite1 = new Suite(Suite.Estado.livre);
		suite2 = new Suite(Suite.Estado.ocupado);
		suite3 = new Suite(Suite.Estado.reservado);
	}
	
	@Test public void Testando(){
		//Testando metodo get()
		Assert.assertEquals(Suite.Estado.livre, suite1.getEstado());
		Assert.assertEquals(Suite.Estado.ocupado, suite2.getEstado());
		Assert.assertEquals(Suite.Estado.reservado, suite3.getEstado());
		
		//Testando metod set()
		suite1.setEstado(Suite.Estado.ocupado);
		Assert.assertEquals(Suite.Estado.ocupado, suite1.getEstado());
		
		suite2.setEstado(Suite.Estado.livre);
		Assert.assertEquals(Suite.Estado.livre, suite2.getEstado());
		
		suite3.setEstado(Suite.Estado.livre);
		Assert.assertEquals(Suite.Estado.livre, suite3.getEstado());
		
	}

}
