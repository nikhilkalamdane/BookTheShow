package com.nikhilkalamdane.BookMyShow.Repository;

import com.nikhilkalamdane.BookMyShow.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
