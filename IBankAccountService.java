package com.kata.bankaccount;

import com.kata.bankaccount.beans.History;

/**
 * Bank account service interface
 * 
 * @author khalid ALIANNE
 *
 */
public interface IBankAccountService {

	/**
	 * Add the <code>amount</code> to current account
	 * 
	 * @param amount
	 */
	void deposit(Integer amount);

	/**
	 * Retreive <code>amount</code> from current account
	 * 
	 * @param amount
	 */
	void withdrawal(int amount);

	/**
	 * Retreive balance
	 * 
	 * @return
	 */
	Integer getBalance();

	/**
	 * Retreive overdraft
	 * 
	 * @return
	 */
	Integer getOverdraft();

	/**
	 * Retreive all account operations history
	 * 
	 * @return
	 */
	History getHisto();

}