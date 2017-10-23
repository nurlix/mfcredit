package kg.gov.mf.loan.manage.model.orderterm;

public class OrderTermTransactionOrder {

	private long id;
	
	private String name;
	
	public OrderTermTransactionOrder() {
	}

	public OrderTermTransactionOrder(String name) {
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
