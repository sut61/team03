package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Room;
import com.sut.se.g03.entity.RoomInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RoomInstrumentRepository extends JpaRepository<RoomInstrument,Long> {
	Collection<RoomInstrument> findAllByRoom(Optional<Room> room);
	List<RoomInstrument> findByRoom(Room room);
}
