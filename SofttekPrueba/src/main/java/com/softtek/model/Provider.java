package com.softtek.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(catalog = "softtek", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p"),
    @NamedQuery(name = "Provider.findById", query = "SELECT p FROM Provider p WHERE p.id = :id"),
    @NamedQuery(name = "Provider.findByBusinessName", query = "SELECT p FROM Provider p WHERE p.businessName = :businessName"),
    @NamedQuery(name = "Provider.findByBusinessIdentification", query = "SELECT p FROM Provider p WHERE p.businessIdentification = :businessIdentification"),
    @NamedQuery(name = "Provider.findByAdrees", query = "SELECT p FROM Provider p WHERE p.adrees = :adrees"),
    @NamedQuery(name = "Provider.findByEmail", query = "SELECT p FROM Provider p WHERE p.email = :email")})
public class Provider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "business_name", nullable = false, length = 75)
    private String businessName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "business_identification", nullable = false, length = 75)
    private String businessIdentification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(nullable = false, length = 75)
    private String adrees;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(nullable = false, length = 75)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerId")
    private List<Vehicle> vehicleList;

    public Provider() {
    }

    public Provider(Integer id) {
        this.id = id;
    }

    public Provider(Integer id, String businessName, String businessIdentification, String adrees, String email) {
        this.id = id;
        this.businessName = businessName;
        this.businessIdentification = businessIdentification;
        this.adrees = adrees;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessIdentification() {
        return businessIdentification;
    }

    public void setBusinessIdentification(String businessIdentification) {
        this.businessIdentification = businessIdentification;
    }

    public String getAdrees() {
        return adrees;
    }

    public void setAdrees(String adrees) {
        this.adrees = adrees;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
