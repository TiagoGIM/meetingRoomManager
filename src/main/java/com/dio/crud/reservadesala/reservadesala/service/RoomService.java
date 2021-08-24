package com.dio.crud.reservadesala.reservadesala.service;

import com.dio.crud.reservadesala.reservadesala.model.Room;

import java.util.Collection;
import java.util.List;

public interface RoomService {
    public abstract void createRoom(Room room);
    public abstract List<Room> getAll();
    public abstract Room getById(Long id) ;
    public abstract Room updateRoom(Long id, Room room);
    public abstract void deleteRoom(Long id);
}
