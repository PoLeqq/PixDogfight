package pl.poleq.pixdogfight.entity.plane.weapon;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import pl.poleq.pixdogfight.entity.Entity;

public class BulletEntity extends Entity {
    public BulletEntity(TextureAtlas.AtlasRegion texture, Vector2 location) {
        super(texture, location);
    }
}
