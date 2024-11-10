package pl.poleq.pixdogfight.screen.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import pl.poleq.pixdogfight.entity.player.Player;

import java.util.HashMap;

public class GameInputHandler extends InputAdapter {
    private GameScreen gameScreen;
    private Player player;

    public GameInputHandler(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.player = gameScreen.getPlayer();
    }

    /**
     * Running threads:
     * <ul>
     *     <li>key - keycode</li>
     *     <li>value - thread id</li>
     * </ul>
     */
    HashMap<Integer,Thread> runningThreads = new HashMap<>();

    @Override
    public boolean keyDown(int keycode) {
        if(runningThreads.containsKey(keycode))
            return true;

        Thread t = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    switch (keycode) {
                        case Input.Keys.W -> player.changeThrottle(1);
                        case Input.Keys.S -> player.changeThrottle(-1);
                        case Input.Keys.A -> player.getLocation().rotate(1);
                        case Input.Keys.D -> player.getLocation().rotate(-1);
                    }
                    Thread.sleep(25);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t.start();
        runningThreads.put(keycode, t);

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        Thread t = runningThreads.remove(keycode);
        if(t != null)
            t.interrupt();

        return true;
    }
}
