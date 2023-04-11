package com.harsha.ordermanagement.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name="CUSTOMERDATA_TB")
public class CustomerData implements Serializable {

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

//	@GenericGenerator(name = "bussinessKey", strategy = "org.hibernate.id.UUIDGenerator")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BussinessKey")
	private UUID bussinessKey = UUID.randomUUID();
	@JsonProperty("customerName")
	@Column(name="CustomerName")
	private String customerName;
	@JsonProperty("typeOfCustomer")
	@Column(name="TypeOfCustomer")
	private String typeOfCustomer;
	@JsonProperty("contactNumber")
	@Column(name="ContactNumber")
	private String contactNumber;
	@JsonProperty("pincode")
	@Column(name="Pincode")
	private String pincode;
	@JsonProperty("city")
	@Column(name="City")
	private String city;
	@JsonProperty("doorNumber")
	@Column(name="DoorNumber")
	private String doorNumber;
	@JsonProperty("proOffer")
	@Column(name="ProOffer")
	private String proOffer;
	
	public CustomerData() {
		super();
	}
	
	public CustomerData(UUID bussinessKey, String customerName, String typeOfCustomer, String contactNumber,
			String pincode, String city, String doorNumber, String proOffer) {
		super();
		this.bussinessKey = bussinessKey;
		this.customerName = customerName;
		this.typeOfCustomer = typeOfCustomer;
		this.contactNumber = contactNumber;
		this.pincode = pincode;
		this.city = city;
		this.doorNumber = doorNumber;
		this.proOffer = proOffer;
	}

	public UUID getBussinessKey() {
		return bussinessKey;
	}

	public void setBussinessKey(UUID bussinessKey) {
		this.bussinessKey = bussinessKey;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public void setTypeOfCustomer(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProOffer() {
		return proOffer;
	}

	public void setProOffer(String proOffer) {
		this.proOffer = proOffer;
	}

	@Override
	public String toString() {
		return "CustomerData [bussinessKey=" + bussinessKey + ", customerName=" + customerName + ", typeOfCustomer="
				+ typeOfCustomer + ", contactNumber=" + contactNumber + ", pincode=" + pincode + ", city=" + city
				+ ", doorNumber=" + doorNumber + ", proOffer=" + proOffer + "]";
	}	

}
