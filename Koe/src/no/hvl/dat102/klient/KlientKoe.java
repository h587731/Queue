package no.hvl.dat102.klient;

import no.hvl.dat102.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.tabell.TabellKoe;

public class KlientKoe {
	public static void main(String[] args) {

		String str = "Dette er teksten";
		int lengde = str.length();
		KoeADT<Character> tegnKoe = new KjedetKoe<Character>();
		for (int i = 0; i < lengde; i++) {
			tegnKoe.enQueue((str.charAt(i)));
		}
		
		System.out.println(str);
		try {
			while (!tegnKoe.isEmpty()) {
				Character tegn = tegnKoe.deQueue();
				System.out.print(tegn);
			}
			System.out.println();
		} catch (EmptyCollectionException ex) {
			System.out.println(ex.getMessage());
		}
	} 

}// class
