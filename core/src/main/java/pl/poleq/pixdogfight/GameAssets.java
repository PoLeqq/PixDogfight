package pl.poleq.pixdogfight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import lombok.Getter;

@Getter
public class GameAssets {
    private final TextureAtlas jetAtlas;

    private final Sound rwrLock;
    private final Sound rwrMissileLaunch;
    private final Sound chaffFlare;

    public GameAssets() {
        this.jetAtlas = new TextureAtlas("atlas/jet_atlas.atlas");

        this.chaffFlare = Gdx.audio.newSound(Gdx.files.internal("sound/chaff-flare.mp3"));
        this.rwrLock = Gdx.audio.newSound(Gdx.files.internal("sound/rwr/rwr-lock.mp3"));
        this.rwrMissileLaunch = Gdx.audio.newSound(Gdx.files.internal("sound/rwr/rwr-missile.mp3"));
    }
}
