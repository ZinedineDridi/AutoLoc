package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.services.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<Vehicule> add(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehiculeService.ajouterVehicule(vehicule));
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAll() {
        return ResponseEntity.ok(vehiculeService.afficherVehicules());
    }

    @PutMapping
    public ResponseEntity<Vehicule> update(@RequestBody Vehicule vehicule) {
        return ResponseEntity.ok(vehiculeService.modifierVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
