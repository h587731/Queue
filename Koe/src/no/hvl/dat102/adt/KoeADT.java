package no.hvl.dat102.adt;

import no.hvl.dat102.exception.EmptyCollectionException;

public interface KoeADT<T> {
 

public void enQueue (T element);
  

/**
 * Fjerner et element på toppen av stabelen og returnerer referansen
 * Kaster unntak EmptyCollectionException hvis stabelen allerde er tom.
 * @return T element fjernes fra toppen av stabelen
 * @throws EmptyCollectionException når stabelen er tom
 */
public T deQueue();


public T first();


public boolean isEmpty();



public String toString();

  /**
   * Returnerer antall elementer på stabelen.
 * @return antall elementer på stabelen
 */
public int antall();
  
}

