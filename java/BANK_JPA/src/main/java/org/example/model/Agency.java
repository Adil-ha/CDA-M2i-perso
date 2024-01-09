package org.example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="T_Agency")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgency;

    private String address;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private List<Account> accountList = new ArrayList<>();

    public Agency(){

    }

    public Long getId() {
        return idAgency;
    }

    public void setId(Long id) {
        this.idAgency = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "idAgency=" + idAgency +
                ", address='" + address + '\'' +
                '}';
    }
}
