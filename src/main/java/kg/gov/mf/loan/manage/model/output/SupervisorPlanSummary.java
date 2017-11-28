package kg.gov.mf.loan.manage.model.output;

import java.util.Date;

import kg.gov.mf.loan.manage.model.loan.Loan;

public class SupervisorPlanSummary {

	private long id;
	
	private Date onDate;
	
	private Double totalPlan;
	
	private Double totalPaid;
	
	private Double totalBalance;
	
	private Double principalPlan;
	
	private Double principalPaid;
	
	private Double principalBalance;
	
	private Double interestPlan;
	
	private Double interestPaid;
	
	private Double interestBalance;
	
	private Double penaltyPlan;
	
	private Double penaltyPaid;
	
	private Double penaltyBalance;
	
	private Double feePlan;
	
	private Double feePaid;
	
	private Double feeBalance;
	
	private Loan loan;
	
}
