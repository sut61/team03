package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Room;
import com.sut.se.g03.entity.RoomSize;
import com.sut.se.g03.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RoomRepository extends JpaRepository<Room,Long> {
    Collection<Room> findByRoomSizeAndRoomType(Optional<RoomSize> roomSize, Optional<RoomType> roomType);
}
