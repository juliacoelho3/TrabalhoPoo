package entities;

import java.util.Date;
import java.util.Objects;

public class Client extends Person {

	private Integer id;
	private String cpf;
	private Date birthDate;

	

	public Client(String name, String address, String phoneNumber, Integer id, String cpf, Date birthDate) {
		super(name, address, phoneNumber);
		this.id = id;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(cpf, other.cpf) && id == other.id;
	}
	
	}
