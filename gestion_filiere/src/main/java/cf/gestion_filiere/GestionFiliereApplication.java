package cf.gestion_filiere;

import cf.gestion_filiere.configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
public class GestionFiliereApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionFiliereApplication.class, args);
    }

}
