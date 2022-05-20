package com.softtek.controller;

import com.softtek.ejb.UserFacadeLocal;
import com.softtek.model.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable {

    @EJB
    UserFacadeLocal EJBUser;

    @Inject
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String signIn() {
        User us;
        String redirect = null;
        try {
            us = EJBUser.signIn(user);
            if (us != null) {
                if (us.getRol().equals("administrador")) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", us);
                    redirect = "/main/provider/create?faces-redirect=true";
                } else {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", us);
                    redirect = "/main/operator/vehicle/list?faces-redirect=true";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario invalido", ""));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ""));
        }
        return redirect;
    }

    public void signOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

}
