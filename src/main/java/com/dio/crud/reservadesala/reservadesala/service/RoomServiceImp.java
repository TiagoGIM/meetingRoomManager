package com.dio.crud.reservadesala.reservadesala.service;

import com.dio.crud.reservadesala.reservadesala.model.Room;
import com.dio.crud.reservadesala.reservadesala.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void createRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(Long id){
        return roomRepository.findById(id).orElse(null);//
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        /*
        Optional<Room> founded = roomRepository.findById(id);
        if(founded.isPresent()) {
            Room toUpdate = founded.get();
            toUpdate.setCodRoom(room.getCodRoom());
            toUpdate.setDate(room.getDate());
            toUpdate.setEndHour(room.getEndHour());
            toUpdate.setStarHour(room.getStarHour());
            roomRepository.save(toUpdate);
        }
         */
        roomRepository.deleteById(id);
        room.setIdRoom(id);
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
