package kg.gov.mf.loan.docflow.model.catalogs;

import kg.gov.mf.loan.docflow.model.Catalog;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cat_responsible")
public class Responsible extends Catalog {

    private Organization organizationId;
    private Person personId;
}
