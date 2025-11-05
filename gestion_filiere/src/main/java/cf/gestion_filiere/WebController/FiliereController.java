package cf.gestion_filiere.WebController;

import cf.gestion_filiere.DTO.RequestFiliereDTO;
import cf.gestion_filiere.DTO.ResponseFiliereDTO;
import cf.gestion_filiere.Entites.Filiere;
import cf.gestion_filiere.Service.FiliereService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/web/filieres")
public class FiliereController {

        private final FiliereService filiereService;

        public FiliereController(FiliereService filiereService) {
            this.filiereService = filiereService;
        }

        // 🟢 LISTE
        @GetMapping
        public String listFilieres(Model model) {
            model.addAttribute("filieres", filiereService.getAllFilieres());
            model.addAttribute("newFiliere", new RequestFiliereDTO()); // pour le formulaire d'ajout
            return "filieres";
        }

        // 🟢 AJOUTER
        @PostMapping("/add")
        public String addFiliere(@ModelAttribute("newFiliere") RequestFiliereDTO dto) {
            filiereService.addFiliere(dto);
            return "redirect:/web/filieres";
        }

    // Ouvrir la page de modification
    @GetMapping("/modifier/{id}")
    public String editFiliere(@PathVariable Integer id, Model model) {
        ResponseFiliereDTO filiereDTO = filiereService.getFiliereById(id); // DTO from service
        model.addAttribute("filiereId", id);
        model.addAttribute("filiereDTO", filiereDTO); // bind to DTO, not entity
        return "ModifierFiliere"; // Thymeleaf template
    }

    // Sauvegarder la filière modifiée
    @PostMapping("/modifier/{id}")
    public String saveFiliere(@PathVariable Integer id,
                              @ModelAttribute("filiereDTO") RequestFiliereDTO filiereDTO) {
        filiereService.updateFiliere(id, filiereDTO); // service handles mapping & saving
        return "redirect:/web/filieres";
    }



    // 🔴 SUPPRIMER
    @GetMapping("/delete/{id}")
        public String deleteFiliere(@PathVariable Integer id) {
            filiereService.deleteFiliere(id);
            return "redirect:/web/filieres";
        }
}

