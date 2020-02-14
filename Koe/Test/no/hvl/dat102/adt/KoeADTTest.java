package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

/**
 * Test for StabelADT.
 * 
 * @author Ole Olsen
 */
public abstract class KoeADTTest {

	// Referanse til stabel
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	
	
	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny stabel for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();

	}

	/**
	 * Test på at en ny stabel er tom.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.isEmpty());
	}

	/**
	 * Test opå push and pop.
	 */
	@Test
	public void enQueueOgDeQueue() {

		koe.enQueue(e0);
		koe.enQueue(e1);
		koe.enQueue(e2);
		koe.enQueue(e3);

		try {
			assertEquals(e0, koe.deQueue());
			assertEquals(e1, koe.deQueue());
			assertEquals(e2, koe.deQueue());
			assertEquals(e3, koe.deQueue());
		} catch (EmptyCollectionException e) {
			fail("deQueuefeilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på push og pop med duplikate verdier.
	 */
	@Test
	public void enQueueOgdeQueueMedDuplikater() {

		koe.enQueue(e0);
		koe.enQueue(e1);
		koe.enQueue(e1);
		koe.enQueue(e2);

		try {
			assertEquals(e0, koe.deQueue());
			assertEquals(e1, koe.deQueue());
			assertEquals(e1, koe.deQueue());
			assertEquals(e2, koe.deQueue());
		} catch (EmptyCollectionException e) {
			fail("deQueue feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing på peek.
	 */
	@Test
	public void enQueuedeQueueenQueueenQueuedeQueueFirst() {
		try {
			koe.enQueue(e2);
			koe.deQueue();
			koe.enQueue(e3);
			koe.enQueue(e4);
			koe.deQueue();
			assertEquals(e4, koe.peek());

		} catch (EmptyCollectionException e) {
			fail("deQueue feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på at en stabel med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.enQueue(e0);
		koe.enQueue(e1);
		assertFalse(koe.isEmpty());
	}

	/**
	 * Test på at en stabel med null elementer er tom.
	 */
	@Test
	public void enQueueDeQueueErTom() {
		try {
			koe.enQueue(e0);
			koe.deQueue();
			assertTrue(koe.isEmpty());

		} catch (EmptyCollectionException e) {
			fail("enQueue deQueue feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på størrelsen
	 */
	@Test
	public void stor() {
		koe.enQueue(e0);
		koe.enQueue(e1);
		koe.enQueue(e2);
		assertEquals(3, koe.antall());
	}

	/**
	 * Forsøk på deQueue av en tom stabel skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void deQueueFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.deQueue();
		});
	}
}
