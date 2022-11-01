/**
 * 
 */
package ar.edu.unlp.info.oo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {

	CesarCipher cesar;
	int saltos = 3;
	String abc = "abcdefghijklmnopqrstuvwxyz";

	@BeforeEach
	void setUp() throws Exception {
		cesar = new CesarCipher(saltos, abc);
	}

	@Test
	public void testEspacios() {
		assertEquals("krod pdpd", cesar.cipher("hola mama"));
	}

	@Test
	public void testSinEspacios() {
		assertEquals("erfd", cesar.cipher("boca"));
	}

	@Test
	public void testMayus() {
		assertEquals("A", cesar.cipher("A"));
	}

	@Test
	public void testLetraÑ() {
		assertEquals("ñ", cesar.cipher("ñ"));
	}
	
	@Test
	public void testTilde() {
		assertEquals("á", cesar.cipher("á"));
	}


	@Test
	public void testSaltoCero() {
		cesar = new CesarCipher(0, abc);
		assertEquals("hola mama", cesar.cipher("hola mama"));
	}

	@Test
	public void testSaltoNegativo() {
		cesar = new CesarCipher(-1, abc);
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			cesar.cipher("hola mama");
		});
	}

	@Test
	public void testSinAlfabeto() {
		cesar = new CesarCipher(3, "");
		assertEquals("boca", cesar.cipher("boca"));
	}

	@Test
	public void testUltimosCaracteres() {
		cesar = new CesarCipher(3, abc);
		assertEquals("abc", cesar.cipher("xyz"));
	}
}
