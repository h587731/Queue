package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public interface KoeADT<T> {
 
	
/**
* Legger til et element paa bakersti koen, utvider hvis behov
* @param element generisk element som stiller seg i koe
*/
public void enQueue (T element);
  

/**
 * Fjerner et element på fremst i koen og returnerer referansen
 * Kaster unntak EmptyCollectionException hvis koen allerde er tom.
 * @return T element fjernes fra fremst i koen
 * @exception EmptyCollectionException når koener tom
 */
public T deQueue();

/**
 * Returenerer referansen til elementet paa fremst  i koen.
 * Elementet blir ikke fjernet.
 * Kaster unntaket EmptyCollectionException hvis koen allerde er tom.
 * @return T element Fremst i koen.
 * @exception EmptyCollectionException naar koen er tom
 */
public T peek();

/** 
*  Bestemmer om det er plass i koen.
* @return sann hvis tom koe
*/
public boolean isEmpty();


 /**
 * Returnerer antall elementer på koen.
 * @return antall elementer i koen
 */
public int antall();
  


}

