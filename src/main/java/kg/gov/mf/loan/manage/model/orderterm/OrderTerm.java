package kg.gov.mf.loan.manage.model.orderterm;

import java.util.Date;

import kg.gov.mf.loan.manage.model.order.CreditOrder;

public class OrderTerm {
	
	private long id;
	
	private CreditOrder creditOrder;
	
	private String description;
	
	private OrderTermFund fund;
	
	private double amount;
	
	private OrderTermCurrency currency;
	
	private int frequencyQuantity;
	
	private OrderTermFrequencyType frequencyType;
	
	private int installmentQuantity;
	
	private int installmentFirstDay;
	
	private Date firstInstallmentDate;
	
	private Date lastInstallmentDate;
	
	private int minDaysDisbFirstInst;
	
	private int maxDaysDisbFirstInst;

	private int graceOnPrinciplePaymentInst;
	
	private int graceOnPrinciplePaymentDays;
	
	private int graceOnInterestPaymentInst;
	
	private int graceOnInterestPaymentDays;
	
	private int graceOnInterestAccrInst;
	
	private int graceOnInterestAccrDays;
	
	private double interestRateValue;
	
	
	
}
