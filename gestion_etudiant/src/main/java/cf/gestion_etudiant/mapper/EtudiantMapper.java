package cf.gestion_etudiant.mapper;

import cf.gestion_etudiant.DTO.RequestEtudiantDTO;
import cf.gestion_etudiant.DTO.ResponseEtudiantDTO;
import cf.gestion_etudiant.entity.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EtudiantMapper {
    public Etudiant DTO_to_Etudiant(RequestEtudiantDTO requestEtudiantDTO) {
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(requestEtudiantDTO, etudiant);
        return etudiant;
    }

    public ResponseEtudiantDTO Etudiant_to_DTO(Etudiant etudiant) {
        ResponseEtudiantDTO responseEtudiantDTO = new ResponseEtudiantDTO();
        BeanUtils.copyProperties(etudiant, responseEtudiantDTO);
        return responseEtudiantDTO;
    }
}
