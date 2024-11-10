package pl.poleq.pixdogfight.entity;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import pl.poleq.pixdogfight.entity.data.Size;

@Getter
@Setter
public class DestroyableEntity extends Entity {
    private final int MAX_HP;

    private int hp;

    public DestroyableEntity(TextureAtlas.AtlasRegion texture, Vector2 location, Size size, float rotation, int MAX_HP, int hp) {
        super(texture, location, size, rotation);
        this.MAX_HP = MAX_HP;
        this.hp = hp;
    }

    public DestroyableEntity(TextureAtlas.AtlasRegion texture, Vector2 location, int MAX_HP, int hp) {
        super(texture, location);
        this.MAX_HP = MAX_HP;
        this.hp = hp;
    }
}
