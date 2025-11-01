package cf.gestion_etudiant.service;

import cf.gestion_etudiant.DTO.RequestEtudiantDTO;
import cf.gestion_etudiant.DTO.ResponseEtudiantDTO;
import cf.gestion_etudiant.models.Filiere;

import java.util.List;

public interface EtudiantService {
    public ResponseEtudiantDTO addEtudiant(RequestEtudiantDTO requestEtudiantDTO);
    public List<ResponseEtudiantDTO> getAllEtudiants();
    public ResponseEtudiantDTO getEtudiantById(Integer id_etudiant);
    public void deleteEtudiant(Integer id_etudiant);
    public ResponseEtudiantDTO updateEtudiant(Integer id_etudiant, RequestEtudiantDTO requestEtudiantDTO);
    public List<Filiere> getAllFilieres();
}
