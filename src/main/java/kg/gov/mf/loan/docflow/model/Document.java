package kg.gov.mf.loan.docflow.model;

import javax.persistence.*;

@Entity
@Table(name="df_document")
public class Document extends GenericModel {

    private String title;
    private String description;
    private Long generalStatus;

    @ManyToOne(targetEntity=DocumentType.class, fetch = FetchType.EAGER)
    @JoinColumn(name="documentType_id")
	private DocumentType documentType;

    @ManyToOne(targetEntity=DocumentSubType.class, fetch = FetchType.EAGER)
    @JoinColumn(name="documentSubType_id")
	private DocumentSubType documentSubType;

    @ManyToOne(targetEntity=DocumentTemplate.class, fetch = FetchType.EAGER)
    @JoinColumn(name="documentTemplate_id")
	private DocumentTemplate documentTemplate;

    @ManyToOne(targetEntity=SenderData.class, fetch = FetchType.EAGER)
    @JoinColumn(name="senderData_id")
    private SenderData senderData;

    @ManyToOne(targetEntity=ReceiverData.class, fetch = FetchType.EAGER)
    @JoinColumn(name="receiverData_id")
    private ReceiverData receiverData;

    @ManyToOne(targetEntity=ResultData.class, fetch = FetchType.EAGER)
    @JoinColumn(name="resultData_id")
    private ResultData resultData;

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
