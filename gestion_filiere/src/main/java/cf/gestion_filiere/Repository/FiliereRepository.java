package cf.gestion_filiere.Repository;

import cf.gestion_filiere.Entites.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereRepository extends JpaRepository<Filiere, Integer> {
}
