package com.geneza.lms.domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Person Entity
 * 
 * Generated by Dunamis App Generator
 */
@Entity
@Table(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "GenezaRest/com/geneza/lms/domain", name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstName")
    @XmlElement
    private String firstName;

    @Column(name = "lastName")
    @XmlElement
    private String lastName;

    @Column(name = "phone")
    @XmlElement
    private String phone;

    @Column(name = "email")
    @XmlElement
    private String email;

    @Column(name = "rollNumber")
    @XmlElement
    private String rollNumber;

    @Column(name = "country")
    @XmlElement
    private String country;

    @Column(name = "state")
    @XmlElement
    private String state;

    @Column(name = "region")
    @XmlElement
    private String region;

    @Column(name = "presentStatus")
    @XmlElement
    private String presentStatus;

    @Column(name = "gender")
    @XmlElement
    private String gender;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    @XmlElement
    private Date dob;

    @Column(name = "presentAddressStreet")
    @XmlElement
    private String presentAddressStreet;

    @Column(name = "presentAddressState")
    @XmlElement
    private String presentAddressState;

    @Column(name = "presentAddressCity")
    @XmlElement
    private String presentAddressCity;

    @Column(name = "presentAddressPin")
    @XmlElement
    private String presentAddressPin;

    @Column(name = "presentAddressCountry")
    @XmlElement
    private String presentAddressCountry;

    @Column(name = "fatherName")
    @XmlElement
    private String fatherName;

    @Column(name = "maritalStatus")
    @XmlElement
    private String maritalStatus;

    @Column(name = "spouseName")
    @XmlElement
    private String spouseName;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @XmlTransient
    private Country countryId;


    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    
    public String getPresentStatus() { return presentStatus; }
    public void setPresentStatus(String presentStatus) { this.presentStatus = presentStatus; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    
    public String getPresentAddressStreet() { return presentAddressStreet; }
    public void setPresentAddressStreet(String presentAddressStreet) { this.presentAddressStreet = presentAddressStreet; }
    
    public String getPresentAddressState() { return presentAddressState; }
    public void setPresentAddressState(String presentAddressState) { this.presentAddressState = presentAddressState; }
    
    public String getPresentAddressCity() { return presentAddressCity; }
    public void setPresentAddressCity(String presentAddressCity) { this.presentAddressCity = presentAddressCity; }
    
    public String getPresentAddressPin() { return presentAddressPin; }
    public void setPresentAddressPin(String presentAddressPin) { this.presentAddressPin = presentAddressPin; }
    
    public String getPresentAddressCountry() { return presentAddressCountry; }
    public void setPresentAddressCountry(String presentAddressCountry) { this.presentAddressCountry = presentAddressCountry; }
    
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    
    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }
    
    public String getSpouseName() { return spouseName; }
    public void setSpouseName(String spouseName) { this.spouseName = spouseName; }

    public Person() {
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return id != null && id.equals(person.id);
    }
}
