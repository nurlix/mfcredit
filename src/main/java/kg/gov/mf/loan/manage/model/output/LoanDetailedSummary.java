package kg.gov.mf.loan.manage.model.output;

import java.util.Date;

import kg.gov.mf.loan.manage.model.loan.Loan;

public class LoanDetailedSummary {
	
	private long id;
	
	private Date onDate;
	
	private Double disbursement;
	
	private Double totalDisbursement;
	
	private Double principalPayment;
	
	private Double totalPrincipalPayment;
	
	private Double principalPaid;
	
	private Double totalPrincipalPaid;
	
	private Double principalWriteOff;
	
	private Double totalPrincipalWriteOff;
	
	private Double principalOutstanding;
	
	private Double principalOverdue;
	
	private int daysInPeriod;
	
	private Double interestAccrued;
	
	private Double totalInterestAccrued;
	
	private Double interestPayment;
	
	private Double totalInterestPayment;
	
	private Double collectedInterestPayment;
	
	private Double totalCollectedInterestPayment;
	
	private Double collectedInterestDisbursed;
	
	private Double interestPaid;
	
	private Double totalInterestPaid;
	
	private Double interestOutstanding;
	
	private Double interestOverdue;
	
	private Double penaltyAccrued;
	
	private Double totalPenaltyAccrued;
	
	private Double collectedPenaltyPayment;
	
	private Double totalCollectedPenaltyPayment;
	
	private Double collectedPenaltyDisbursed;
	
	private Double penaltyPaid;
	
	private Double totalPenaltyPaid;
	
	private Double penaltyOutstanding;
	
	private Double penaltyOverdue;
	
	private Loan loan;
	
}
