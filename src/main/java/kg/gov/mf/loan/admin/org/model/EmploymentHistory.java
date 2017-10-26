package kg.gov.mf.loan.admin.org.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employmentHistory")

public class EmploymentHistory {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="code", nullable=false)
    private String code;
    
    @OneToOne(targetEntity=Staff.class, fetch = FetchType.EAGER)
    @JoinColumn(name="staff_id")
    Staff staff;    
    
    @OneToMany(mappedBy = "employmentHistory", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    private Set<EmploymentHistoryEvent> employmentHistoryEvent = new HashSet<EmploymentHistoryEvent>();

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Set<EmploymentHistoryEvent> getEmploymentHistoryEvent() {
		return employmentHistoryEvent;
	}

	public void setEmploymentHistoryEvent(Set<EmploymentHistoryEvent> employmentHistoryEvent) {
		this.employmentHistoryEvent = employmentHistoryEvent;
	}




	
	
    
    
}
