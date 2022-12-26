package com.nikhilkalamdane.BookMyShow.Repository;

import com.nikhilkalamdane.BookMyShow.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
}
