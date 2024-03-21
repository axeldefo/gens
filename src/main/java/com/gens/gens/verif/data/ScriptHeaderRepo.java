package com.gens.gens.data;

import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;


interface ScriptHeaderRepo extends CrudRepository<ScriptHeader, Long> {
    // Custom methods for manipulating ScriptHeader

    // Method to find ScriptHeader by *
 
    ScripHeader findByBaseDeDonnee(String baseDeDonnee);
    ScripHeader findByService(String service);
    ScripHeader findByIssuer(BCF issuer);
    ScripHeader findByTransactionType(String transactionType);

    // Method to find ScriptHeader by creation date
    List<ScriptHeader> findByCreationDate(Date creationDate);

    // Method to find ScriptHeader by modification date
    List<ScriptHeader> findByModificationDate(Date modificationDate);

    // Method to delete a ScriptHeader by ID
    void deleteById(Long id);

    // Method to create a new ScriptHeader
    ScriptHeader save(ScriptHeader scriptHeader);
    
    // Method to retrieve all ScriptHeaders
    List<ScriptHeader> findAll();

    // Method to get the tostring of the ScriptHeader
    String toString();

    //delete by baseDeDonnee and service and issuer and transactionType and creationDate and modificationDate
    void deleteByBaseDeDonneeAndServiceAndIssuerAndTransactionTypeAndCreationDateAndModificationDate(String baseDeDonnee, String service, String issuer, String transactionType, Date creationDate, Date modificationDate);
}