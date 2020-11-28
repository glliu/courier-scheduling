package app;

import domain.Courier;
import domain.CourierSchedulingSolution;
import domain.Zone;
import domain.ZoneVolume;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourierSchedulingApp {
    private static final Logger logger = LoggerFactory.getLogger(CourierSchedulingApp.class);

    private List<Courier> couriers;
    private List<Zone> zones;
    private List<ZoneVolume> volumes;

    public CourierSchedulingApp() {
    }

    public List<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Courier> couriers) {
        this.couriers = couriers;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public List<ZoneVolume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<ZoneVolume> volumes) {
        this.volumes = volumes;
    }

    public CourierSchedulingSolution run() {
        CourierSchedulingSolution problem = new CourierSchedulingSolution();
        problem.setCouriers(couriers);
        problem.setZones(zones);
        problem.setVolumes(volumes);

        SolverFactory<CourierSchedulingSolution> solverFactory = SolverFactory.createFromXmlResource("courierscheduling/CourierSchedulingSolverConfig.xml", getClass().getClassLoader());
        Solver<CourierSchedulingSolution> solver = solverFactory.buildSolver();
        CourierSchedulingSolution solution = solver.solve(problem);

        if (solution.getScore().isFeasible()) {
            logger.info("Courier scheduling solved. Score = {}", solution.getScore().toShortString());
        } else {
            logger.warn("Unable to find a feasible solution. The best solution found has score = {}", solution.getScore().toShortString());
        }

        return solution;
    }
}
