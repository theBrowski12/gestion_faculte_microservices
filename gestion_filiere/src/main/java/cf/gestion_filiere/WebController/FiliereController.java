package cf.gestion_filiere.WebController;

import cf.gestion_filiere.DTO.RequestFiliereDTO;
import cf.gestion_filiere.Service.FiliereService;
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

        // 🟠 MODIFIER
        @PostMapping("/update/{id}")
        public String updateFiliere(@PathVariable Integer id,
                                    @RequestParam String code,
                                    @RequestParam String libelle) {
            RequestFiliereDTO dto = new RequestFiliereDTO(code, libelle);
            filiereService.updateFiliere(id, dto);
            return "redirect:/web/filieres";
        }


    // 🔴 SUPPRIMER
        @GetMapping("/delete/{id}")
        public String deleteFiliere(@PathVariable Integer id) {
            filiereService.deleteFiliere(id);
            return "redirect:/web/filieres";
        }
}

