package domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.time.LocalDate;
import java.util.Objects;

@PlanningEntity
public class Courier {
    private String id;
    private LocalDate date;
    private Zone zone;
    private int collectNum;
    private int deliverNum;
    private int collectPrice;
    private int deliverPrice;

    public Courier() {
    }

    public Courier(String id, LocalDate date, Zone zone, int collectNum, int deliverNum, int collectPrice, int deliverPrice) {
        this.id = id;
        this.date = date;
        this.zone = zone;
        this.collectNum = collectNum;
        this.deliverNum = deliverNum;
        this.collectPrice = collectPrice;
        this.deliverPrice = deliverPrice;
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

    @PlanningVariable(valueRangeProviderRefs = "zones")
    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
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

    public int getCollectPrice() {
        return collectPrice;
    }

    public void setCollectPrice(int collectPrice) {
        this.collectPrice = collectPrice;
    }

    public int getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(int deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courier courier = (Courier) o;
        return collectNum == courier.collectNum &&
                deliverNum == courier.deliverNum &&
                collectPrice == courier.collectPrice &&
                deliverPrice == courier.deliverPrice &&
                id.equals(courier.id) &&
                date.equals(courier.date) &&
                zone.equals(courier.zone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, zone, collectNum, deliverNum, collectPrice, deliverPrice);
    }
}
