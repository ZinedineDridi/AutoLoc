package tn.esprit.autoloc.services;

import tn.esprit.autoloc.entities.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    Maintenance modifierMaintenance(Maintenance maintenance);
    List<Maintenance> afficherMaintenances();
    void supprimerMaintenance(Long id);
}
