package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.services.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping
    public ResponseEntity<Equipement> add(
            @RequestBody Equipement equipement) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(equipementService.ajouterEquipement(equipement));
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> getAll() {
        return ResponseEntity.ok(equipementService.afficherEquipements());
    }


    public ResponseEntity<Equipement> update(@RequestBody Equipement equipement) {
        return ResponseEntity.ok(
                equipementService.modifierEquipement(equipement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipementService.supprimerEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
