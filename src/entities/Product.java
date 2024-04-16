package entities;

import java.util.Objects;

public class Product {

	private Integer id;
	private String description;
	private Double costValue;
	private Double saleValue;
	private String category;
	
	public Product() {
	}

	public Product(Integer id, String description, Double costValue, Double saleValue, String category) {
		super();
		this.id = id;
		this.description = description;
		this.costValue = costValue;
		this.saleValue = saleValue;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCostValue() {
		return costValue;
	}

	public void setCostValue(Double costValue) {
		this.costValue = costValue;
	}

	public Double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(Double saleValue) {
		this.saleValue = saleValue;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return id + " - " + description;
	}
	
	
}
