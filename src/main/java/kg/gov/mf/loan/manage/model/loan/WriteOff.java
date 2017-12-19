package kg.gov.mf.loan.manage.model.loan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="write_off")
public class WriteOff {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date", nullable=false)
	private Date date;
	
	@Column(name = "total_amount", precision = 12, scale = 5)
	private Double totalAmount;
	
	@Column(name = "principal", precision = 12, scale = 5)
	private Double principal;
	
	@Column(name = "interest", precision = 12, scale = 5)
	private Double interest;
	
	@Column(name = "penalty", precision = 12, scale = 5)
	private Double penalty;
	
	@Column(name = "fee", precision = 12, scale = 5)
	private Double fee;
	
	@Column(name="description", nullable=true, length=50)
	private String description;
	
	@ManyToOne
	private Loan loan;
	
	public WriteOff()
	{
		
	}
	
	public WriteOff(Date date, Double totalAmount, Double principal, Double interest, Double penalty, Double fee,
			String description) {
		this.date = date;
		this.totalAmount = totalAmount;
		this.principal = principal;
		this.interest = interest;
		this.penalty = penalty;
		this.fee = fee;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getPenalty() {
		return penalty;
	}

	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
}