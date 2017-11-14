package kg.gov.mf.loan.docflow.model;

import kg.gov.mf.loan.docflow.model.catalogs.Information;
import kg.gov.mf.loan.docflow.model.catalogs.Responsible;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="df_result_data")
public class ResultData extends GenericModel {

    private Date close_date = new Date();
    private Long resultStatus;
    private Information information;
    private Responsible responsible;
    private String description;
}
