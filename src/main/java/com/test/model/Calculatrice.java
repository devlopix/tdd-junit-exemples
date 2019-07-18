package com.test.model;

public class Calculatrice {

	/**
	 * Fonction ajouter, fait l'addition de deux entiers et retourne un entier
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int ajouter(int i, int j) {
		return i + j;
	}

	public double diviser(double a, double b) throws ArithmeticException {
		if (b == 0)
			throw new ArithmeticException("/ par zero !");
		else
			return a / b;
	}

}
