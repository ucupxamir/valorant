package backend.valorant.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Calendar;

public class MapData {

    @NotEmpty(message = "Name is required")
    private String name;

    private Calendar createdAt;

    private Calendar updatedAt;

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
