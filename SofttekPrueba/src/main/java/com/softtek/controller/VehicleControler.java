package com.softtek.controller;

import com.softtek.ejb.BrandFacadeLocal;
import com.softtek.ejb.PersonFacadeLocal;
import com.softtek.ejb.ProviderFacadeLocal;
import com.softtek.ejb.StatusFacadeLocal;
import com.softtek.ejb.VehicleFacadeLocal;
import com.softtek.model.Brand;
import com.softtek.model.Person;
import com.softtek.model.Provider;
import com.softtek.model.Status;
import com.softtek.model.Vehicle;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class VehicleControler implements Serializable {

    @EJB
    private VehicleFacadeLocal vehicleEJB;
    @EJB
    private BrandFacadeLocal brandEJB;
    @EJB
    private PersonFacadeLocal personEJB;
    @EJB
    private StatusFacadeLocal statusEJB;
    @EJB
    private ProviderFacadeLocal providerEJB;
    @Inject
    private Vehicle vehicle;
    @Inject
    private Brand brand;
    @Inject
    private Person person;
    @Inject
    private Status status;
    @Inject
    private Provider provider;

    private String filter;
    private List<Brand> brandList;
    private List<Person> personList;
    private List<Status> statusList;
    private List<Provider> providerList;
    private List<Vehicle> vehicleList;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @PostConstruct
    public void init() {
        brandList = brandEJB.findAll();
        personList = personEJB.findAll();
        statusList = statusEJB.findAll();
        providerList = providerEJB.findAll();
        vehicleList = vehicleEJB.findAll();
    }

    public void create() {
        try {
            vehicle.setBrandId(brand);
            vehicle.setPersonId(person);
            Status statusActive = new Status();
            statusActive.setId(1);
            vehicle.setStatusId(statusActive);
            vehicle.setProviderId(provider);
            vehicleEJB.create(vehicle);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Exitoso", ""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Faltan datos por ingresar", ""));
        }
    }

    public void search() {
        try {
            vehicleList = vehicleEJB.search(filter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(Vehicle v) {
        try {
            vehicle = v;
            vehicleEJB.remove(vehicle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminado el registro", ""));
        } catch (Exception e) {
        }
    }

    public void read(Vehicle vehicleRead) {
        try {
            vehicle = vehicleRead;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void edit() {
        try {
            vehicle.setBrandId(brand);
            vehicle.setPersonId(person);
            vehicle.setStatusId(status);
            vehicle.setProviderId(provider);
            vehicleEJB.edit(vehicle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Exitoso", ""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Faltan datos por ingresar", ""));
        }
    }

}
