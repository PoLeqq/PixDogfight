package pl.poleq.pixdogfight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import lombok.Getter;
import pl.poleq.pixdogfight.screen.StartScreen;
import pl.poleq.pixdogfight.screen.game.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Getter
    private GameAssets gameAssets;
    @Getter
    private Skin uiSkin;

    private SpriteBatch batch;


    @Override
    public void create() {
        gameAssets = new GameAssets();
        uiSkin = new Skin(Gdx.files.internal("ui/uiskin.json"));


        batch = new SpriteBatch();
//        sprite = new Sprite(gameAssets.getJetAtlas().findRegion("jet1"));

//        rwr();

        showGameScreen();
    }

    @Override
    public void render() {
        super.render();
//        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
//        batch.begin();
//        batch.draw(sprite, 140, 210);
//        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
//        sprite.dispose();
    }

    private void rwr() {
        gameAssets.getRwrLock().play();
        new Thread(() -> {
            try {
                Thread.sleep(3190);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gameAssets.getRwrMissileLaunch().play();
        }).start();
    }

    public void showStartScreen() {
        setScreen(new StartScreen(this));
    }

    public void showGameScreen() {
        setScreen(new GameScreen(this));
    }
}
