package kg.gov.mf.loan.manage.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kg.gov.mf.loan.manage.model.entitylist.AppliedEntityList;

@Entity
@Table(name="applied_entity")
public class AppliedEntity {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="name", nullable=false, length=40)
	private String name;
	
	@OneToOne
	@JoinColumn(name="applied_entity_state_id")
	private AppliedEntityState appliedEntityState;
	
	@ManyToOne
	private AppliedEntityList appliedEntityList;
	
	public AppliedEntity()
	{
		
	}

	public AppliedEntity(String name, AppliedEntityState appliedEntityState) {
		this.name = name;
		this.appliedEntityState = appliedEntityState;
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

	public AppliedEntityState getAppliedEntityState() {
		return appliedEntityState;
	}

	public void setAppliedEntityState(AppliedEntityState appliedEntityState) {
		this.appliedEntityState = appliedEntityState;
	}

	public AppliedEntityList getAppliedEntityList() {
		return appliedEntityList;
	}

	public void setAppliedEntityList(AppliedEntityList appliedEntityList) {
		this.appliedEntityList = appliedEntityList;
	}
}
