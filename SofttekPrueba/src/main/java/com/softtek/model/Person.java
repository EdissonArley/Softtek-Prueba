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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(catalog = "softtek", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Person.findByDni", query = "SELECT p FROM Person p WHERE p.dni = :dni")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String dni;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private List<Vehicle> vehicleList;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String firstName, String lastname, String dni) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
