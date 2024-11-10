package pl.poleq.pixdogfight.entity.player;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import pl.poleq.pixdogfight.entity.plane.Plane;
import pl.poleq.pixdogfight.entity.plane.PlaneEquipment;

@Getter
public class Player extends Plane {
    private final String username;

    public Player(TextureAtlas.AtlasRegion texture, Vector2 location, int MAX_HP, int hp, float MAX_SPEED, float speed, PlaneEquipment equipment, String username) {
        super(texture, location, MAX_HP, hp, MAX_SPEED, speed, equipment);
        this.username = username;
    }
}
