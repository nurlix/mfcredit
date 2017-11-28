package kg.gov.mf.loan.docflow.controller;

import kg.gov.mf.loan.docflow.model.Document;
import kg.gov.mf.loan.docflow.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class DocumentFlowController {

    @Autowired
    DocumentService documentService;

    @Autowired
    DocumentTypeService documentTypeService;

    @Autowired
    DocumentSubTypeService documentSubTypeService;

    @Autowired
    SenderDataService senderDataService;

    @Autowired
    ReceiverDataService receiverDataService;

    @Autowired
    ResultDataService resultDataService;

    @RequestMapping(value = "/docflow")
    public String listDocuments(Model model)
    {
        model.addAttribute("documentType", documentTypeService.list());
        model.addAttribute("documentSubType", documentSubTypeService.list());
        model.addAttribute("senderData", senderDataService.list());
        model.addAttribute("receiverData", receiverDataService.list());
        model.addAttribute("resultData", resultDataService.list());
        return "/docflow/document/index";
    }

    @RequestMapping("/docflow/all")
    @ResponseBody
    public List<Document> allDocuments()
    {
        return documentService.list();
    }

    @RequestMapping("/docflow/internal")
    @ResponseBody
    public List<Document> internalDocuments()
    {
        return documentService.internalDocuments();
    }

    @RequestMapping("/docflow/incoming")
    @ResponseBody
    public List<Document> incomingDocuments()
    {
        return documentService.incomingDocuments();
    }

    @RequestMapping("/docflow/outgoing")
    @ResponseBody
    public List<Document> outgoingDocuments()
    {
        return documentService.outgoingDocuments();
    }

    @RequestMapping("/docflow/{id}")
    @ResponseBody
    public Document getDocumentString(@PathVariable("id") Long id)
    {
        return documentService.getById(id);
    }

    @RequestMapping(value= "/docflow/add")
    @ResponseBody
    public String SaveOrUpdateDocument(@ModelAttribute("document") Document document)
    {
        if((document.getId() == null) || (document.getId() == 0))
        {
            document.setSenderData(null);
            document.setReceiverData(null);
            document.setResultData(null);
            this.documentService.add(document);
        }
        else
        {
            this.documentService.update(document);
        }
        return "OK";
    }

    @RequestMapping("/docflow/remove/{id}")
    @ResponseBody
    public String removeDocument(@ModelAttribute("document") Document document)
    {
        this.documentService.remove(document);
        return "OK";
    }

    private String getPrincipal(){

        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
