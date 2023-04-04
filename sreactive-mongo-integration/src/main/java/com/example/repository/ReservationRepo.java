package com.example.repository;

import com.example.documents.Reservation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReservationRepo extends ReactiveCrudRepository<Reservation,String> {


}
