package com.gens.gens.data;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ID;
import jakarta.persistence.Entity;
import java.util.Objects;

@Entity
public class ScriptHeader implements Serializable {
    
    private static final long serialVersionUID = 144293603488149743L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String baseDeDonnee;
    private String service;
    private String issuer;
    private String transaction_type_2X;

    public ScriptHeader() {
    }

    public ScriptHeader(String baseDeDonnee, String service, String issuer, String transaction_type_2X) {
        this.baseDeDonnee = baseDeDonnee;
        this.service = service;
        this.issuer = issuer;
        this.transaction_type_2X = transaction_type_2X;
    }

    public String getBaseDeDonnee() {
        return baseDeDonnee;
    }

    public void setBaseDeDonnee(String baseDeDonnee) {
        this.baseDeDonnee = baseDeDonnee;
    }

    public String getService() {
        return service;
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setService(String service) {
        this.service = service;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getTransaction_type_2X() {
        return this.transactionType;
    }

    public void setTransaction_type_2X(String transaction_type_2X) {
        this.transaction_type_2X = transaction_type_2X;
    }

    public String select () {
        String var = "";
        String[] tab = {"service", "issuer", "transaction_type_2X"};
        if (service.isEmpty()==false) {
            var = var + "SELECT 'service' INTO @service;\n";
        } else if (issuer.isEmpty()==false) {
            var = var + "SELECT 'issuer' INTO @issuer;\n";
        } else if (transaction_type_2X.isEmpty()==false) {
            var = var + "SELECT 'transaction_type_2X' INTO @transaction_type_2X;\n";
        }
        return var;
    }

    @Override
    public String toString() {
        return "\nUSE `" + baseDeDonnee + "`;\n"
                + select() + "\n";
    }
    

}
