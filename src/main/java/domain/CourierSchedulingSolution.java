package domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.bendable.BendableScore;

import java.util.List;

@PlanningSolution
public class CourierSchedulingSolution {
    private List<Courier> couriers;
    private List<Zone> zones;
    private List<ZoneVolume> volumes;
    private BendableScore score;

    public CourierSchedulingSolution() {
    }

    @PlanningEntityCollectionProperty
    public List<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Courier> couriers) {
        this.couriers = couriers;
    }

    @PlanningEntityCollectionProperty
    @ValueRangeProvider(id = "zones")
    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    @ProblemFactCollectionProperty
    public List<ZoneVolume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<ZoneVolume> volumes) {
        this.volumes = volumes;
    }

    @PlanningScore(bendableHardLevelsSize = 2, bendableSoftLevelsSize = 1)
    public BendableScore getScore() {
        return score;
    }

    public void setScore(BendableScore score) {
        this.score = score;
    }
}
