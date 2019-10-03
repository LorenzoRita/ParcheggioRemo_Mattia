package org.remo.dtos;

public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String ssn;
    private String email;
    private boolean isObsolete;

    public CustomerDTO() {

    }

    public CustomerDTO(Long id, String firstName, String lastName, String ssn, String email, boolean isObsolete) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.isObsolete = isObsolete;
    }

    public boolean isObsolete() {
        return isObsolete;
    }

    public void setObsolete(boolean obsolete) {
        isObsolete = obsolete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
