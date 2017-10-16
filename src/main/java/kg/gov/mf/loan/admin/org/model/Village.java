package kg.gov.mf.loan.admin.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="village")

public class Village {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="code", nullable=false)
    private String code;
    
    @ManyToOne(targetEntity=Aokmotu.class, fetch = FetchType.EAGER)
    @JoinColumn(name="aokmotu_id")
    Aokmotu aokmotu; 
    

    
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

	public Aokmotu getAokmotu() {
		return aokmotu;
	}

	public void setAokmotu(Aokmotu aokmotu) {
		this.aokmotu = aokmotu;
	}

	

    
    
}
