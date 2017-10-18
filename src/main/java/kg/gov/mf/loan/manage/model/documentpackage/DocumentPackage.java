package kg.gov.mf.loan.manage.model.documentpackage;

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

import kg.gov.mf.loan.manage.model.entity.AppliedEntity;

@Entity
@Table(name="document_package")
public class DocumentPackage {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="completed_date", nullable=false)
	private Date completedDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="approved_date", nullable=false)
	private Date approvedDate;
	
	@Column(name = "completed_ratio", precision = 12, scale = 5)
	private Double completedRatio;
	
	@Column(name = "approved_ratio", precision = 12, scale = 5)
	private Double approvedRatio;
	
	@Column(name = "registered_ratio", precision = 12, scale = 5)
	private Double registeredRatio;
	
	@OneToOne
	@JoinColumn(name="document_package_state_id")
	private DocumentPackageState documentPackageState;
	
	@OneToOne
	@JoinColumn(name="document_package_type_id")
	private DocumentPackageType documentPackageType;
	
	@ManyToOne
	private AppliedEntity appliedEntity;
	
	public DocumentPackage()
	{
		
	}

	public DocumentPackage(Date completedDate, Date approvedDate, Double completedRatio, Double approvedRatio,
			Double registeredRatio, DocumentPackageState documentPackageState,
			DocumentPackageType documentPackageType) {
		this.completedDate = completedDate;
		this.approvedDate = approvedDate;
		this.completedRatio = completedRatio;
		this.approvedRatio = approvedRatio;
		this.registeredRatio = registeredRatio;
		this.documentPackageState = documentPackageState;
		this.documentPackageType = documentPackageType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date appovedDate) {
		this.approvedDate = appovedDate;
	}

	public Double getCompletedRatio() {
		return completedRatio;
	}

	public void setCompletedRatio(Double completedRatio) {
		this.completedRatio = completedRatio;
	}

	public Double getApprovedRatio() {
		return approvedRatio;
	}

	public void setApprovedRatio(Double approvedRatio) {
		this.approvedRatio = approvedRatio;
	}

	public Double getRegisteredRatio() {
		return registeredRatio;
	}

	public void setRegisteredRatio(Double registeredRatio) {
		this.registeredRatio = registeredRatio;
	}

	public DocumentPackageState getDocumentPackageState() {
		return documentPackageState;
	}

	public void setDocumentPackageState(DocumentPackageState documentPackageState) {
		this.documentPackageState = documentPackageState;
	}

	public DocumentPackageType getDocumentPackageType() {
		return documentPackageType;
	}

	public void setDocumentPackageType(DocumentPackageType documentPackageType) {
		this.documentPackageType = documentPackageType;
	}

	public AppliedEntity getAppliedEntity() {
		return appliedEntity;
	}

	public void setAppliedEntity(AppliedEntity appliedEntity) {
		this.appliedEntity = appliedEntity;
	}

}
