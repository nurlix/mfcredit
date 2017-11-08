package kg.gov.mf.loan.manage.model.output;

import java.util.Date;

import kg.gov.mf.loan.manage.model.loan.Loan;

public class LoanSummary {
	
	private long id;
	
	private Date onDate;
	
	private Double loanAmount;
	
	private Double totalDisbursed;
	
	private Double totalPaid;
	
	private Double paidPrincipal;
	
	private Double paidInterest;
	
	private Double paidPenalty;
	
	private Double paidFee;
	
	private Double totalOutstanding;
	
	private Double outstandingPrincipal;
	
	private Double outstandingInterest;
	
	private Double outstandingPenalty;
	
	private Double outstandingFee;
	
	private Double totalOverdue;
	
	private Double overduePrincipal;
	
	private Double overdueInterest;
	
	private Double overduePenalty;
	
	private Double overdueFee;
	
	private Loan loan;

}
