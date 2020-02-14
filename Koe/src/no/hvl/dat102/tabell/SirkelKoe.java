package no.hvl.dat102.tabell;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.EmptyCollectionException;



//********************************************************************
//
//Representerer en samling kø, implementert vha en tabell.
  // foran er i posisjon 0.
//********************************************************************

public class SirkelKoe<T> implements KoeADT<T>{
 private final static int STDK = 100;
 private int bak, front, antall; 
 private T[] koe; 

 /******************************************************************
   Oppretter en tom kø med standard størrelse.
   ******************************************************************/
 public SirkelKoe()   {
   this(STDK);     
 }

 /******************************************************************
   Oppretter en tom kø med kapasitet gitt ved parameter
 ******************************************************************/
 public SirkelKoe (int startKapasitet){
    bak = 0;     
    koe = (T[])(new Object[startKapasitet]);
    antall=0;
  }

 
 public int koeReturn() {
	 
	 return koe.length;
 }
 
 private boolean erFull() {
	 // skjekker om front og bak blir ved siden av 
	 if(antall==koe.length) {
		 return true;
	 }
	 
	 return false;
	 
 }
 
 
 private void utvid() {
	 
	 T[]nyKoe = (T[])(new Object[koe.length*2+1]);
	 
	 for(int i = 0; i < koe.length; i++) {
		 
		 nyKoe[i] = koe[front];
		 front= (front+1)%koe.length;
		 
	 }
	 // Front settes som 0 altså først og bak settes til siste element. som er length -1
	 // om koe er full og har 5 elementer, skal nye bak peke 5 minus 1. 
	
	 front= 0;
	 bak = koe.length-1;
	 koe = nyKoe;
	 
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
		antall++;
		return;
		
	}
	// For bak til å peke på neste ledig posisjon
	 bak = (bak + 1)% koe.length; 
     koe[bak] = element; 
     antall++; 
	
	// ny element
	
	
	
	
	
}

@Override
public T deQueue() {
	
	if(isEmpty()) {
		throw new EmptyCollectionException("Koe");
	}
	antall--;
	T temp = koe[front];
	
	// fjerne front
	koe[front] = null;
	if(isEmpty()) {
		front=bak=0;
		return temp;
	}
	front= front+1%koe.length;
	
	// oppdatere front
	
	return temp;
}

@Override
public T peek() {
	if(isEmpty()) {
		throw new EmptyCollectionException("Koe");
	}
	return koe[front];
}

@Override
public boolean isEmpty() {
	return antall==0;
}

@Override
public int antall() {
	return antall;
}

 
}//class



