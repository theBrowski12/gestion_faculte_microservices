package cf.gestion_etudiant.WebController;

import cf.gestion_etudiant.DTO.RequestEtudiantDTO;
import cf.gestion_etudiant.DTO.ResponseEtudiantDTO;
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
    // Ouvrir la page de modification
    @GetMapping("/modifier/{id}")
    public String editEtudiant(@PathVariable Integer id, Model model) {
        ResponseEtudiantDTO etudiantDTO = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiantId", id);
        model.addAttribute("etudiantDTO", etudiantDTO);
        List<Filiere> filieres = etudiantService.getAllFilieres(); // you need to implement this
        model.addAttribute("filieres", filieres);//
        return "ModifierEtudiant";
    }

    @PostMapping("/modifier/{id}")
    public String saveEtudiant(@PathVariable Integer id,
                               @ModelAttribute("etudiantDTO") RequestEtudiantDTO etudiantDTO) {
        etudiantService.updateEtudiant(id, etudiantDTO);
        return "redirect:/web/etudiants";
    }
    // SUPPRIMER
    @GetMapping("/delete/{id}")
    public String deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/web/etudiants";
    }
}
