package com.dio.crud.reservadesala.reservadesala.controller;

import com.dio.crud.reservadesala.reservadesala.model.Room;
import com.dio.crud.reservadesala.reservadesala.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/rooms")
    public ResponseEntity<Object> createRoom( @Valid @RequestBody Room room){
        roomService.createRoom(room);
        return new ResponseEntity<>("room is created sucessfully", HttpStatus.CREATED);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomService.getAll();
    }

    @GetMapping("/rooms/{id}")
    public HttpEntity<? extends Object> getRoom(@PathVariable("id") Long id) throws Exception {
        Room founded = roomService.getById(id);
        if(founded == null){
            return new ResponseEntity<>("room not founded", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Room>(founded, HttpStatus.OK);
    }

    @PutMapping("rooms/{id}")
    public ResponseEntity<Object> updateRoom(@Valid @RequestBody Room room, @PathVariable("id") Long id){
        roomService.updateRoom(id, room);
        return new ResponseEntity<>("room is updated", HttpStatus.OK);
    }

    @DeleteMapping("rooms/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable("id") Long id){
        roomService.deleteRoom(id);
        return new ResponseEntity<>("room is deleted", HttpStatus.OK);
    }
}
