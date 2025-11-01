package cf.gestion_etudiant.service;

import cf.gestion_etudiant.DTO.RequestEtudiantDTO;
import cf.gestion_etudiant.DTO.ResponseEtudiantDTO;
import cf.gestion_etudiant.FeignClient.FiliereClient;
import cf.gestion_etudiant.entity.Etudiant;
import cf.gestion_etudiant.mapper.EtudiantMapper;
import cf.gestion_etudiant.models.Filiere;
import cf.gestion_etudiant.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private FiliereClient filiereRestClient;
    private EtudiantRepository etudiantRepository;
    private EtudiantMapper etudiantMapper;

    public EtudiantServiceImpl(FiliereClient filiereRestClient, EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
        this.filiereRestClient = filiereRestClient;
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
    }

    @Override
    public ResponseEtudiantDTO addEtudiant(RequestEtudiantDTO requestEtudiantDTO) {
        // Vérifier si la filière existe avant de sauvegarder
        try {
            Filiere filiere = filiereRestClient.getFiliereById(requestEtudiantDTO.getIdFiliere());


            if (filiere == null) {
                throw new RuntimeException("Filière introuvable !");
            }

        } catch (Exception e) {
            throw new RuntimeException("Filière introuvable : id = " + requestEtudiantDTO.getIdFiliere());
        }

        // Si la filière existe, on sauvegarde l'étudiant
        Etudiant etudiant = etudiantMapper.DTO_to_Etudiant(requestEtudiantDTO);
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return etudiantMapper.Etudiant_to_DTO(savedEtudiant);
    }


    @Override
    public List<ResponseEtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<ResponseEtudiantDTO> result = new ArrayList<>();

        for (Etudiant e : etudiants) {
            ResponseEtudiantDTO dto = etudiantMapper.Etudiant_to_DTO(e);

            try {
                // Try to get Filiere from gestion_filiere microservice
                Filiere filiere = filiereRestClient.getFiliereById(e.getIdFiliere());

                e.setFiliere(filiere);

                dto.setFiliere(filiere);
            } catch (Exception ex) {
                // Filiere not found or connection issue — just log and continue
                System.err.println("⚠ Filiere not found for id " + e.getIdFiliere());
                e.setFiliere(null);
            }

            result.add(dto);
        }

        return result;
    }


    @Override
    public ResponseEtudiantDTO getEtudiantById(Integer id_etudiant) {
        Etudiant etudiant = etudiantRepository.findById(id_etudiant).orElse(null);
        if (etudiant == null) return null;

        // Fetch filiere info from gestion_filiere microservice
        Filiere filiere = filiereRestClient.getFiliereById(etudiant.getIdFiliere());

        etudiant.setFiliere(filiere);

        return etudiantMapper.Etudiant_to_DTO(etudiant);
    }

    @Override
    public void deleteEtudiant(Integer id_etudiant) {
        etudiantRepository.deleteById(id_etudiant);

    }

    @Override
    public ResponseEtudiantDTO updateEtudiant(Integer id_etudiant, RequestEtudiantDTO requestEtudiantDTO) {
        Etudiant etudiant = etudiantRepository.findById(id_etudiant).orElse(null);
        Etudiant nv_etudiant = etudiantMapper.DTO_to_Etudiant(requestEtudiantDTO);
        if(nv_etudiant.getNom()!= null){ etudiant.setNom(nv_etudiant.getNom());}
        if (nv_etudiant.getPrenom()!= null){ etudiant.setPrenom(nv_etudiant.getPrenom());}
        if (nv_etudiant.getCne()!= null) { etudiant.setCne(nv_etudiant.getCne());}
        if (nv_etudiant.getIdFiliere()!= null){etudiant.setIdFiliere(nv_etudiant.getIdFiliere());}

        Etudiant saved_etudiant = etudiantRepository.save(etudiant);

        return etudiantMapper.Etudiant_to_DTO(saved_etudiant);
    }
    public List<Filiere> getAllFilieres() {
        try {
            // Example: call a Feign client method that returns List<Filiere>
            return filiereRestClient.getAllFilieres();
        } catch (Exception e) {
            System.err.println("⚠ Impossible de récupérer les filières : " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
