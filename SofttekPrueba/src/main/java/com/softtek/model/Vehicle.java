package com.softtek.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(catalog = "softtek", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicle.findByPlate", query = "SELECT v FROM Vehicle v WHERE v.plate = :plate"),
    @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String plate;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int model;
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Brand brandId;
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "provider_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Provider providerId;
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Status statusId;

    public Vehicle() {
    }

    public Vehicle(Integer id) {
        this.id = id;
    }

    public Vehicle(Integer id, String plate, int model) {
        this.id = id;
        this.plate = plate;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

}
