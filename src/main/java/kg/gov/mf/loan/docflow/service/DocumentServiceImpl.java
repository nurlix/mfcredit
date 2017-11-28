package kg.gov.mf.loan.docflow.service;

import kg.gov.mf.loan.docflow.dao.DocumentDao;
import kg.gov.mf.loan.docflow.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentServiceImpl extends GenericServiceImpl<Document> implements DocumentService
{
    @Autowired
    private DocumentDao dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Document> incomingDocuments() {
        return dao.incomingDocuments();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Document> outgoingDocuments() {
        return dao.outgoingDocuments();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Document> internalDocuments() {
        return dao.internalDocuments();
    }
}
