package application;

public class StandardSensor implements Sensor {
    private int number;

    public StandardSensor(int number) {
        this.number = number;
    }

    @Override
    public int read() {
        return number;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        
    }

    @Override
    public void setOff() {
        
    }
}
