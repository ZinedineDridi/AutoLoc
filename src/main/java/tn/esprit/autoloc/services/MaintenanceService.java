package tn.esprit.autoloc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.repositories.MaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService implements IMaintenanceService{
    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> afficherMaintenances(){
        return maintenanceRepository.findAll();
    }

    @Override
    public void supprimerMaintenance(Long id){
        maintenanceRepository.deleteById(id);
    }
}
