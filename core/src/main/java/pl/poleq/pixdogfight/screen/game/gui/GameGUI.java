package pl.poleq.pixdogfight.screen.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import pl.poleq.pixdogfight.entity.plane.PlaneEquipment;
import pl.poleq.pixdogfight.entity.player.Player;
import pl.poleq.pixdogfight.screen.game.GameScreen;

public class GameGUI {
    private GameScreen screen;
    private final BitmapFont font;

    private final int WIDTH = Gdx.graphics.getWidth();
    private final int HEIGHT = Gdx.graphics.getHeight();

    public GameGUI(GameScreen screen) {
        this.screen = screen;

//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("m5x7.ttf"));
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("victor-pixel.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35;

        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render(SpriteBatch batch) {
        Player player = screen.getPlayer();
        PlaneEquipment eq = player.getEquipment();

        font.draw(batch, String.format("PLT: %s",screen.getPlayer().getUsername()),20,HEIGHT-20);
        font.draw(batch, String.format("THR: %d",player.getThrottle()),20,HEIGHT-60);
        font.draw(batch, String.format("SPD: %.2f",player.getSpeed()),20,HEIGHT-60);
        font.draw(batch, String.format("ALT: %.1f",player.getLocation().getY()),20,HEIGHT-100);
        font.draw(batch, String.format("GUN: %d",eq.getAmmo()),50,200);
        font.draw(batch, String.format("MSLE: %d",eq.getMissiles()),50,250);
        font.draw(batch, String.format("COUN: %d",eq.getCountermeasures()),50,300);
    }
}
