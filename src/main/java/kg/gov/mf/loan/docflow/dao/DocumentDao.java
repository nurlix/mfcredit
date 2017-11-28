package kg.gov.mf.loan.docflow.dao;

import kg.gov.mf.loan.docflow.model.Document;
import java.util.List;

public interface DocumentDao extends GenericDao<Document>
{
    List<Document> incomingDocuments();
    List<Document> outgoingDocuments();
    List<Document> internalDocuments();
}
