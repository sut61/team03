package com.sut.se.g03.repository;

import com.sut.se.g03.entity.Room;
import com.sut.se.g03.entity.Schedule;
import com.sut.se.g03.entity.TimePeriod;
import com.sut.se.g03.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TimeTableRepository extends JpaRepository<TimeTable,Long> {
    Collection<TimeTable> findAllByRoomAndAndSchedule(Optional<Room> room, Optional<Schedule> schedule);
    TimeTable findByRoomAndSchedule(Room room, Schedule schedule);
    TimeTable findByRoomAndScheduleAndTimePeriod(Room room, Schedule schedule, TimePeriod timePeriod);
}
