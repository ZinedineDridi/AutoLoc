package tn.esprit.autoloc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.services.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping
    public ResponseEntity<Agence> add(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(agenceService.ajouterAgence(agence));
    }

    @GetMapping
    public ResponseEntity<List<Agence>> getAll() {
        return ResponseEntity.ok(agenceService.afficherAgences());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        return agenceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    @PutMapping
    public ResponseEntity<Agence> update(@RequestBody Agence agence) {
        return ResponseEntity.ok(agenceService.modifierAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenceService.supprimerAgence(id);
        return ResponseEntity.noContent().build();
    }
}
