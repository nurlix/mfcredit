package kg.gov.mf.loan.docflow.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Catalog extends GenericModel {

	private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
