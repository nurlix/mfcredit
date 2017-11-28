package kg.gov.mf.loan.docflow.service;

import kg.gov.mf.loan.docflow.model.Document;
import java.util.List;

public interface DocumentService extends GenericService<Document>
{
    public List<Document> incomingDocuments();
    public List<Document> outgoingDocuments();
    public List<Document> internalDocuments();
}
