/**
 * 
 */
package com.kata.bankaccount;

import com.kata.bankaccount.beans.AccountOperation;
import com.kata.bankaccount.beans.History;
import com.kata.bankaccount.beans.OperationTypeEnum;

/**
 * Bank account service implementation
 * 
 * @author khalid ALIANNE
 *
 */
public class BankAccountServiceImpl implements IBankAccountService {

	public static final Integer DEFAULT_OVERDRAFT = 200;

	private Integer balance;
	private Integer overdraft;
	private History histo;

	/**
	 * Default constructor
	 */
	public BankAccountServiceImpl() {
		this.balance = 0;
		this.overdraft = DEFAULT_OVERDRAFT;
		this.histo = new History();
	}

	/**
	 * @param balance
	 */
	public BankAccountServiceImpl(Integer balance) {
		this();
		this.balance = balance;
	}

	/**
	 * Constructor to initialize balance
	 */
	public BankAccountServiceImpl(Integer initialBalance, Integer overdraft) {
		this.balance = initialBalance;
		this.overdraft = overdraft;
		this.histo = new History();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrainement.TestsTechnique.IBankAccount#deposit(java.lang.Integer)
	 */
	public void deposit(Integer amount) {

		if (amount <= 0) {
			throw new IllegalArgumentException("Amount canot be equal to zero or negative !");
		}
		this.balance += amount;
		histo.add(new AccountOperation(OperationTypeEnum.DEPOSIT, amount, balance));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrainement.TestsTechnique.IBankAccount#withdrawal(int)
	 */
	public void withdrawal(int amount) {

		if (amount <= 0) {
			throw new IllegalArgumentException("Amount canot be equal to zero or negative !");
		}

		if (amount > (this.balance + this.overdraft)) {
			throw new IllegalArgumentException("Amount canot be greater than balance and overdraft !");
		}

		this.balance -= amount;
		histo.add(new AccountOperation(OperationTypeEnum.WITHDRAWAL, amount, balance));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrainement.TestsTechnique.IBankAccount#getBalance()
	 */
	public Integer getBalance() {
		return this.balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrainement.TestsTechnique.IBankAccount#getOverdraft()
	 */
	public Integer getOverdraft() {
		return this.overdraft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entrainement.TestsTechnique.IBankAccount#getHisto()
	 */
	public History getHisto() {
		return histo;
	}
}
