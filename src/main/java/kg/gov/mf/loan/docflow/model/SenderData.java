package kg.gov.mf.loan.docflow.model;

import kg.gov.mf.loan.docflow.model.catalogs.DispatchData;
import kg.gov.mf.loan.docflow.model.catalogs.Executor;
import kg.gov.mf.loan.docflow.model.catalogs.Information;
import kg.gov.mf.loan.docflow.model.catalogs.Responsible;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="df_sender_data")
public class SenderData extends GenericModel {

    private Date registeredDate;
    private String registeredNumber;
    private Date dueDate;
    private Responsible responsibleId;
    private Executor executerId;
    private Long senderStatus;
    private Information informationId;
    private DispatchData dispatchData;
}
