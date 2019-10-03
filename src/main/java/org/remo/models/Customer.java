package org.remo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends BaseModel {

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")//con mappedBy va indicato il nome dell'ATTRIBUTO della joinColumn (vedi su Address)
    private List<Address> addressList;

    @Column(unique = true, length = 16, nullable = false)
    private String ssn;
    @Column(unique = true)
    private String email;

    @Column(name = "is_obsolete")
    private Boolean isObsolete;

    public Boolean getObsolete() {
        return isObsolete;
    }

    public void setObsolete(Boolean obsolete) {
        isObsolete = obsolete;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
