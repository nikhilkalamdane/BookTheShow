package com.nikhilkalamdane.BookMyShow.Repository;

import com.nikhilkalamdane.BookMyShow.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity, Integer> {
}
