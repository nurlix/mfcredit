package kg.gov.mf.loan.docflow.model.catalogs;

import kg.gov.mf.loan.docflow.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_document_template")
public class DocumentTemplate extends Catalog {

    private Information informationId;
    private Task taskId;
}
