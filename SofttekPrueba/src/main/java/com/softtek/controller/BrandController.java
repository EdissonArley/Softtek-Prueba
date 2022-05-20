package com.softtek.controller;

import com.softtek.ejb.BrandFacadeLocal;
import com.softtek.model.Brand;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class BrandController implements Serializable{
    
    @EJB
    private BrandFacadeLocal brandEJB;
    
    @Inject
    private Brand brand;

    public BrandFacadeLocal getBrandEJB() {
        return brandEJB;
    }

    public void setBrandEJB(BrandFacadeLocal brandEJB) {
        this.brandEJB = brandEJB;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    
    public void create(){
        try{
            brandEJB.create(brand);
        }catch(Exception e){
            
        }
    }
    
}
