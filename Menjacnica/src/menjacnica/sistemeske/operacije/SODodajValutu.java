package menjacnica.sistemeske.operacije;
import java.util.LinkedList;

import menjacnica.*;
public class SODodajValutu {

	public static void dodajValutu(Valuta valuta,LinkedList<Valuta> kursnaLista) {
		if (valuta==null)
			throw new RuntimeException("Valuta ne sme biti null");
		
		if (kursnaLista.contains(valuta))
			throw new RuntimeException("Valuta je vec uneta u kursnu listu");
		
		kursnaLista.add(valuta);		
	}
}
