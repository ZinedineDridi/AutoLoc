package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.services.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @PostMapping
    public ResponseEntity<Paiement> add(
            @RequestBody Paiement paiement) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paiementService.ajouterPaiement(paiement));
    }

    @GetMapping
    public ResponseEntity<List<Paiement>> getAll() {
        return ResponseEntity.ok(paiementService.afficherPaiements());
    }


    @PutMapping
    public ResponseEntity<Paiement> update(@RequestBody Paiement paiement) {
        return ResponseEntity.ok(
                paiementService.modifierPaiement(paiement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
        return ResponseEntity.noContent().build();
    }
}
