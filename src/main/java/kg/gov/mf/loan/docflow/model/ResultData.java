package kg.gov.mf.loan.docflow.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="df_result_data")
public class ResultData extends GenericModel {

    private Long resultStatus;
    private String description;

    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date close_date = new Date();

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name="information_id")
    private Information information;

    @ManyToOne(targetEntity=Responsible.class, fetch = FetchType.EAGER)
    @JoinColumn(name="responsible_id")
    private Responsible responsible;

    public Date getClose_date() {
        return close_date;
    }

    public void setClose_date(Date close_date) {
        this.close_date = close_date;
    }

    public Long getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Long resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
}
