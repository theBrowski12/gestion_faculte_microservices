package cf.gestion_etudiant.FeignClient;

import cf.gestion_etudiant.models.Filiere;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "gestion-filiere",
        url = "http://localhost:8081/v1/filieres" // Base URL of the filiere microservice
)
public interface FiliereClient {
    @GetMapping("/{id}")
    public Filiere getFiliereById(@PathVariable("id") Integer id);

    @GetMapping("/all")
    List<Filiere> getAllFilieres(); // new endpoint to fetch all filières
}
