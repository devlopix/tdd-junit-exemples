package com.test.demos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.test.model.Calculatrice;
import com.test.model.Personne;

class AssertionsDemo {
	Personne personne = new Personne("Sadane", "Otmane");
	Calculatrice calculatrice = new Calculatrice();

	
	@Test
	void testAssertionStandard() {
		assertEquals("o", personne.getPrenom(), "Ceci est un msg qui sera affiché en cas d'echec de ce test");
		assertEquals("d", personne.getPrenom(), "Ceci est un msg qui sera affiché en cas d'echec de ce test");
	}

	@Test
	void assertionsGroupes() {
		// Dans une assertion groupé toutes les assertions sont executés,
		// Et tous les echecs seront reportés ensemble

		assertAll("personne", () -> assertEquals("p", personne.getPrenom()),
				() -> assertEquals("g", personne.getNom()));
	}

	/**
	 * Je test si ma gestion d'exception fonctionne correctement Donc le test passe
	 * si une exception ArithmeticException est levée avec le message / par zero !
	 */
	@Test
	void exceptionTesting() {

		Exception exception = assertThrows(ArithmeticException.class, () -> calculatrice.diviser(1, 0));
		assertEquals("/ par zero !", exception.getMessage());
	}

	/**
	 * Objectif de test : Tester si calculatrice.ajouter(1, 2) va dépasser 1ms Si le
	 * traitement calculatrice.ajouter(1, 2) dépasse 1ms :
	 * 1 - le traitement calculatrice.ajouter(1, 2) va continuer son execution
	 * 2 - le test échoue
	 */
	@Test
	@DisplayName("Le traitement Calculatrice.ajouter(1,2) ne doit pas dépasser 1 ms !")
	void testAjouterTimeOut1() {
		/*
		 * Si Le traitement Calculatrice.ajouter(1,2) dépasse 1ms, le traitement va
		 * continuer, et va échouer.
		 * 
		 */
		assertTimeout(Duration.ofMillis(1), () -> calculatrice.ajouter(1, 2));
	}

	/**
	 * Objectif de test : Tester si calculatrice.ajouter(1, 2) va dépasser 1ms Si le
	 * traitement calculatrice.ajouter(1, 2) dépasse 1ms :
	 * 1 - le traitement calculatrice.ajouter(1, 2) sera arrété immédiatement
	 * 2 - le test échoue
	 */
	@Test
	@DisplayName("Le traitement Calculatrice.ajouter(1,2) ne doit pas dépasser 1 ms !")
	void testAjouterTimeOut2() {
		/*
		 * Si Le traitement Calculatrice.ajouter(1,2) dépasse 1ms, le traitement sera
		 * arrêter, et va échouer.
		 * 
		 */
		assertTimeoutPreemptively(Duration.ofMillis(1),
				() -> calculatrice.ajouter(1, 2));
	}

}
