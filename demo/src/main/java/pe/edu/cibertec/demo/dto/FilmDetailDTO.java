package pe.edu.cibertec.demo.dto;

import java.util.List;

/**
 * DTO para representar los detalles de una película.
 */
public class FilmDetailDTO {
    private Long filmId;                 // ID único de la película
    private String title;                // Título de la película
    private String description;          // Descripción de la película
    private Integer releaseYear;         // Año de lanzamiento
    private Integer rentalDuration;      // Duración del alquiler en días
    private Double rentalRate;           // Tarifa de alquiler
    private Integer length;              // Duración de la película en minutos
    private Double replacementCost;      // Coste de reemplazo
    private String rating;               // Clasificación de la película
    private String specialFeatures;      // Características especiales de la película
    private Long languageId;             // ID del idioma
    private String languageName;         // Nombre del idioma
    private List<Long> categoryIds;      // Lista de IDs de categorías
    private String categories;           // Categorías asociadas a la película (como texto)

    // Constructor completo
    public FilmDetailDTO(Long filmId, String title, String description, Integer releaseYear,
                         Integer rentalDuration, Double rentalRate, Integer length,
                         Double replacementCost, String rating, String specialFeatures,
                         Long languageId, String languageName, List<Long> categoryIds, String categories) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.languageId = languageId;
        this.languageName = languageName;
        this.categoryIds = categoryIds;
        this.categories = categories;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
