package domain;

import org.optaplanner.core.api.domain.solution.cloner.DeepPlanningClone;

import java.util.Objects;

@DeepPlanningClone
public class ZoneVolume {
    private int collectNum;
    private int deliverNum;
    private Zone zone;

    public ZoneVolume() {
    }

    public ZoneVolume(int collectNum, int deliverNum) {
        this.collectNum = collectNum;
        this.deliverNum = deliverNum;
    }

    public ZoneVolume(int collectNum, int deliverNum, Zone zone) {
        this.collectNum = collectNum;
        this.deliverNum = deliverNum;
        this.zone = zone;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public int getDeliverNum() {
        return deliverNum;
    }

    public void setDeliverNum(int deliverNum) {
        this.deliverNum = deliverNum;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoneVolume that = (ZoneVolume) o;
        return collectNum == that.collectNum &&
                deliverNum == that.deliverNum &&
                zone.equals(that.zone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectNum, deliverNum, zone);
    }
}
