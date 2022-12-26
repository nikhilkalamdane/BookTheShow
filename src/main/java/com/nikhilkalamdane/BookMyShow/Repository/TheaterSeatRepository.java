package com.nikhilkalamdane.BookMyShow.Repository;

import com.nikhilkalamdane.BookMyShow.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeatsEntity, Integer> {
}
