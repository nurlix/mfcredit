package kg.gov.mf.loan.docflow.model;

import kg.gov.mf.loan.docflow.model.catalogs.DocumentSubType;
import kg.gov.mf.loan.docflow.model.catalogs.DocumentTemplate;
import kg.gov.mf.loan.docflow.model.catalogs.DocumentType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="df_document")
public class Document extends GenericModel {

    private String title;
    private String description;
	private DocumentType documentType;
	private DocumentSubType documentSubType;
	private DocumentTemplate documentTemplate;
    private SenderData senderData;
    private ReceiverData receiverData;
    private ResultData resultData;
	private Long generalStatus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentSubType getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(DocumentSubType documentSubType) {
        this.documentSubType = documentSubType;
    }

    public DocumentTemplate getDocumentTemplate() {
        return documentTemplate;
    }

    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }

    public SenderData getSenderData() {
        return senderData;
    }

    public void setSenderData(SenderData senderData) {
        this.senderData = senderData;
    }

    public ReceiverData getReceiverData() {
        return receiverData;
    }

    public void setReceiverData(ReceiverData receiverData) {
        this.receiverData = receiverData;
    }

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    public Long getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(Long generalStatus) {
        this.generalStatus = generalStatus;
    }
}
