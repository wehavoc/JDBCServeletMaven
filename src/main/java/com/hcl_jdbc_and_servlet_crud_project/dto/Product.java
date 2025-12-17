package com.hcl_jdbc_and_servlet_crud_project.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Product implements Serializable {
	private int id;
	private String name;
	private String color;
	private double price;
	private LocalDate mfd;
	private LocalDate expd;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", mfd=" + mfd
				+ ", expd=" + expd + ", getId()=" + getId() + ", hashCode()=" + hashCode() + ", getName()=" + getName()
				+ ", getColor()=" + getColor() + ", getPrice()=" + getPrice() + ", getMfd()=" + getMfd()
				+ ", getExpd()=" + getExpd() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String color, double price, LocalDate mfd, LocalDate expd) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.mfd = mfd;
		this.expd = expd;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, expd, id, mfd, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(color, other.color) && Objects.equals(expd, other.expd) && id == other.id
				&& Objects.equals(mfd, other.mfd) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public LocalDate getExpd() {
		return expd;
	}

	public void setExpd(LocalDate expd) {
		this.expd = expd;
	}

}
