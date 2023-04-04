package com.example.datainitializer;

import com.example.documents.Reservation;
import com.example.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Log4j2
public class SampleDataInitializer {

    private final ReservationRepo reservationRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void go(){
        /*step 1- Below code is verbose, we can remove this verbosity as below*/
       /* Flux<String> names = Flux.just("rakesh","akash","aarya","madhur");
        Flux<Reservation> reservations = names.map(name->new Reservation(null,name));
        Flux<Mono<Reservation>>flux =reservations.map(res->reservationRepo.save(res));
        or
        Flux<Reservation>savedReservations =reservations.flatMap(res->reservationRepo.save(res));

        */

        /*step-2 above code can be written in following way but the problem is whenever we execute it,
        * each time 4 record will be inserted in that, one way we can deal wih it see step-3*/
       /* var names = Flux.just("rakesh","akash","aarya","madhur")
                .map(name->new Reservation(null,name))
                .flatMap(reservationRepo::save);
        names.subscribe(log::info);*/


        /*step-3 we don't want to store the data repeatedly, so want to reset the database
        * here we subscribe deleteAll as we know subscription is asynchronous it could be in Thread1 or thread2
        * don't know.
        * */

        /*reservationRepo.deleteAll().subscribe();// may be in thread1 or thread2
        var names = Flux.just("rakesh","akash","aarya","madhur")//may be in thread1 or thread2
                .map(name->new Reservation(null,name))
                .flatMap(reservationRepo::save);
        names.subscribe(log::info);*/

        /*step-4 to deal with step3 we could block reservationRepo.deleteAll().block().subscribe(); the call
        * but this is a terrible idea. */

        /*step-5 way to deal with step-3 and step-4*/

        var names = Flux.just("rakesh","akash","aarya","madhur")//may be in thread1 or thread2
                .map(name->new Reservation(null,name))
                .flatMap(reservationRepo::save);

        reservationRepo.deleteAll()
                .thenMany(names)
                .thenMany(this.reservationRepo.findAll())
                .subscribe(log::info);

    }
}
