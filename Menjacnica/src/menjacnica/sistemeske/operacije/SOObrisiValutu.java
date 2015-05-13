package menjacnica.sistemeske.operacije;
import java.util.LinkedList;

import menjacnica.*;
public class SOObrisiValutu {

	public static void obrisiValutu(Valuta valuta,LinkedList<Valuta> kursnaLista) {
		if (!kursnaLista.contains(valuta))
			throw new RuntimeException("Valuta ne postoji u kursnoj listi");
		
		kursnaLista.remove(valuta);
	}
}
