package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    @Column( nullable = false)
    private String wording;

    @Column(nullable = false, length = 27)
    private String iban;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double sold;

    @ManyToOne
    @JoinColumn(name="idAgency")
    private Agency agency;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_Acoount_Customer_Association",
        joinColumns = @JoinColumn(name= "idAccount"),
        inverseJoinColumns = @JoinColumn(name= "idCustomer"))
    private List<Customer> customerList = new ArrayList<>();

    public Account(){

    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IdAccount=" + idAccount +
                ", wording='" + wording + '\'' +
                ", iban='" + iban + '\'' +
                ", sold=" + sold +
                ", agency=" + agency +
                '}';
    }
}
