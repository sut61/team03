package com.sut.se.g03.controller;

import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class RoomController{

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomInstrumentRepository roominstrumentRepository;
    @Autowired
    private RoomSizeRepository roomsizeRepository;
    @Autowired
    private RoomTypeRepository roomtypeRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @GetMapping("/Room")
    public Collection<Room> room() {
       return roomRepository.findAll();
    }
    
    @GetMapping("/RoomSize")
    public Collection<RoomSize> roomSize() {
       return roomsizeRepository.findAll();
    }

    @GetMapping("/RoomType")
    public Collection<RoomType> roomType() {
       return roomtypeRepository.findAll();
    }

    @GetMapping("/Instrument")
    public Collection<Instrument> instrument() {
       return instrumentRepository.findAll();
    }

    @PostMapping("/Room/addRoom/{name}/{rate}/{roomSizeId}/{roomTypeId}")
    public Room newRoom(@PathVariable String name, @PathVariable int rate,@PathVariable Long roomSizeId,@PathVariable Long roomTypeId) {
        Room newRoom = new Room();
        RoomSize roomsize = roomsizeRepository.findById(roomSizeId).get();
        RoomType roomtype = roomtypeRepository.findById(roomTypeId).get();
        newRoom.setName(name);
        newRoom.setRate(rate);
        newRoom.setRoomSize(roomsize);
        newRoom.setRoomType(roomtype);
        return roomRepository.save(newRoom);
    } 
    
    @PostMapping("/RoomInstrument/addInstrument/{roomId}/{instrumentId}")
    public RoomInstrument newRoomInstrument(@PathVariable Long roomId, @PathVariable Long instrumentId) {
        RoomInstrument newRoomInstrument = new RoomInstrument();
        Room room = roomRepository.findById(roomId).get();
        Instrument instrument = instrumentRepository.findById(instrumentId).get();
        newRoomInstrument.setRoom(room);
        newRoomInstrument.setInstrument(instrument);
        return roominstrumentRepository.save(newRoomInstrument);
    } 
    
}
