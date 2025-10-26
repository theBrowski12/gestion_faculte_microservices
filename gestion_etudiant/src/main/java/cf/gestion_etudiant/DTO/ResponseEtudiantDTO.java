package cf.gestion_etudiant.DTO;

import cf.gestion_etudiant.models.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class ResponseEtudiantDTO {
    private Integer idEtudiant;
    private String nom;
    private String prenom;
    private String cne;
    private Integer id_filiere;
    private Filiere filiere;
}
