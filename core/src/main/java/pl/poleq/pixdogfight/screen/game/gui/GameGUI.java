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

    float gameTime = 0;

    public GameGUI(GameScreen screen) {
        this.screen = screen;
        this.gameTime = 0;

//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("m5x7.ttf"));
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("victor-pixel.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 25;

        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render(SpriteBatch batch, float delta) {
        gameTime += delta;

        Player player = screen.getPlayer();
        PlaneEquipment eq = player.getEquipment();

        int col = 0;
        font.draw(batch, String.format("PLT: %s",screen.getPlayer().getUsername()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("TIME: %s",getTimeStringified()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("THR: %d%%",player.getThrottleTarget()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("ETHR: %d%%",player.getThrottleTarget()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("SPD: %.0f",player.getSpeed()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("THRUST: %.2f",player.getThrust()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("ACC: %.2f",player.getAcceleration()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("ALT: %.0f",player.getLocation().getY()),getLabelX(0),getLabelY(col++));

        col+=2;
        font.draw(batch, String.format("GUN: %d",eq.getAmmo()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("MSLE: %d",eq.getMissiles()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("COUN: %d",eq.getCountermeasures()),getLabelX(0),getLabelY(col++));

        col+=2;
        font.draw(batch, String.format("X: %.0f",player.getLocation().getX()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("Y: %.0f",player.getLocation().getY()),getLabelX(0),getLabelY(col++));
        font.draw(batch, String.format("R: %.2f",player.getLocation().getRotation()),getLabelX(0),getLabelY(col++));
    }

    private int getLabelY(int column) {
        return HEIGHT - 20 - column * 25;
    }

    private int getLabelX(int row) {
        return 20 + row * 200;
    }

    private String getTimeStringified() {
        int minutes = 0;
        int seconds = 0;
        float time = gameTime;

        while(time >= 60) {
            time -= 60;
            minutes++;
        }
        while(time >= 1) {
            time -= 1;
            seconds++;
        }

        return String.format("%02d:%02d", minutes, seconds);
    }
}
