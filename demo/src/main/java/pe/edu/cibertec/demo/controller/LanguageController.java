package pe.edu.cibertec.demo.controller;

import pe.edu.cibertec.demo.model.Language;
import pe.edu.cibertec.demo.service.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LanguageController {

    private final LanguageService languageService;

    // Inyección de dependencias mediante constructor
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * Endpoint para listar todos los idiomas.
     * Este endpoint puede ser utilizado para poblar selectores en formularios
     * de creación o edición de películas.
     *
     * @param model Modelo para pasar datos al template
     * @return Nombre del template para mostrar la lista de idiomas
     */
    @GetMapping("/languages")
    public String listLanguages(Model model) {

        List<Language> languages = languageService.getAllLanguages();


        model.addAttribute("languages", languages);


        return "languages/list";
    }
}
