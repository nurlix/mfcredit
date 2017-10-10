package kg.gov.mf.loan.manage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="credit_order_state")
public class CreditOrderState {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@NotEmpty
	@Column(name="name", unique=true, nullable=false, length=20)
	private String name;
	
	public CreditOrderState()
	{
		
	}
	
	public CreditOrderState(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CreditOrderState(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}