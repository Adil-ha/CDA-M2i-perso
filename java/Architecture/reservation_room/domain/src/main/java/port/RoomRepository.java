package port;

import entity.Room;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface RoomRepository {

    void addRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(Room room);



}

