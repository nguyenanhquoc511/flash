package Deals;

import java.util.*;

public class Deal {


	protected long idDeal, idCustomer, idReceive;
	protected String date, time, note;
	protected double money;
	protected int kind;

	public Deal() {
		this.date = null;
		this.idCustomer = 0;
		this.idDeal = 0;
		this.idReceive = 0;
		this.kind = 0;
		this.money = 0;
		this.note = null;
		this.time = null;
	}

	public Deal(long idDeal, int kind, String date, String time, long idCustomer, double money, long idReceive,
			String note) {
		this.date = date;
		this.idCustomer = idCustomer;
		this.idDeal = idDeal;
		this.idReceive = idReceive;
		this.kind = kind;
		this.money = money;
		this.note = note;
		this.time = time;
	}

	public long getIdDeal() {
		return idDeal;
	}

	public void setIdDeal(long idDeal) {
		this.idDeal = idDeal;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public long getIdReceive() {
		return idReceive;
	}

	public void setIdReceive(long idReceive) {
		this.idReceive = idReceive;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public String toString() {
		return "\nID of Deal: " + String.valueOf(idDeal) + "\nKind of Deal: " + kindToString(kind) + "\nDate of Deal: "
				+ date + "\nTime of Deal: " + time + "\nID of Customer: " + String.valueOf(idCustomer)
				+ "\nMoney of Deal: " + String.valueOf(money) + "\nID of Receive: " + String.valueOf(idReceive)
				+ "\nNote: " + note;
	}

	

	public String kindToString(int kind) {
		if (kind == 1)
			return "Put On Money";
		else
			return (kind == 2 ? "Get Out Money" : "Transfer Money");
	}

}
