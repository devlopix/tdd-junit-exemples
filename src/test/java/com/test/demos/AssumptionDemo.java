package com.test.demos;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

class AssumptionDemo {

	@Test
	void testEnv() {
		/*
		 * Si l'utilisateur de la session system en cours est 'devlopix', je continue mon test, sinon je 
		 */
		assumeTrue(System.getenv("USER").equals("devlopix"),
				() -> "Ce test s'execute selement sur la session de devlopix");
		System.out.println("Ce message sera afficher si est seulement si l'utilisateur du système est : devlopix");
	}
	
	
}
