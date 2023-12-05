package hotel;

public class Reservation {

    private static int cpt;
    private int id ;

    private StatusReservation statusReservation;

    private Custumer custumer;

    private Room room;

    public Reservation(StatusReservation statusReservation, Custumer custumer, Room room) {
        this.id = cpt++;
        this.statusReservation = statusReservation;
        this.custumer = custumer;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusReservation getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation) {
        this.statusReservation = statusReservation;
    }

    public Custumer getCustumer() {
        return custumer;
    }

    public void setCustumer(Custumer custumer) {
        this.custumer = custumer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", statusReservation=" + statusReservation +
                ", custumer=" + custumer +
                ", room=" + room +
                '}';
    }
}
