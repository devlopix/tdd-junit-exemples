package com.test.demos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestDemo {

	/**
	 * Test paramétré depuis un fichier csv
	 * Regarder le fichier country.csv
	 * 
	 * @param country
	 * @param reference
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "country.csv", numLinesToSkip = 1)
	void testWithCsvFileSource(String country, int reference) {
		assertNotNull(country);
		assertNotEquals(0, reference);
	}

	/**
	 * Test parametré.
	 * Paramètres alimenté à travaers @ValueSource
	 * 
	 * @param candidate
	 */

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void ifStartsWithR(String candidate) {
		assertTrue(candidate + " ne commence pas avec 'r'", candidate.startsWith("r"));
	}

}
