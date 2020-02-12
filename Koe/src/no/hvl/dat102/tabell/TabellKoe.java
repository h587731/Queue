package no.hvl.dat102.tabell;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.kjedet.LinearNode;


//********************************************************************
//
//Representerer en samling kø, implementert vha en tabell.
  // foran er i posisjon 0.
//********************************************************************

public class TabellKoe<T> implements KoeADT<T>{
 private final static int STDK = 100;
 private int bak, front, antall; 
 private T[] koe; 

 /******************************************************************
   Oppretter en tom kø med standard størrelse.
   ******************************************************************/
 public TabellKoe()   {
   this(STDK);     
 }

 /******************************************************************
   Oppretter en tom kø med kapasitet gitt ved parameter
 ******************************************************************/
 public TabellKoe (int startKapasitet){
    bak = 0;     
    koe = (T[])(new Object[startKapasitet]);
    antall=0;
  }

 
 private boolean erFull() {
	 
	 if(bak+1%koe.length==front) {
		 return true;
	 }
	 
	 return false;
	 
 }
 
 
 private void utvid() {
	 T[]nyKoe = (T[])(new Object[koe.length*2+1]);
	 for(int i = 0; i < koe.length; i++) {
		 
		 nyKoe[i] = koe[i];
		 koe = nyKoe;
	 }
	 
	 
 }
 
@Override
public void enQueue(T element) {
	
	if(erFull()) {
		utvid();
	}
	
	// Er tom?
	if(koe[front] == null ) {
		koe[0] = element;
		front = bak = 0;
		
	}
	 bak = (bak + 1)% koe.length; 
     koe[bak] = element; 
     antall++; 
	
	// ny element
	
	
	
	
	
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



