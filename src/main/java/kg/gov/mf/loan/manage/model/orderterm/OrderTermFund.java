package kg.gov.mf.loan.manage.model.orderterm;

public class OrderTermFund {
	
	private long id;
	private String name;
	
	public OrderTermFund() {
	}

	
	public OrderTermFund(String name) {
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
