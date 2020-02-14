package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * 
 * 
 * 
 * 
 * @author Eskil, Per Otto
 *
 * @param <T>
 */
public class KjedetKoe<T> implements KoeADT<T> {
	private int antall;
	private LinearNode<T> front, bak;
    //....
	
	 public KjedetKoe() {
		 this.antall = 0;
		 this.front =this.bak = null;
		 
	}
	
	@Override
	public void enQueue(T element) {
		
		
		LinearNode<T> temp = new LinearNode<T>(element);
		// F�rst skjekker v om koen er tom.
		// Om den er tom skal b�de front og bak peke p� nye elementet
			
	
		
		if(front==null && bak==null) {
			front = bak = temp;
			antall++;
			return;
		}
		
		bak.setNeste(temp);
		bak = temp;
		antall++;
	}
	
	
	@Override
	public T deQueue() {
		if (isEmpty())
			throw new EmptyCollectionException("Koe");
		
		LinearNode<T> temp = front;
		
		front = front.getNeste();
		if(front == null)	
			bak = null;
		antall--;
		
		return temp.getElement();
	
		
	}

		
	
	@Override
	public boolean isEmpty() {
		if(front == null) {
			return true;
			}
	       return false;
	}

	@Override
	public int antall() {
		return antall;
	}
	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Koe");
		return front.getElement();
	}
	
}// class
