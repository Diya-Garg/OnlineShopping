package com.niit.backend.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity(name="category")
@Table(name="ProductTable")
public class Product {
	
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private String description;
	private float price;
	private int quantity;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoryId")
	private Category category;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="supplierId")
	private Supplier supplier;
	
	@Transient
	MultipartFile pimage;
	
	private String imgname;

	
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + ", category=" + category
				+ ", supplier=" + supplier + ", pimage=" + pimage
				+ ", imgname=" + imgname + "]";
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
	
}
