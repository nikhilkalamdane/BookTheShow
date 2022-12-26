package com.nikhilkalamdane.BookMyShow.Repository;

import com.nikhilkalamdane.BookMyShow.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    boolean existsByName(String name);
}
