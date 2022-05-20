/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softtek.controller;

import com.softtek.model.User;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TemplateController implements Serializable {
    
    public void verifySession() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            User user = (User) context.getExternalContext().getSessionMap().get("user");
            if (user == null) {
                context.getExternalContext().redirect("permits.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
