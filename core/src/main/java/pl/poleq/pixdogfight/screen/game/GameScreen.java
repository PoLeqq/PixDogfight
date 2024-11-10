package pl.poleq.pixdogfight.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import pl.poleq.pixdogfight.Main;
import pl.poleq.pixdogfight.entity.plane.Plane;
import pl.poleq.pixdogfight.entity.plane.PlaneEquipment;
import pl.poleq.pixdogfight.entity.player.Player;
import pl.poleq.pixdogfight.map.Location;
import pl.poleq.pixdogfight.screen.game.gui.GameGUI;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameScreen implements Screen {
    private SpriteBatch batch;
    private GameGUI gui;

    private Player player;
    private final List<Plane> enemies;
    private final Main main;

//    640, 480 (window)
    private final OrthographicCamera gameCamera;
    private final OrthographicCamera guiCamera;

    public GameScreen(Main main) {
        this.main = main;
        this.gui = new GameGUI(this);

        this.gameCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        this.gameCamera.setToOrtho(false);
        this.guiCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        this.guiCamera.setToOrtho(false);

        PlaneEquipment enemyEquipment = new PlaneEquipment(100,2,1);
        PlaneEquipment playerEquipment = new PlaneEquipment(1000,8,10);

        this.player = new Player(main.getGameAssets().getJetAtlas().findRegion("jet1"),
            new Vector2(50,50),100,100, 80, 40, playerEquipment,
            "PoLeq");

        this.enemies = new ArrayList<>();
        enemies.add(new Plane(main.getGameAssets().getJetAtlas().findRegion("jet_enemy"),
            new Vector2(0,0), 100, 100, 50, 20, enemyEquipment));
        enemies.add(new Plane(main.getGameAssets().getJetAtlas().findRegion("jet_enemy"),
            new Vector2(200,400), 100, 100, 50, 20, enemyEquipment));
        enemies.add(new Plane(main.getGameAssets().getJetAtlas().findRegion("jet_enemy"),
            new Vector2(500,200), 100, 100, 50, 20, enemyEquipment));

    }

    @Override
    public void show() {
        batch = new SpriteBatch();

//        jetSprite.setBounds(0,0,54,18);


//        set player position
//        player.getSprite().setX((float) Gdx.graphics.getWidth()/2);
//        player.getSprite().setY((float) Gdx.graphics.getHeight()/2);

        Gdx.input.setInputProcessor(new GameInputHandler(this));
        Gdx.gl.glClearColor(0,0,0,1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        updates
        this.frameUpdate(delta);

//        render game
        batch.setProjectionMatrix(gameCamera.combined);
        batch.begin();

        enemies.forEach(e -> e.getSprite().draw(batch));
        player.getSprite().draw(batch);

        batch.end();


//        render GUI
        batch.setProjectionMatrix(guiCamera.combined);
        batch.begin();

        gui.render(batch);

        batch.end();
    }

    public void frameUpdate(float delta) {
        Location loc = player.getLocation();
        loc.setX(loc.getX() + player.getSpeed()*delta);
        loc.setY(loc.getY() + player.getSpeed()/2*delta);
        loc.setRotation(loc.getRotation()+delta*50);

//        player.getSprite().setX();


        gameCamera.position.x = player.getLocation().getX();
        gameCamera.position.y = player.getLocation().getY();
        gameCamera.update();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
        System.out.println("resume");
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
