package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn = false;

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public int read() throws IllegalStateException {
        if (!this.isOn()) {
            throw new IllegalStateException("Temperature sensor not on");
        }
        return new Random().nextInt(61) - 30;
    }

}
