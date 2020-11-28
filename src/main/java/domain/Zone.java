package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.InverseRelationShadowVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@PlanningEntity
public class Zone {
    private String id;
    private LocalDate date;
    private ZoneVolume volume;
    private List<Courier> couriers;

    public Zone() {
    }

    public Zone(String id, LocalDate date, ZoneVolume volume) {
        this.id = id;
        this.date = date;
        this.volume = volume;
        this.couriers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @InverseRelationShadowVariable(sourceVariableName = "zone")
    public List<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Courier> couriers) {
        this.couriers = couriers;
    }

    public ZoneVolume getVolume() {
        return volume;
    }

    public void setVolume(ZoneVolume volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return id.equals(zone.id) &&
                date.equals(zone.date) &&
                volume.equals(zone.volume) &&
                couriers.equals(zone.couriers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
