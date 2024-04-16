package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
	
	private Integer id;
	private Date issueDate;
	private Date deliveryDate;
	private Double totalValue;
	private String observation;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Integer id, Date issueDate, Date deliveryDate, Double totalValue, String observation) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.deliveryDate = deliveryDate;
		this.totalValue = totalValue;
		this.observation = observation;
	}
	
	public Order(Integer id, Date issueDate, Date deliveryDate, Double totalValue, String observation, Client client) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.deliveryDate = deliveryDate;
		this.totalValue = totalValue;
		this.observation = observation;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "# Código: "
				+ id
				+ " | Data do pedido: "
				+ issueDate
				+ " | Data de entrega: "
				+ deliveryDate
				+ " | Valor total: "
				+ totalValue
				+ " | Observação: "
				+ observation
				+ "\nCliente: "
				+ client.getId()
				+ " - "
				+ client.getName();
	}
}
