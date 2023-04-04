package com.example.controller;

import com.example.documents.Reservation;
import com.example.repository.ReservationRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class ReservationRestController {
    private ReservationRepo reservationRepo;
  /*  @GetMapping("/reservations")
    Flux<Reservation> getReservations(){
        return  reservationRepo.findAll();
    }*/
}
