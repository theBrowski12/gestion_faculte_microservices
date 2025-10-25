package cf.gestion_filiere.mappers;


import cf.gestion_filiere.DTO.RequestFiliereDTO;
import cf.gestion_filiere.DTO.ResponseFiliereDTO;
import cf.gestion_filiere.Entites.Filiere;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {
    public Filiere DTO_to_Filiere(RequestFiliereDTO requestFiliereDTO) {
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(requestFiliereDTO, filiere);
        return filiere;
    }
    public ResponseFiliereDTO Filiere_To_DTO(Filiere filiere) {
        ResponseFiliereDTO responseFiliereDTO = new ResponseFiliereDTO();
        BeanUtils.copyProperties(filiere, responseFiliereDTO);
        return responseFiliereDTO;
    }
}
