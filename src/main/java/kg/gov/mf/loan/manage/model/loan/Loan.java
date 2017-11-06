package kg.gov.mf.loan.manage.model.loan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kg.gov.mf.loan.manage.model.debtor.Debtor;
import kg.gov.mf.loan.manage.model.orderterm.OrderTermCurrency;

@Entity
@Table(name="loan")
public class Loan {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="reg_number", nullable=false, length=50)
	private String regNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="reg_date", nullable=false)
	private Date regDate;
	
	@Column(name = "amount", precision = 12, scale = 5)
	private Double amount;
	
	@OneToOne
	@JoinColumn(name="currency_id")
	private OrderTermCurrency currency;
	
	@OneToOne
	@JoinColumn(name="loan_type_id")
	private LoanType loanType;
	
	@OneToOne
	@JoinColumn(name="loan_state_id")
	private LoanState loanState;
	
	@Column(name="supervisor_id", nullable=false)
	private long supervisorId;
	
	@Column(name="has_sub_loan")
	private boolean hasSubLoan;
	
	@OneToOne
	@JoinColumn(name="parent_loan_id", nullable=true)
	private Loan parentLoan;
	
	@Column(name="credit_order_id", nullable=false)
	private long creditOrderId;
	
	@ManyToOne
	private Debtor debtor;
	
	public Loan()
	{
		
	}

	public Loan(String regNumber, Date regDate, Double amount, OrderTermCurrency currency, LoanType loanType,
			LoanState loanState, long supervisorId, boolean hasSubLoan, long creditOrderId) {
		this.regNumber = regNumber;
		this.regDate = regDate;
		this.amount = amount;
		this.currency = currency;
		this.loanType = loanType;
		this.loanState = loanState;
		this.supervisorId = supervisorId;
		this.hasSubLoan = hasSubLoan;
		this.creditOrderId = creditOrderId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public OrderTermCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(OrderTermCurrency currency) {
		this.currency = currency;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public LoanState getLoanState() {
		return loanState;
	}

	public void setLoanState(LoanState loanState) {
		this.loanState = loanState;
	}

	public long getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(long supervisorId) {
		this.supervisorId = supervisorId;
	}

	public boolean isHasSubLoan() {
		return hasSubLoan;
	}

	public void setHasSubLoan(boolean hasSubLoan) {
		this.hasSubLoan = hasSubLoan;
	}

	public Loan getParentLoan() {
		return parentLoan;
	}

	public void setParentLoan(Loan parentLoan) {
		this.parentLoan = parentLoan;
	}

	public long getCreditOrderId() {
		return creditOrderId;
	}

	public void setCreditOrderId(long creditOrderId) {
		this.creditOrderId = creditOrderId;
	}

	public Debtor getDebtor() {
		return debtor;
	}

	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", regNumber=" + regNumber + ", regDate=" + regDate + ", amount=" + amount
				+ ", currency=" + currency + ", loanType=" + loanType + ", loanState=" + loanState + ", supervisorId="
				+ supervisorId + ", hasSubLoan=" + hasSubLoan + ", parentLoan=" + parentLoan + ", creditOrderId="
				+ creditOrderId + "]";
	}
}
