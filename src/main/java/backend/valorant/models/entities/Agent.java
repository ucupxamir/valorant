package backend.valorant.models.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "m_agents")
public class Agent {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "CHAR(36)", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", columnDefinition = "VARCHAR(50)", unique = true)
    private String name;

    @Column(name = "role", nullable = false)
    private AgentRole role;

    @CreationTimestamp
    private Calendar createdAt;

    @UpdateTimestamp
    private Calendar updatedAt;

    public Agent() {
    }

    public Agent(UUID id, String name, AgentRole role, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public AgentRole getRole() {
        return role;
    }

    public void setRole(AgentRole role) {
        this.role = role;
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
