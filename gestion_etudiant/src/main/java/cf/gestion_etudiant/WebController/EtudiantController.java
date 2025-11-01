package cf.gestion_etudiant.WebController;

import cf.gestion_etudiant.DTO.RequestEtudiantDTO;
import cf.gestion_etudiant.models.Filiere;
import cf.gestion_etudiant.service.EtudiantServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/etudiants")
public class EtudiantController {

    private final EtudiantServiceImpl etudiantService;

    public EtudiantController(EtudiantServiceImpl etudiantService) {
        this.etudiantService = etudiantService;
    }

    // LISTE
    @GetMapping
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        model.addAttribute("newEtudiant", new RequestEtudiantDTO());
        List<Filiere> filieres = etudiantService.getAllFilieres(); // you need to implement this
        model.addAttribute("filieres", filieres);// populate dropdown
        return "etudiants";
    }

    // AJOUTER
    @PostMapping("/add")
    public String addEtudiant(@ModelAttribute("newEtudiant") RequestEtudiantDTO dto) {
        etudiantService.addEtudiant(dto);
        return "redirect:/web/etudiants";
    }

    // MODIFIER
    @PostMapping("/update/{id}")
    public String updateEtudiant(@PathVariable Integer id,
                                 @RequestParam String nom,
                                 @RequestParam String prenom,
                                 @RequestParam String cne,
                                 @RequestParam("idFiliere") Integer idFiliere) {
        RequestEtudiantDTO dto = new RequestEtudiantDTO(nom, prenom, cne, idFiliere);
        etudiantService.updateEtudiant(id, dto);
        return "redirect:/web/etudiants";
    }


    // SUPPRIMER
    @GetMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/web/etudiants";
    }
}
