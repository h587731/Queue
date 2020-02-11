package no.hvl.dat102.tabell;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;


//********************************************************************
//
//Representerer en samling k�, implementert vha en tabell.
  // foran er i posisjon 0.
//********************************************************************

public class TabellKoe<T> implements KoeADT<T>{
 private final static int STDK = 100;
 private int bak;
 private T[] koe; 

 /******************************************************************
   Oppretter en tom k� med standard st�rrelse.
   ******************************************************************/
 public TabellKoe()   {
   this(STDK);     
 }

 /******************************************************************
   Oppretter en tom k� med kapasitet gitt ved parameter
 ******************************************************************/
 public TabellKoe (int startKapasitet){
    bak = 0;     
    koe = (T[])(new Object[startKapasitet]);
  }

@Override
public void enQueue(T element) {
	// TODO Auto-generated method stub
	
}

@Override
public T deQueue() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public T first() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int antall() {
	// TODO Auto-generated method stub
	return 0;
}

 //....
 
}//class



