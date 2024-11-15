package pl.poleq.pixdogfight.map;

import com.badlogic.gdx.math.Vector2;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents location (fe. for object)
 */
@AllArgsConstructor
public abstract class Location {
    /**
     * Current position (x,y)
     */
    private final Vector2 position;
    /**
     * Clockwise rotation in degrees
     */
    @Getter
    private float rotation;

    public float getX() {
        return position.x;
    }

    public void setX(float x) {
        setPosition(x,position.y);
    }

    public void addVector(float x, float y) {
        setPosition(position.x + x, position.y + y);
    }

    public void setY(float y) {
        setPosition(position.x,y);
    }

    public float getY() {
        return position.y;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
        this.onLocationUpdate(getX(), getY(), rotation);
    }

    public void rotate(float degrees) {
        setRotation(this.rotation + degrees);
    }

    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
        this.onLocationUpdate(x,y,rotation);
    }

    public void setLocation(float x, float y, float rotation) {
        this.rotation = rotation;
        this.setPosition(x,y);
    }

    /**
     * Method, that is called when location values are changed
     * @param x x
     * @param y y
     * @param rotation rotation
     */
    public abstract void onLocationUpdate(float x, float y, float rotation);
}
