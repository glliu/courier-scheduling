package app;

import domain.Courier;
import domain.CourierSchedulingSolution;
import domain.Zone;
import domain.ZoneVolume;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourierSchedulingAppTest {

    @org.junit.jupiter.api.Test
    void run() {
        Courier courier = new Courier("courier1", LocalDate.now(), null, 10, 10, 1, 1);
        ZoneVolume volume = new ZoneVolume(10, 10);
        Zone zone = new Zone("zone1", LocalDate.now(), volume);
        volume.setZone(zone);

        CourierSchedulingApp app = new CourierSchedulingApp();
        app.setCouriers(new ArrayList<Courier>(){{add(courier);}});
        app.setZones(new ArrayList<Zone>(){{add(zone);}});
        app.setVolumes(new ArrayList<ZoneVolume>(){{add(volume);}});

        CourierSchedulingSolution solution = app.run();
        assertTrue(solution.getScore().isFeasible());
    }
}