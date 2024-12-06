package pe.edu.cibertec.demo.dto;

public class FilmListDTO {
    private Long filmId;
    private String title;
    private String languageName;
    private Integer rentalDuration;
    private Double rentalRate;
    private String description; // Nueva propiedad añadida

    // Constructor que incluye descripción
    public FilmListDTO(Long filmId, String title, String description, String languageName, Integer rentalDuration, Double rentalRate) {
        this.filmId = filmId;
        this.title = title;
        this.description = description; // Asigna la descripción
        this.languageName = languageName;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
    }
/*
    // Constructor con todos los parámetros, incluida la nueva propiedad
    public FilmListDTO(Long filmId, String title, String languageName, Integer rentalDuration, Double rentalRate, String description) {
        this.filmId = filmId;
        this.title = title;
        this.languageName = languageName;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.description = description; // Inicializamos la descripción
    }

    // Constructor sin descripción (opcional, en caso no siempre quieras inicializarla)
    public FilmListDTO(Long filmId, String title, String languageName, Integer rentalDuration, Double rentalRate) {
        this.filmId = filmId;
        this.title = title;
        this.languageName = languageName;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
    }


 */
    // Getters y Setters
    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public String getDescription() { // Getter para descripción
        return description;
    }

    public void setDescription(String description) { // Setter para descripción
        this.description = description;
    }
}
