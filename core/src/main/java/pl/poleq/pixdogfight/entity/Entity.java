package pl.poleq.pixdogfight.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import pl.poleq.pixdogfight.entity.data.Size;
import pl.poleq.pixdogfight.map.Location;

@Getter
public class Entity {
    private final Sprite sprite;
    /**
     * Obrót (w stopniach; zgodny z ruchem wskazówek zegara)
     */
    private final Location location;
    private final Size size;

    public Entity(TextureAtlas.AtlasRegion texture, Vector2 location, Size size, float rotation) {
        this.sprite = new Sprite(texture);
        this.sprite.setSize(size.getWidth(), size.getHeight());
        this.location = new Location(location,rotation) {
            @Override
            public void onLocationUpdate(float x, float y, float rotation) {
                sprite.setPosition(x,y);
                sprite.setRotation(rotation);
            }
        };
//        this.sprite.setX(location.x);
//        this.sprite.setY(location.y);

        this.size = size;
    }

    public Entity(TextureAtlas.AtlasRegion texture, Vector2 location) {
        this(texture, location, new Size(texture.getRegionWidth(), texture.getRegionHeight()), 0);
    }
}
