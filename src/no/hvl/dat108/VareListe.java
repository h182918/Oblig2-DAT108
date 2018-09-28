package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class VareListe {
	 private List<Vare> liste = new ArrayList<>();
	    
	    public void leggTil(Vare item) {
	        liste.add(item);
	    }
	    
	    public List<Vare> hent() {
	        return liste;
	    }

}
