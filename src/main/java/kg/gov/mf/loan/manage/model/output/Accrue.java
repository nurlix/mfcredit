package kg.gov.mf.loan.manage.model.output;

import java.util.Date;

import kg.gov.mf.loan.manage.model.loan.Loan;

public class Accrue {

	private long id;
	
	private Date fromDate;
	
	private Date toDate;
	
	private int daysInPeriod;
	
	private Double interestAccrued;
	
	private Double penaltyAccrued;
	
	private Double penaltyOnPrincipalOverdue;
	
	private Double penaltyOnInterestOverdue;
	
	private boolean lastInstPassed;
	
	private Loan loan;
	
}
