package no.hvl.dat108.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import no.hvl.dat108.VareListe;

public class Handletester {
	VareListe testListe = new VareListe();
	
	@Test
	public void leggTil1(){
		testListe.leggTil("");
		assertTrue(testListe.str() == 1);
	}
	
	@Test
	public void leggTil2slett1(){
		testListe.leggTil("");
		testListe.leggTil("1");
		assertTrue(testListe.str() == 2);
		testListe.slett("1");
		assertTrue(testListe.str() == 1);
	}
	
	

}
