package port;

import entity.Room;
import entity.User;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ReservationRepository {

    List<Room> searchAvailableRooms(Date date, Time startTime, Time endTime, int capacity);

    boolean makeRoomReservation(User user, Room room, Date date, Time startTime, Time endTime);
}
