package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.services.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<Maintenance> add(
            @RequestBody Maintenance maintenance) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(maintenanceService.ajouterMaintenance(maintenance));
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAll() {
        return ResponseEntity.ok(maintenanceService.afficherMaintenances());
    }


    public ResponseEntity<Maintenance> update(@RequestBody Maintenance maintenance) {
        return ResponseEntity.ok(
                maintenanceService.modifierMaintenance(maintenance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        maintenanceService.supprimerMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
