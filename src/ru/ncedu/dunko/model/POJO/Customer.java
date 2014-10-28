package ru.ncedu.dunko.model.POJO;

public class Customer {
	int customer_id;
	String name;
	String address;
	int phone_number;
	
	public Customer() {}
	
	public Customer(int customer_id, String name, String address, int phone_number) {
		this.customer_id = customer_id;
		this.name = name;
		this.address = address;
		this. phone_number = phone_number;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
}
