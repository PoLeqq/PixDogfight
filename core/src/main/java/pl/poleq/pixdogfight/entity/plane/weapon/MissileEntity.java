package pl.poleq.pixdogfight.entity.plane.weapon;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import pl.poleq.pixdogfight.entity.Entity;
import pl.poleq.pixdogfight.entity.data.Size;

public class MissileEntity extends Entity {
    private float MAX_SPEED;
    private float MAX_OVERLOAD;

    private float speed;
    private float acceleration;

    public MissileEntity(TextureAtlas.AtlasRegion texture, Vector2 location, Size size, float rotation) {
        super(texture, location, size, rotation);
    }
}
