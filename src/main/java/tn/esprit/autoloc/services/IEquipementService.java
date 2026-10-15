package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);
    Equipement modifierEquipement(Equipement equipement);
    List<Equipement> afficherEquipements();
    void supprimerEquipement(Long id);
}
