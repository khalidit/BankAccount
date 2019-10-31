/**
 * 
 */
package com.kata.bankaccount.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * History of bank account operations
 * 
 * @author khalid ALIANNE
 *
 */
public class History {

	private List<AccountOperation> operations = new ArrayList<AccountOperation>();

	/**
	 * Add an operation to history
	 * 
	 * @param operation
	 */
	public void add(AccountOperation operation) {
		this.operations.add(operation);
	}

	/**
	 * Get all operations
	 * 
	 * @return
	 */
	public List<AccountOperation> getOperations() {
		return this.operations;
	}

	/**
	 * Print all account operations
	 */
	public void printOperations() {
		System.out.println("Operation \t | \t\t Date \t\t\t | \t Amount  | \t Balance\n");
		for (AccountOperation operation : operations) {
			System.out.print(operation.getType() + " \t | \t ");
			System.out.print(operation.getDate() + " \t | \t ");
			System.out.print(operation.getAmount() + " \t | \t ");
			System.out.print(operation.getBalance() + "\n");
		}
	}
}
