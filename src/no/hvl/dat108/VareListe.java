package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class VareListe {
	 private List<String> liste = new ArrayList<>();
	    
	    public void leggTil(String item) {
	        liste.add(item);
	    }
	    
	    public List<String> hent() {
	        return liste;
	    }

	    
	 //Laget om fra Vareobjekt til string fordi enklere å slette og opprette.
	    //problemer med å slette
	
}

