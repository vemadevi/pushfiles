package com.automationtesting.testngconcpt;

public class NormalMethod {
public void Launchbrowser() {
System.out.println("Launch browser");
}
public void Launchurl() {
	System.out.println("Launchurl");
}
public void Login() {
	System.out.println("Login");
}
public void Sendmail() {
	System.out.println("Sendmail");
}
public void Logout() {
	System.out.println("Logout");
}
public void teardown() {
	System.out.println("closebrowser");
}
public static void main(String[] args) {
	NormalMethod test=new NormalMethod();
	test.Launchbrowser();
	test.Launchurl();
	test.Login();
	test.Sendmail();
	test.Logout();
	test.teardown();
}
}
