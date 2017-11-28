package kg.gov.mf.loan.docflow.model;

import javax.persistence.*;

@Entity
@Table(name="cat_document_template")
public class DocumentTemplate extends Catalog {

    @ManyToOne(targetEntity=Task.class, fetch = FetchType.EAGER)
    @JoinColumn(name="task_id")
    private Task task;

    @ManyToOne(targetEntity=Information.class, fetch = FetchType.EAGER)
    @JoinColumn(name="information_id")
    private Information information;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}
