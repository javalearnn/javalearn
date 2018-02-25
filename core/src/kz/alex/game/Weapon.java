package kz.alex.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.time.temporal.Temporal;

public class Weapon {

    private int fireRate;
    private int fireCouner;
    private Vector2 slotPosition;
    private Texture texture;
    private Sound sound;
    private Hero owner;


    public Weapon(Hero owner, Vector2 slotPosition){
        this.owner = owner;
        this.slotPosition = slotPosition;
        this.fireRate = 6;
        this.sound = Gdx.audio.newSound(Gdx.files.internal("fr2.wav"));

    }
    public void use() {
        fireCouner++;
        if (fireCouner >= fireRate) {
            fire(0, 0, 720, 0);

            sound.play(1);
        }
    }
    public void fire (float dx, float dy, float vx,float vy){
        //BulletEmitter.getInstance().setupAmmo(owner, slotPosition.x + 24 + dx, slotPosition.y + 8 + dy, vx, vy);
    }
}
