package kg.gov.mf.loan.docflow.model.catalogs;

import kg.gov.mf.loan.docflow.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="cat_dispatch_data")
public class DispatchData extends Catalog {

    private DispatchType dispatchTypeId;
    private Date dispatchInitTime;
    private Long dispatchBy;
    private Long dispatchTo;
    private Date dispatchResponseTime;
    private DispatchResult dispatchResultId;
    private String description;
    private DispatchTemplate dispatchTemplateId;
    private DispatchData dispatchDataId;
    private boolean isParent;
}
