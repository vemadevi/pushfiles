package com.automationtesting.testngconcpt;

import org.testng.annotations.Test;

public class TestngConcept {
	@Test
	public void Launchbrowser() {
		System.out.println("Launchbrowser");
		}
	@Test
		public void Launchurl() {
			System.out.println("Launchurl");
		}
	@Test
		public void Login() {
			System.out.println("Login");
		}
	@Test
		public void Sendmail() {
			System.out.println("Sendmail");
		}
	@Test
		public void Logout() {
			System.out.println("Logout");
		}
	@Test
		public void teardown() {
			System.out.println("closebrowser");
		}

}
