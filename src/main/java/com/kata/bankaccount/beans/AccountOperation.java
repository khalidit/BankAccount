/**
 * 
 */
package com.kata.bankaccount.beans;

import java.util.Date;

/**
 * @author khalid ALIANNE
 *
 */
public class AccountOperation {

	private OperationTypeEnum type;
	private Integer amount;
	private Integer balance;
	private Date date;

	/**
	 * @param operation
	 * @param amount
	 * @param balance
	 */
	public AccountOperation(OperationTypeEnum type, Integer amount, Integer balance) {
		super();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.date = new Date();
	}

	/**
	 * @return the type
	 */
	public OperationTypeEnum getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(OperationTypeEnum type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the balance
	 */
	public Integer getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operation [type=" + type + ", date=" + date + ", amount=" + amount + ", balance=" + balance + "]";
	}

}
