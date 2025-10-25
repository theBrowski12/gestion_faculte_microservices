package cf.gestion_etudiant.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor

public class RequestEtudiantDTO {
    private String nom;
    private String prenom;
    private String cne;
    private Integer id_filiere;
}
