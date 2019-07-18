package com.test.demos;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConditionalTestExecDemo {

	/**
	 * Sera executé seulement sur les systemes Linux
	 */
	@EnabledOnOs(OS.LINUX)
	@Test
	void thisTestRunsOnlyOnLinux() {
		System.out.println("Will Run only on Linux OS");
	}

	/**
	 * Ne sera pas executé sur Liunx
	 */
	@Test
	@DisabledOnOs(OS.LINUX)
	void thisTestRunsInAllOSExceptLinux() {
		System.out.println("Will Run only on Linux OS");
	}

	/**
	 * Sera executé seuelement sur les machines ayant un os 64 bits
	 */
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	@Test
	void testRunsOnlyIfIn64Arch() {
		System.out.println("THis test is running, because you are in 64 arch !");
	}

	/**
	 * Sera executé seuelement sur les machines n'ayant pas un os 64 bits
	 */
	@DisabledIfSystemProperty(named = "os.user", matches = "devlopix")
	@Test
	void testRunsOnlyIfNotIn64Arch() {
		System.out.println("THis test is running, beacause the user name is : " + System.getenv("USER"));
	}

	/**
	 * Sera executé seuelement si on est sur JRE9 ou JRE10
	 */
	@EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
	@Test
	void thisTestRunsOnlyInJava9and10() {
		System.out.println("I will run only in java 9 and java 10");
	}

	/**
	 * Ce test est désactivé
	 */
	@Test
	@Disabled
	void test() {
		System.out.println("...");
	}

}
