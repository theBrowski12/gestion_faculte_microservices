package cf.gestion_etudiant;

import cf.gestion_etudiant.configuration.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(RsaKeys.class)
public class GestionEtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEtudiantApplication.class, args);
    }

}
