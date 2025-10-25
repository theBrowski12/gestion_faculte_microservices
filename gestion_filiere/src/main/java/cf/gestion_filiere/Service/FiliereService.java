package cf.gestion_filiere.Service;

import cf.gestion_filiere.DTO.RequestFiliereDTO;
import cf.gestion_filiere.DTO.ResponseFiliereDTO;


import java.util.List;


public interface FiliereService {
    public ResponseFiliereDTO addFiliere(RequestFiliereDTO requestFiliereDTO);
    public List<ResponseFiliereDTO> getAllFilieres();
    public ResponseFiliereDTO getFiliereById(Integer id);
    public void deleteFiliere(Integer id);
    public ResponseFiliereDTO updateFiliere(Integer id, RequestFiliereDTO requestFiliereDTO);
}
