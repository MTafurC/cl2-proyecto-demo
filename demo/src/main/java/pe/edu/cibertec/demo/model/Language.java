package pe.edu.cibertec.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable("languages") // Define el caché para la entidad Language
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId; // Clave primaria

    private String name; // Nombre del idioma

    // Constructor vacío requerido por JPA
    public Language() {
    }

    // Constructor personalizado para inicializar la entidad con un nombre
    public Language(String name) {
        this.name = name;
    }

    // Getters y Setters
    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
