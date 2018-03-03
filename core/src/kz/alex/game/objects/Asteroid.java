package kz.alex.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends AbstractObject {

    private int hp;
    private int Maxhp;
    private Rectangle hitbox;
    private float size;
    Loot loot;

    public int getHp() {
        return hp;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Asteroid() {
        this.texture = new Texture("Asteroid64x57.png");
        this.position = new Vector2(0, 0);
        this.active = false;

        hitbox = new Rectangle(position.x, position.y, 64, 57);
    }

    public void setup() {
        position.x = (float) Math.random() * 1280 + 1280;
        position.y = (float) Math.random() * 720;
        speed = MathUtils.random(3, 10);
        Maxhp = 3;
        hp = Maxhp;
        hitbox.setSize(64, 57);
        active = true;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
        batch.draw(texture, position.x, position.y);
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            disable();
        }
    }

    public void update() {
        position.x -= speed;
        if (position.x < -200) {
            disable();
        }

        hitbox.x = position.x;
        hitbox.y = position.y;
    }
}












