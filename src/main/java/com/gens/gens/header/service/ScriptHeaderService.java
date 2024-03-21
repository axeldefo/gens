package com.gens.gens.header.service;

import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.gens.gens.header.model.ScriptHeader;
import com.gens.gens.header.repo.ScriptHeaderRepo;
import com.gens.gens.exception.ResourceNotFoundException;

@Service
public class ScriptHeaderService {
    // Custom methods for manipulating ScriptHeader

    private final ScriptHeaderRepo scriptHeaderRepo;

    public ScriptHeaderService(ScriptHeaderRepo scriptHeaderRepo) {
        this.scriptHeaderRepo = scriptHeaderRepo;
    }
    
    // Method to find ScriptHeader by *
    public ScripHeader findByBaseDeDonnee(String baseDeDonnee) {
        return ScriptHeaderRepo.findByBaseDeDonnee(baseDeDonnee).orElse(null);
    }

    public ScripHeader findByService(String service) {
        return ScriptHeaderRepo.findByService(service).orElse(null);
    }

    public ScripHeader findByIssuer(BCF issuer) {
        return ScriptHeaderRepo.findByIssuer(issuer).orElse(null);
    }
    public ScripHeader findByTransactionType(String transactionType) {
        return  ScriptHeaderRepo.findByTransactionType(transactionType).orElse(null);
    }

    // Method to find ScriptHeader by creation date
    public List<ScriptHeader> findByCreationDate(Date creationDate) {
        return scriptHeaderRepo.findByCreationDate(creationDate);
    }

    // Method to find ScriptHeader by modification date
    public List<ScriptHeader> findByModificationDate(Date modificationDate) {
        List<ScriptHeader> scriptHeaders = new ArrayList<>();
        scriptHeaderRepo.findByModificationDate(modificationDate).forEach(scriptHeaders::add); 
        return scriptHeaders;
    }

    // Method to delete a ScriptHeader by ID
    public void deleteById(Long id) {
        //use the repo to delete the script header
        scriptHeaderRepo.deleteById(id);

    }

    //delete by baseDeDonnee and service and issuer and transactionType and creationDate and modificationDate
    public void deleteByBaseDeDonneeAndServiceAndIssuerAndTransactionTypeAndCreationDateAndModificationDate(String baseDeDonnee, String service, String issuer, String transactionType, Date creationDate, Date modificationDate) {
        //use the repo to delete the script header
        scriptHeaderRepo.deleteByBaseDeDonneeAndServiceAndIssuerAndTransactionTypeAndCreationDateAndModificationDate(baseDeDonnee, service, issuer, transactionType, creationDate, modificationDate);
    }

    // Method to create a new ScriptHeader
    public ScriptHeader create(ScriptHeader scriptHeader) {
        return scriptHeaderRepo.save(scriptHeader);
    }

    // Method to update a ScriptHeader by ID
    public ScriptHeader updateScriptHeader(Long id, ScriptHeader updatedScriptHeader) {
    return scriptHeaderRepo.findById(id)
        .map(scriptHeader -> {
            scriptHeader.setBaseDeDonnee(updatedScriptHeader.getBaseDeDonnee());
            scriptHeader.setService(updatedScriptHeader.getService());
            scriptHeader.setIssuer(updatedScriptHeader.getIssuer());
            scriptHeader.setTransactionType(updatedScriptHeader.getTransactionType());
            return scriptHeaderRepo.save(scriptHeader);
        })
        .orElseThrow(() -> new ResourceNotFoundException("ScriptHeader not found with id " + id));
    }

    // Method to retrieve all ScriptHeaders
    public List<ScriptHeader> findAll() {
        return scriptHeaderRepo.findAll();
    }

}

