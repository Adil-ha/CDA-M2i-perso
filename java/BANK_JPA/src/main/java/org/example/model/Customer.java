package org.example.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    private String lastname;

    private String firstname;

    private LocalDate dateBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_Acoount_Customer_Association",
            joinColumns = @JoinColumn(name= "idCustomer"),
            inverseJoinColumns = @JoinColumn(name= "idAccount"))
    private List<Account> accountList = new ArrayList<>();

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }
}
