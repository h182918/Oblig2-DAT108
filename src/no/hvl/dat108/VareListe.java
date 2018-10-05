package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class VareListe extends Thread{
	 private List<String> liste = new ArrayList<>();
	    
	    public void leggTil(String item) {
	        liste.add(item);
	    }
	    
	    public List<String> hent() {
	        return liste;
	    }
	    
	    public int str() {
	        return liste.size();
	    }
	    
	    public void slett(String vare) {
	    	liste.remove(vare);
	    }
}

