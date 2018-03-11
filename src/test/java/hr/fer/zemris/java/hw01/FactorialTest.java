package hr.fer.zemris.java.hw01;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class FactorialTest {
	
	@Test
	public void testInteger() {
		assertEquals(6, Factorial.calculate(3));
	}
	
	@Test
	public void testUnderBound() {
		assertEquals(0, Factorial.calculate(-1));
	}
}
