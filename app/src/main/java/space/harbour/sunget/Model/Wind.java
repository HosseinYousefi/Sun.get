package space.harbour.sunget.Model;

public class Wind {
    int chill;
    int direction;
    Speed speed;

    public Wind(int chill, int direction, Speed speed) {
        this.chill = chill;
        this.direction = direction;
        this.speed = speed;
    }

    public int getChill() {
        return chill;
    }

    public void setChill(int chill) {
        this.chill = chill;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
}
