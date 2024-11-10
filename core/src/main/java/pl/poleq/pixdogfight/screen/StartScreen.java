package pl.poleq.pixdogfight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.poleq.pixdogfight.Main;

/** First screen of the application. Displayed after the application is created. */
public class StartScreen implements Screen {
    private SpriteBatch batch;
    private Sprite jetSprite;
    private Main main;

    //    640, 480 (window)
    private OrthographicCamera camera;

    public StartScreen(Main main) {
        this.main = main;
    }

    @Override
    public void show() {
        System.out.println("show");
        batch = new SpriteBatch();

//        Gdx.input.setInputProcessor();

        jetSprite = new Sprite(main.getGameAssets().getJetAtlas().findRegion("jet1"));
//        jetSprite.setBounds(-26,-9,54,18);
        jetSprite.setBounds(0,0,54,18);
        (camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight())).setToOrtho(false);
//        camera = new OrthographicCamera(70,40);

    }

    @Override
    public void render(float delta) {
        System.out.println("delta:"+delta);

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        jetSprite.draw(batch);

        camera.position.x--;
        camera.position.y--;
        camera.update();

        batch.end();



//        System.out.println(delta);
        // Draw your screen here. "delta" is the time since last render in seconds.
    }

    //    private Main main;
//
//    private SpriteBatch batch;
//    private Sprite jet;
//
//    private OrthographicCamera camera;
//
//
//    public StartScreen(Main main) {
//        this.main = main;
//
//
////        this.playButton.addListener(new ClickListener() {
////            @Override
////            public void clicked(InputEvent event, float x, float y) {
////                main.setScreen(main.getGameScreen());
////            }
////        });
//    }
//
//    @Override
//    public void show() {
//        this.batch = new SpriteBatch();
////
//        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//        this.camera.setToOrtho(false);
////
////        this.playButton = new TextButton("Play", main.getUiSkin());
////        this.playButton.setBounds(0,0,100,100);
//        this.jet = new Sprite(main.getGameAssets().getJetAtlas().findRegion("jet1"));
//        this.jet.setBounds(0,0,50,50);
//
////        this.button = new Button(main.getUiSkin());
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0,0,0,1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        batch.setProjectionMatrix(camera.combined);
//
//        batch.begin();
//
////        playButton.draw(batch,.5f);
//        jet.draw(batch);
//
//        batch.end();
//    }

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
    }

    @Override
    public void hide() {
        System.out.println("hide");
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
