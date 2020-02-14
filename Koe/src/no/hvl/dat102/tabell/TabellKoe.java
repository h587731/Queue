package no.hvl.dat102.tabell;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

public class TabellKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int bak;
	private T[] koe;

	public TabellKoe() {
		this(STDK);
	}

	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}
     //...

	void utvid() {
		
		T[] nyKoe = ((T[]) (new Object[koe.length*2+1]));
		for(int i = 0; i < koe.length ; i++) {
			
			nyKoe[i] = koe[i];
		}
	koe=nyKoe;
	}
	
	@Override
	public void enQueue(T element) {
		
		if(bak==koe.length) {
			utvid();
		}
		
		koe[bak] = element;
		bak++;
		
		
		
	}

	@Override
	public T deQueue() {
		
		if(isEmpty()) {
			throw new EmptyCollectionException("Koe");
		}
		
		T temp = koe[0];
		for(int i = 0; i < koe.length-1 ; i++) {
			
			koe[i] = koe[i+1]; 
		}
		bak--;
		return temp;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Koe");
		
		return koe[0];
	}

	@Override
	public boolean isEmpty() {
		return bak==0;
	}

	@Override
	public int antall() {
		return bak;
	}
	
}// class

