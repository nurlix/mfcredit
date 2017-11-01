package kg.gov.mf.loan.docflow.controller;

import kg.gov.mf.loan.docflow.model.Document;
import kg.gov.mf.loan.docflow.model.catalogs.DocumentSubType;
import kg.gov.mf.loan.docflow.model.catalogs.DocumentType;
import kg.gov.mf.loan.docflow.service.GenericService;
import kg.gov.mf.loan.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DocumentFlowController {

    @Autowired
    GenericService<Document> documentService;

    @Autowired
    GenericService<DocumentType> documentTypeService;

    @Autowired
    GenericService<DocumentSubType> documentSubTypeService;

    @RequestMapping(value = "/docflow", method = RequestMethod.GET)
    public String listDocuments(Model model)
    {
        model.addAttribute("documents", documentService.list());
        model.addAttribute("document", new Document());

        model.addAttribute("documentTypes", documentTypeService.list());
        model.addAttribute("documentType", new DocumentType());

        model.addAttribute("documentSubTypes", documentSubTypeService.list());
        model.addAttribute("documentSubType", new DocumentSubType());

        model.addAttribute("loggedinuser", Utils.getPrincipal());

        return "/docflow/index";
    }

    @RequestMapping(value= "/docflow/add", method = RequestMethod.POST)
    public String addDocument(@ModelAttribute("document") Document document)
    {
        if(document.getId() == null){
            this.documentService.add(document);
        }else{
            this.documentService.update(document);
        }
        return "redirect:/docflow";
    }

    @RequestMapping("/docflow/remove/{id}")
    public String removeDocument(@PathVariable("id") Long id)
    {
        this.documentService.remove(id);
        return "redirect:/docflow";
    }

    @RequestMapping("/docflow/edit/{id}")
    public String editDocument(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("document", this.documentService.getById(id));
        model.addAttribute("documents", this.documentService.list());
        return "/docflow";
    }

    //************************************************************************************************
    /// DocumentType

    @RequestMapping(value= "/docflow/documentType/add", method = RequestMethod.POST)
    public String SaveOrUpdateDocumentType(@ModelAttribute("documentType") DocumentType documentType)
    {
        if(documentType.getId() == null){
            this.documentTypeService.add(documentType);
        } else {
            this.documentTypeService.update(documentType);
        }
        return "redirect:/docflow";
    }

    @RequestMapping("/docflow/documentType/remove/{id}")
    public String removeDocumentType(@PathVariable("id") Long id)
    {
        this.documentTypeService.remove(id);
        return "redirect:/docflow";
    }

    //************************************************************************************************
    // Document Subtype

    @RequestMapping(value= "/docflow/documentSubType/add", method = RequestMethod.POST)
    public String SaveOrUpdateDocumentSubType(@ModelAttribute("documentSubType") DocumentSubType documentSubType)
    {
        if(documentSubType.getId() == null){
            this.documentSubTypeService.add(documentSubType);
        }else{
            this.documentSubTypeService.update(documentSubType);
        }
        return "redirect:/docflow";
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
