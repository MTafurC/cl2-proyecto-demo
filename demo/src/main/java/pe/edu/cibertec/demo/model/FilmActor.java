package pe.edu.cibertec.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "film_actor") // Especifica el nombre de la tabla explícitamente
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Carga diferida para optimizar el rendimiento
    @JoinColumn(name = "film_id", nullable = false) // Asegura la integridad referencial
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Carga diferida para optimizar el rendimiento
    @JoinColumn(name = "actor_id", nullable = false) // Asegura la integridad referencial
    private Actor actor;

    @Column(nullable = false, updatable = false) // Asegura que no sea nulo y no se actualice después de insertarse
    private LocalDateTime createdAt;

    @Column(nullable = false) // Campo obligatorio para registrar la última actualización
    private LocalDateTime lastUpdate;

    // Métodos para actualizar automáticamente las marcas de tiempo
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    // Sobrescritura de equals y hashCode para garantizar consistencia
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActor filmActor = (FilmActor) o;
        return Objects.equals(id, filmActor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
