package kz.alex.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import kz.alex.game.Const;

public class Loot extends AbstractObject {

    private Rectangle rectangle;
    float chance;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Loot() {
        this.texture = new Texture(Const.HEAL);
        this.position = new Vector2(0, 0);
        this.active = false;
        rectangle = new Rectangle(position.x, position.y, 32, 32);

    }

    public void recreate() {
        this.position.x = MathUtils.random(720, 1280);
        this.position.y = MathUtils.random(370);
        rectangle.setSize(32, 32);
        speed = 3;
        active = false;
    }
      public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
    public void update() {
        this.position.x -= speed;
        if (this.position.x < -20) {
            disable();
        }

        rectangle.x = this.position.x;
        rectangle.y = this.position.y;

    }
}



