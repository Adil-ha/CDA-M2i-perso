package hotel;

public class Room {

    private int cpt;
    private int id;

    private StatusRoom statusRoom;

    private double price ;

    private int capacity;

    public Room(StatusRoom statusRoom, double price, int capacity) {
        this.id = cpt++;
        this.statusRoom = statusRoom;
        this.price = price;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusRoom getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(StatusRoom statusRoom) {
        this.statusRoom = statusRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", statusRoom=" + statusRoom +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
