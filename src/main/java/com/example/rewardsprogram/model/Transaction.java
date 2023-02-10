package com.example.rewardsprogram.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction extends Reward {
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private Double total;
	private String description;
	// @Temporal(TemporalType.DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date saveDate;

	public Transaction() {
		super();
	}

	public Transaction(Long id, Customer customer, Double total, String description, Date date) {
		super();
		this.id = id;
		this.customer = customer;
		this.total = total;
		this.description = description;
		this.saveDate = date;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Long getPoints() {
		this.points = 0l;

		if (this.total > 50 && this.total <= 100) {
			this.points += (this.total.intValue() - 50) * 1;

		}

		if (this.total > 100) {
			this.points += 50; // 1 point for every dollar spent over $50
			this.points += (this.total.intValue() - 100) * 2; // 2 points for every dollar spent over $100
		}

		return this.points;
	}

	@Override
	public String toString() {
		return String.format("MyTransaction [id=%s, customer=%s, total=%s, description=%s, saveDate=%s]", id, customer,
				total, description, saveDate);
	}

	public static Builder getBuilder(Long id, Customer customer, Double total, String description, Date date) {
		return new Builder(id, customer, total, description, date);
	}

	public static class Builder {
		Transaction built;

		/**
		 * Creates a new Builder instance.
		 * 
		 * @param firstName The first name of the created Person object.
		 * @param lastName  The last name of the created Person object.
		 */
		Builder(Long id, Customer customer, Double total, String description, Date date) {
			built = new Transaction();
			built.id = id;
			built.customer = customer;
			built.total = total;
			built.description = description;
			built.saveDate = date;
		}

		/**
		 * Builds the new Person object.
		 * 
		 * @return The created Person object.
		 */
		public Transaction build() {
			return built;
		}
	}

}
