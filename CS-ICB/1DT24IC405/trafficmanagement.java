import java.util.Timer;
import java.util.TimerTask;

public class TrafficManagementSystem {

    // Enum for traffic light states
    enum LightState {
        RED, YELLOW, GREEN
    }

    // Class representing the traffic light
    static class TrafficLight {
        private LightState state;

        public TrafficLight() {
            this.state = LightState.RED;  // Initial state is RED
        }

        public LightState getState() {
            return state;
        }

        public void changeState(LightState state) {
            this.state = state;
            System.out.println("Traffic Light is now: " + state);
        }
    }

    // Class representing a Vehicle
    static class Vehicle {
        private String vehicleId;
        private boolean isMoving;

        public Vehicle(String vehicleId) {
            this.vehicleId = vehicleId;
            this.isMoving = false;
        }

        public void stop() {
            this.isMoving = false;
            System.out.println(vehicleId + " has stopped.");
        }

        public void go() {
            this.isMoving = true;
            System.out.println(vehicleId + " is moving.");
        }
    }

    // Main class for traffic light management
    public static void main(String[] args) {
        // Initialize Traffic Light
        TrafficLight trafficLight = new TrafficLight();

        // Initialize some vehicles
        Vehicle vehicle1 = new Vehicle("Vehicle 1");
        Vehicle vehicle2 = new Vehicle("Vehicle 2");

        // Simulate traffic light cycles using Timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                switch (trafficLight.getState()) {
                    case RED:
                        trafficLight.changeState(LightState.GREEN);
                        vehicle1.go();
                        vehicle2.go();
                        break;
                    case GREEN:
                        trafficLight.changeState(LightState.YELLOW);
                        vehicle1.stop();
                        vehicle2.stop();
                        break;
                    case YELLOW:
                        trafficLight.changeState(LightState.RED);
                        break;
                }
            }
        }, 0, 3000); // Change light state every 3 seconds (3000 ms)

        // Give the simulation some time to run
        try {
            Thread.sleep(20000);  // Run the simulation for 20 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the timer after the simulation
        timer.cancel();
        System.out.println("Traffic Management Simulation Ended.");
    }
}
