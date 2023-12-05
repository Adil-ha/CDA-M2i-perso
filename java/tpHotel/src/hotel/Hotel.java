package hotel;

import java.util.Arrays;

public class Hotel {

    private String name;

    private Room[] rooms;

    private Reservation[] reservations;

    private Custumer[] custumers;

    public Hotel(String name, Room[] rooms, Reservation[] reservations, Custumer[] custumers) {
        this.name = name;
        this.rooms = rooms;
        this.reservations = reservations;
        this.custumers = custumers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    public Custumer[] getCustumers() {
        return custumers;
    }

    public void setCustumers(Custumer[] custumers) {
        this.custumers = custumers;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rooms=" + Arrays.toString(rooms) +
                ", reservations=" + Arrays.toString(reservations) +
                ", custumers=" + Arrays.toString(custumers) +
                '}';
    }
}
