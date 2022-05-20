package com.softtek.controller;

import com.softtek.ejb.PersonFacadeLocal;
import com.softtek.ejb.UserFacadeLocal;
import com.softtek.model.Person;
import com.softtek.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UserController implements Serializable{
        
    @EJB
    private PersonFacadeLocal personEJB;
        
    @Inject
    private User user;
    
    @Inject
    private Person person;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void createAccount(){
        try {
            List list = new ArrayList();
            list.add(user);
            person.setVehicleList(list);
            person.setUserId(user);
            personEJB.create(person);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Exitoso",""));
            person = new Person();
            user = new User();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Faltan datos por ingresar",""));
        }
    }
    
}
