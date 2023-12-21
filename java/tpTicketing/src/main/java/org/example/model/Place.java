package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exception.CustomFormatException;

@Data
@AllArgsConstructor
public class Place {

    private int id;
    private String name;
    private String address;
    private int capacity;

    public Place() {
    }

    public Place(int id) {
        this.id = id;
    }

    public Place(String name) {
        this.name = name;
    }

    public Place(String name, String address, int capacity){
        this.name = name;
        this.address = address;
        this.capacity = capacity;

    }



    public void setName(String name) throws CustomFormatException {
        if(name.length() > 2) {
            this.name = name;
        }else {
            throw new CustomFormatException("name should be gt 2 char");
        }
    }


    public void setAddress(String address) throws CustomFormatException {
        if(address.length() > 2) {
            this.address = address;
        }
        else {
            throw new CustomFormatException("address should be gt 2 char");
        }
    }


    public void setCapacity(int capacity) throws CustomFormatException {
        if(capacity > 0) {
            this.capacity = capacity;
        }
        else {
            throw new CustomFormatException("capacity should be positive");
        }
    }


    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                '}';
    }

    public String toStringComplete() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
