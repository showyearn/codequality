package com.codequality.unittest.junit.powermock;

public class FinalClass {
	public String ask() {
		return "I'm Final class";
	}

	public final void say(String name) {
		throw new RuntimeException("Hi " + name);
	}
}
