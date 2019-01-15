package com.mascamo.dev.TestCases;

import org.testng.annotations.Test;

public class MavenUserTest {
	@Test(groups= {"group1"})
	public void user1() {

		System.out.println("user1 group 1 ");

	}
 @Test(groups= {"group2"})
	public void user2() {

		System.out.println("user2  group 2 ");

	}
 @Test(groups= {"group1"})
	public void user3() {

		System.out.println("user3 group 1");

	}
}
