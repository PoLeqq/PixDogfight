package pl.poleq.pixdogfight.entity.plane;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import pl.poleq.pixdogfight.entity.DestroyableEntity;

@Getter
@Setter
public class Plane extends DestroyableEntity {
    private final float MAX_SPEED;
    private int throttle;
    private float speed;
    private PlaneEquipment equipment;

    public Plane(TextureAtlas.AtlasRegion texture, Vector2 location, int MAX_HP, int hp, float MAX_SPEED, float speed, PlaneEquipment equipment) {
        super(texture, location, MAX_HP, hp);
        this.MAX_SPEED = MAX_SPEED;
        this.throttle = 100;
        this.speed = speed;
        this.equipment = equipment;
    }

    public void incrementThrottle(int value) {
        this.throttle += value;
        if(this.throttle > 100)
            this.throttle = 100;
    }

    public void decrementThrottle(int value) {
        this.throttle -= value;
        if(this.throttle < 0)
            this.throttle = 0;
    }
}
