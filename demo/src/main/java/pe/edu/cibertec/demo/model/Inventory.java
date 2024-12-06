package pe.edu.cibertec.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory") // Nombre explícito de la tabla
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Lazy loading para optimizar rendimiento
    @JoinColumn(name = "film_id", nullable = false, foreignKey = @ForeignKey(name = "fk_inventory_film")) // Nombre explícito para la llave foránea
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Lazy loading para optimizar rendimiento
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(name = "fk_inventory_store")) // Nombre explícito para la llave foránea
    private Store store;

    @Column(nullable = false, updatable = false) // Asegura que el valor siempre exista y no sea actualizado manualmente
    private LocalDateTime lastUpdate;

    // Actualización automática del campo `lastUpdate`
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdate = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    // Sobrescritura de equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryId != null && inventoryId.equals(inventory.inventoryId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
