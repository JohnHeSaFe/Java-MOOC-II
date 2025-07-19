package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors = new ArrayList<>();
    private List<Integer> readings = new ArrayList<>();

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn()) {
                sensor.setOff();
                break;
            }
        }
    }

    @Override
    public int read() throws IllegalStateException {
        if (!this.isOn()) {
            throw new IllegalStateException("Average sensor is off");
        }
        if (sensors.size() == 0) {
            throw new IllegalStateException("There are no sensors added to this sensor");
        }
        int read = (int) sensors.stream().mapToInt(s -> s.read()).average().getAsDouble();
        readings.add(read);
        return read;
    }

    public List<Integer> readings() {
        return readings;
    }
}
