package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.kjedet.SirkelKoe;

public class SirkelKoeTest extends KoeADTTest {
	   @Override
		protected KoeADT<Integer> reset() {
			return new SirkelKoe<Integer>();
		}		
}
