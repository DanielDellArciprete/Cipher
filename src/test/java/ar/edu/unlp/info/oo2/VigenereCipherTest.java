package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VigenereCipherTest {

	VigenereCipher vigenere;
	String key = "hola";
	String abc = "abcdefghijklmnopqrstuvwxyz";

	@BeforeEach
	void setUp() throws Exception {
		vigenere = new VigenereCipher(abc,key);
	}

	@Test
	public void testEspacios() {
		assertEquals("ocwa toxa", vigenere.cipher("hola mama"));
	}

	@Test
	public void testSinEspacios() {
		assertEquals("icna", vigenere.cipher("boca"));
	}

	@Test
	public void testMayus() {
		assertEquals("A", vigenere.cipher("A"));
	}

	@Test
	public void testLetraÑ() {
		assertEquals("ñ", vigenere.cipher("ñ"));
	}
	
	@Test
	public void testTilde() {
		assertEquals("á", vigenere.cipher("á"));
	}


	@Test
	public void testSaltoCero() {
		vigenere = new VigenereCipher(abc, "");
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			vigenere.cipher("hola mama");
		});
	}

	@Test
	public void testSinAlfabeto() {
		vigenere = new VigenereCipher("", key);
		assertEquals("boca", vigenere.cipher("boca"));
	}

}
