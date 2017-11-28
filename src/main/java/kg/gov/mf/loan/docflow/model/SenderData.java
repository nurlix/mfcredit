package kg.gov.mf.loan.docflow.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="df_sender_data")
public class SenderData extends GenericModel {

    private String registeredNumber;
    private Long senderStatus;

    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date registeredDate = new Date();

    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dueDate = new Date();

    @ManyToOne(targetEntity=Responsible.class, fetch = FetchType.EAGER)
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    @ManyToOne(targetEntity=Executor.class, fetch = FetchType.EAGER)
    @JoinColumn(name="executor_id")
    private Executor executor;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name="information_id")
    private Information information;

    @ManyToOne(targetEntity=DispatchData.class, fetch = FetchType.EAGER)
    @JoinColumn(name="dispatchData_id")
    private DispatchData dispatchData;

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(Long senderStatus) {
        this.senderStatus = senderStatus;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public DispatchData getDispatchData() {
        return dispatchData;
    }

    public void setDispatchData(DispatchData dispatchData) {
        this.dispatchData = dispatchData;
    }
}
