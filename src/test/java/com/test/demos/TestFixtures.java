package com.test.demos;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe regroupant un ensemble de Traitement standard <br>
 * Attention : Vous pouvez nommer les méthodes comme vous voulez, à condition
 * que le nom soit le plus expressif possible <br>
 * 
 * @author devlopix
 *
 */
@DisplayName("Classe StandardTests !")
class TestFixtures {
	/**
	 * La méthode initAll() sera invoqué automatiquement une seule fois dans le tous
	 * début de l'exécution des tests inclus dans cette classe
	 */
	@BeforeAll
	static void initAll() {
		System.out.println("StandardTests.initAll() : Je suis executé avant l'ensemble des tests, une seule fois !");
	}

	/**
	 * La méthode Init sera invoqué automatiquement avant chaque execution de
	 * méthode de test
	 */
	@BeforeEach
	void init() {
	}

	/**
	 * Ce test va réussir, c'est normal il test rien. Donc il passe toujours !
	 */
	@DisplayName("Le test qui réussi toujours !")
	@Test
	void succeedingTest() {
	}

	/**
	 * Un test qui va surement échoué, à cause de la l'appel de la méthode fail
	 */
	@Test
	void failingTest() {
		fail("a failing test");
	}

	/**
	 * Des fois on veut simplement ignorer un Test sans retirer le code de la classe
	 * de test, alors on lui met l'annotation @Disavled
	 */
	@Test
	@Disabled("for demonstration purposes")
	void skippedTest() {
		// not executed
	}

	/**
	 * abortedTest() est une méthode de test qui montre l'appel à la méthode fail(),
	 * un appel qui va systhématiquement mettre fin à l'execution de ce test.
	 */
	@Test
	void abortedTest() {
		assumeTrue("abc".contains("Z"));
		fail("test should have been aborted");
	}

	/**
	 * La méthode tearDown sera invoqué automatiquement après chaque execution de
	 * méthode de test
	 */
	@AfterEach
	void tearDown() {
	}

	/**
	 * La méthode tearDownAll() sera invoqué une seule après l'accomplissement de
	 * tous les tests inclus dans cette classe
	 */
	@AfterAll
	static void tearDownAll() {

		System.out.println(
				"StandardTests.tearDownAll() : Je suis executé après l'accomplissement des tests, une seule fois !");
	}
}
