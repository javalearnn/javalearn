package kz.alex.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import kz.alex.game.Const;

public class Asteroid extends AbstractObject {

    private int hp;
    private int Maxhp;
    public int getHp() {
        return hp;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }

    public Asteroid() {
        this.texture = new Texture(Const.ASTEROID);
        this.position = new Vector2(0, 0);
        this.active = false;

        rectangle = new Rectangle(position.x, position.y, 64, 57);
    }

    public void setup() {
        position.x = (float) Math.random() * 1280 + 1280;
        position.y = (float) Math.random() * 720;
        speed = MathUtils.random(3, 10);
        Maxhp = 3;
        hp = Maxhp;
        rectangle.setSize(64, 57);
        active = true;
        }

    public void render(SpriteBatch batch) {
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

        rectangle.x = position.x;
        rectangle.y = position.y;

    }
}
