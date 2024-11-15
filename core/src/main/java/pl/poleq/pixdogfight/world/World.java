package pl.poleq.pixdogfight.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class World {
    /**
     * Batch - map
     */
    private final SpriteBatch batch;

    /**
     * Mass of the world (affects gravity)
     */
    private float worldMass;
    /**
     * Gravity constant - usually 9.81
     */
    private float gravity;

    public World(float WORLD_MASS) {
        this.batch = new SpriteBatch();
        this.worldMass = WORLD_MASS;
        this.gravity = 9.81f;
    }
}
