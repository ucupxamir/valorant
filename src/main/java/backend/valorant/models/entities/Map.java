package backend.valorant.models.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "m_maps")
public class Map {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "CHAR(36)", updatable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", columnDefinition = "VARCHAR(50)", unique = true, nullable = false)
    private String name;

    @CreationTimestamp
    private Calendar createdAt;

    @UpdateTimestamp
    private Calendar updatedAt;

    public Map() {
    }

    public Map(UUID id, String name, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

}
