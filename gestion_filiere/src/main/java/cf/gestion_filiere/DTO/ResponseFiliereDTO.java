package cf.gestion_filiere.DTO;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ResponseFiliereDTO {
    private Integer id;
    private String libelle;
    private String code;
}
