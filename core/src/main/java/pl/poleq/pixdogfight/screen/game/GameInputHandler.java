package pl.poleq.pixdogfight.screen.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import pl.poleq.pixdogfight.entity.player.Player;

public class GameInputHandler extends InputAdapter {
    private GameScreen gameScreen;
    private Player player;

    public GameInputHandler(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.player = gameScreen.getPlayer();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W -> {
//                player.setThrottle();
            }
            default -> {
                System.out.println("default");
            }
        }


        return true;
    }
}
