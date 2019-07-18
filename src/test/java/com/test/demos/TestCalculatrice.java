package com.test.demos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.test.model.Calculatrice;

class TestCalculatrice {

	private final Calculatrice calculator = new Calculatrice();

	@Test
	@DisplayName("+ :)")
	void testAjouter() {
		assertEquals(8, calculator.ajouter(2, 6), () -> "opération d'ajout : 2+6 = " + (2 + 3));
	}

	@Test
	@DisplayName("ajouter() ne doit pas dépasser 1 ms !")
	void testAjouterTimeOut() {
		// will not not aborted if timeout exeeded
		assertTimeout(Duration.ofMillis(1), () -> calculator.ajouter(1, 2));

		// will be aborted if timeout exceeded
		// assertTimeoutPreemptively(Duration.ofMillis(1), () ->
		// calculator.ajouter(1,2));
	}

	@RepeatedTest(value = 5, name = "execution ajouter() {currentRepetition} / {totalRepetitions}")
	void testerAjouterPlusieurFois() {
		assertEquals(1, calculator.ajouter(1, 0));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void ifStartsWithR(String candidate) {
		assertTrue(candidate + " ne commence pas avec 'r'", candidate.startsWith("r"));
	}
	
	

}
