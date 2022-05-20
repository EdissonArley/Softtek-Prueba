package com.softtek.controller;

import com.softtek.ejb.ProviderFacadeLocal;
import com.softtek.model.Provider;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ProviderController implements Serializable {

    @EJB
    private ProviderFacadeLocal providerEJB;

    @Inject
    private Provider provider;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void create() {
        try {
            providerEJB.create(provider);
            Provider provider = new Provider();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Exitoso",""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Faltan datos por ingresar",""));
        }
    }

}
