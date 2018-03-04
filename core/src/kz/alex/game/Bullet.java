package kz.alex.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

class Bullet {
    Vector2 position; // coords x coors y
    private float speed;
    boolean active;
    private Sound sound;

    Bullet() {
        position = new Vector2(0, 0);
        speed = 14;
        active = false;
        sound = Gdx.audio.newSound(Gdx.files.internal(Const.BULLETSOUD));
    }


    public void activate(float x, float y) {
        position.set(x, y);
        active = true;
        sound.play(0.1f, 1, 0);
    }

    public void deactivate() {
        active = false;
    }


    public void update() {
        position.x += speed;
        if (position.x > 1280) {
            deactivate();
        }
    }
}
