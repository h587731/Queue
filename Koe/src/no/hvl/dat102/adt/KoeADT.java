package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public interface KoeADT<T> {
 

public void enQueue (T element);
  

/**
 * Fjerner et element p� toppen av stabelen og returnerer referansen
 * Kaster unntak EmptyCollectionException hvis stabelen allerde er tom.
 * @return T element fjernes fra toppen av stabelen
 * @throws EmptyCollectionException n�r stabelen er tom
 */
public T deQueue();


public T peek();


public boolean isEmpty();


  /**
   * Returnerer antall elementer p� stabelen.
 * @return antall elementer p� stabelen
 */
public int antall();
  


}

