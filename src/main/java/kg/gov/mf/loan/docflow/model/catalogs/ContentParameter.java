package kg.gov.mf.loan.docflow.model.catalogs;

import kg.gov.mf.loan.docflow.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_content_parameter")
public class ContentParameter extends Catalog {

    private int position;
    private String format;
    private Long systemObjectTypeId;
    private String fieldName;
    private int fieldPosition;
    private Long fieldTypeId;
    private Long classificatorId;
    private double constantValue;
    private String constantText;
}
