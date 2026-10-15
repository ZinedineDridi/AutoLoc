package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> add(
            @RequestBody Reservation reservation) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.ajouterReservation(reservation));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(reservationService.afficherReservations());
    }


    @PutMapping
    public ResponseEntity<Reservation> update(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(
                reservationService.modifierReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservationService.supprimerReservation(id);
        return ResponseEntity.noContent().build();
    }
}
