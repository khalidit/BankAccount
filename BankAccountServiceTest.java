/**
 * 
 */
package com.kata.bankaccount;

import com.kata.bankaccount.beans.History;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * TDD use cases for Bank account
 * 
 * @author khalid ALIANNE
 *
 */
public class BankAccountServiceTest extends TestCase {

	/**
	 * @param name
	 */
	public BankAccountServiceTest(String name) {
		super(name);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(BankAccountServiceTest.class);
	}

	/**
	 * Testing deposit use case (amount greater than 0)
	 */
	public void testDepositAmoutThatGreaterThanZeroShouldBeAccepted() {
		final IBankAccountService account = new BankAccountServiceImpl();
		final int toAdd = 50;
		account.deposit(toAdd);
		assertEquals(toAdd, account.getBalance().intValue());
	}

	/**
	 * Testing deposit use case (amount lower than or equal to 0)
	 */
	public void testDepositAmoutThatLowerThanOrEqualToZeroShouledBeThrowException() {
		final IBankAccountService account = new BankAccountServiceImpl();
		try {
			account.deposit(-20);
			fail("Should throw exception when adding a negative amount");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Amount canot be equal to zero or negative !");
		}
	}

	/**
	 * Retreiving amount that lower than balance is possible
	 */
	public void testWithdrawalAmountThatLowerThanBalanceShouldBeAccepted() {
		final IBankAccountService account = new BankAccountServiceImpl(500);
		account.withdrawal(150);
		assertEquals(350, account.getBalance().intValue());
	}

	/**
	 * Retreiving amount that equal to zero or negative is not permitted
	 */
	public void testWithdrawalAmountThatEqualToZeroOrNegativeShouldThrowException() {
		final IBankAccountService account = new BankAccountServiceImpl(500);
		try {
			account.withdrawal(-60);
			fail("Should throw exception when retrieving an amount equal to zeo or negative !");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Amount canot be equal to zero or negative !");
		}
	}

	/**
	 * Retreiving amount that greater than balance and lower than overdraft is permitted
	 */
	public void testWithdrawalAmountThatGreaterThanBalanceAndLowerThanOverDraftShouldBeAccepted() {
		final IBankAccountService account = new BankAccountServiceImpl(500);
		account.withdrawal(650);
		assertEquals(-150, account.getBalance().intValue());
	}

	/**
	 * Retreiving amount that greater than balance and overdraft is not permitted
	 */
	public void testWithdrawalAmountThatGreaterThanBalanceAndGreaterThanOverDraftShouldThrowException() {
		final IBankAccountService account = new BankAccountServiceImpl(300);
		try {
			account.withdrawal(800); // Balance + overdraft = 500
			fail("Should throw exception when retrieving an amount greater than balance and overdraft !");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Amount canot be greater than balance and overdraft !");
		}
	}

	/**
	 * The history should contains 5 operations
	 */
	public void testPrintHistory() {
		final IBankAccountService account = new BankAccountServiceImpl(1000);
		account.deposit(100);
		account.deposit(10);
		account.withdrawal(320);
		account.deposit(120);
		account.withdrawal(200);

		History histo = account.getHisto();
		assertEquals(5, histo.getOperations().size());
		histo.printOperations();
	}

}
