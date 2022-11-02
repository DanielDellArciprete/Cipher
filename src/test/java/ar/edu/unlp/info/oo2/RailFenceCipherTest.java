package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RailFenceCipherTest {

	RailFenceCipher railFence;
	int rieles = 3;

	@BeforeEach
	void setUp() throws Exception {
		railFence = new RailFenceCipher(rieles);
	}

	@Test
	public void testEspacios() {
		assertEquals("h aoammla", railFence.cipher("hola mama"));
	}

	@Test
	public void testSinEspacios() {
		assertEquals("Aèéöâü", railFence.cipher("Aéüöèâ"));
	}

	@Test
	public void testPalabraCorta() {
		int rieles = 27;
		railFence = new RailFenceCipher(rieles);
		assertEquals("palabracorta", railFence.cipher("palabracorta"));
	}

	@Test
	public void testSinRieles() {
		int rieles = 0;
		railFence = new RailFenceCipher(rieles);
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			railFence.cipher("tstestethezteztte");
		});
	}
	
	@Test
	public void testEspaciosD(){
		assertEquals("hola mama", railFence.decipher("h aoammla"));
	}

	//agarrar 3 o 4 rieles y agarrar un mensaje muuuy largo 
	// @Test
	// public void testRielesNegativos(){
	// int rieles = -1;
	// railFence = new RailFenceCipher(rieles);
	// Assertions.assertThrows(NegativeArraySizeException.class, () -> { //Leer
	// documentación sobre la exception
	// railFence.cipher("tstestethezteztte");
	// });
	// }

}
