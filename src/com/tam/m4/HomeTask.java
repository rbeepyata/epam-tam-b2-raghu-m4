package com.tam.m4;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.epam.tat.module4.Calculator;

public class HomeTask {

	private Calculator calculator = new Calculator();

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Starting Test method...");
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("Test method Complete...");
	}

	@Test(groups = { "Smoke" })
	public void testAdditionOfTwoPositiveNumbers() {
		long a = 10, b = 20;
		long sum = calculator.sum(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t sum:"+sum);
		
		Assert.assertEquals(sum, a + b);
	}

	@Test(groups = { "Smoke" })
	public void testSubtractionOfTwoNumbers() {
		long a = 10, b = 20;
		long diff = calculator.sub(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t diff:"+diff);
		
		Assert.assertEquals(diff, a - b);
	}

	@Test(groups = { "Smoke" })
	public void testMultiplication() {
		long a = 10, b = 20;
		long product = calculator.mult(a, b);
		Reporter.log("a:" + a + "\t b:" + b + "\t product:" + product);

		Assert.assertEquals(product, a * b);

	}

	@Test
	public void testAdditionOfPositiveAndNegativeNumbers() {
		long a = 10, b = -20;
		long sum = calculator.sum(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t sum:"+sum);
		
		Assert.assertEquals(sum, a + b);
	}

	@Test
	public void testAdditionOfNegativeAndPositiveNumbers() {
		long a = -10;
		long b = 20;
		long sum = calculator.sum(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t sum:"+sum);
		
		Assert.assertEquals(sum, a + b);
	}

	@Test(groups = { "Subtraction" })
	public void testSubtractionOfNegativeAndPositiveNumbers() {
		long a = -10, b = 20;
		long diff = calculator.sub(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t diff:"+diff);
		
		Assert.assertEquals(diff, a - b);
	}

	@Test(groups = { "Subtraction" })
	public void testSubtractionOfPositiveAndNegativeNumbers() {
		long a = 10, b = -20;
		long diff = calculator.sub(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t diff:"+diff);
		
		Assert.assertEquals(diff, a - b);
	}

	@Test(expectedExceptions = { NumberFormatException.class }, groups = { "Negative" }, dependsOnGroups = { "Smoke" })
	public void testDivideByZero() {
		long a = 10, b = 0;
		long quotient = calculator.div(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t quotient:"+quotient);
		
		Assert.assertEquals(quotient, a / b);
	}

	@Test(groups = { "Negative" }, dependsOnGroups = { "Smoke" })
	public void testDivideZeroByANumber() {
		long a = 0, b = 1;
		long quotient = calculator.div(a, b);
		Reporter.log("a:"+a+"\t b:"+b+"\t quotient:"+quotient);
		
		Assert.assertEquals(quotient, a / b);
	}

	@Test(expectedExceptions = { NumberFormatException.class }, groups = { "Negative" }, dependsOnGroups = { "Smoke" })
	public void testSquareRootOfNegativeNumber() {
		long a = -25;
		double SquareRoot = calculator.sqrt(a);
		Reporter.log("a:"+a+"\t SquareRoot:"+SquareRoot);
		
		Assert.assertEquals(SquareRoot, Math.sqrt(SquareRoot));
	}

	@Test(groups = { "Negative" }, dependsOnGroups = { "Smoke" })
	public void testCosine() {
		long a = 0;
		double cos = calculator.cos(a);
		Reporter.log("a:" + a + "\t cos:" + cos);

		Assert.assertEquals(cos, Math.cos(a));

	}

	@Test(groups = { "Negative" }, dependsOnGroups = { "Smoke" })
	public void testIsPositive() {
		long a = -1;
		boolean isPositive = calculator.isPositive(a);
		Reporter.log("a:" + a + "\t IsPositive:" + isPositive);

		Assert.assertEquals(isPositive, a > 0);

	}

	@Test(groups = { "Negative" }, dependsOnGroups = { "Smoke" })
	public void testIsNegative() {
		long a = 1;
		boolean isNegative = calculator.isNegative(a);
		Reporter.log("a:" + a + "\t IsNegative:" + isNegative);

		Assert.assertEquals(isNegative, a < 0);

	}

	@Test(groups = { "Negative" }, dependsOnGroups = { "Smoke" }, dataProvider = "MultiplicationDataProvider")
	public void testMultiplyNumbers(long a, long b, long expectedProduct) {
		long product = calculator.mult(a, b);
		Reporter.log("a:" + a + "\t b:" + b + "\t product:" + product);

		Assert.assertEquals(product, expectedProduct);

	}

	@DataProvider(name = "MultiplicationDataProvider")
	public Object[][] dataProvider() {
		return new Object[][] { { 10, 20, 200 }, { 20, 10, 200 }, { 0, 5, 0 }, { -5, 0, 0 } };
	}

}
