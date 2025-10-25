package cf.gestion_etudiant.entity;

import cf.gestion_etudiant.models.Filiere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String nom;
    private String prenom;
    private String cne;
    private Integer id_filiere;
    @Transient //pour ne pas créer une colonne dans la base de données
    private Filiere filiere;
}
