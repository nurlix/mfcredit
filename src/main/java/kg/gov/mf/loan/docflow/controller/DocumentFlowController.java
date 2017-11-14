package kg.gov.mf.loan.docflow.controller;

import kg.gov.mf.loan.docflow.model.Document;
import kg.gov.mf.loan.docflow.service.GenericService;
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
    GenericService<Document> documentService;

    @RequestMapping(value = "/docflow")
    public String listDocuments(Model model) {
        //model.addAttribute("documents", documentService.list());
        //model.addAttribute("document", new Document());
        return "/docflow/document/index";
    }

    @RequestMapping("/docflow/json/")
    @ResponseBody
    public List<Document> listDocuments() {
        return documentService.list();
    }

    @RequestMapping("/docflow/json/{id}")
    @ResponseBody
    public Document getDocumentString(@PathVariable("id") Long id) {
        return documentService.getById(id);
    }

    @RequestMapping(value= "/docflow/add")
    @ResponseBody
    public String SaveOrUpdateDocument(@ModelAttribute("document") Document document) {

        if((document.getId() == null) || (document.getId() == 0)){
            this.documentService.add(document);
        } else {
            this.documentService.update(document);
        }
        return "OK";
    }

    @RequestMapping("/docflow/remove/{id}")
    @ResponseBody
    public String removeDocument(@PathVariable("id") Long id) {
        this.documentService.remove(id);
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
