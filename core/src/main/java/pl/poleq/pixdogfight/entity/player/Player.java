package pl.poleq.pixdogfight.entity.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import pl.poleq.pixdogfight.entity.plane.Plane;
import pl.poleq.pixdogfight.entity.plane.PlaneEquipment;

@Getter
public class Player extends Plane {
    private final String username;
    @Setter
    private boolean aerialSmoke;

    public Player(TextureAtlas.AtlasRegion texture, Vector2 location, int MAX_HP, int hp, float MAX_SPEED, float MAX_THRUST, float weight, PlaneEquipment equipment, float dragCoefficient, float wingArea, float liftCoefficient, String username) {
        super(texture, location, MAX_HP, hp, MAX_SPEED, MAX_THRUST, weight, equipment, dragCoefficient, wingArea, liftCoefficient);
        this.username = username;
        this.aerialSmoke = true;
    }

    public void drawTail(Pixmap pixmap) {
        if(aerialSmoke) {
            Vector2 tailLoc = getTailLocation();
            pixmap.drawPixel((int) tailLoc.x, (int) tailLoc.y,0xffff00aa);
        }
    }
}
