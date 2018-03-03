package kz.alex.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Loot extends AbstractObject {

    private Rectangle lootHp;
    float chance;

    public Rectangle getLootHp() {
        return lootHp;
    }

    public Loot() {
        this.texture = new Texture("heal32x32.png");
        this.position = new Vector2(0, 0);
        this.active = false;
        lootHp = new Rectangle(position.x, position.y, 32, 32);
    }

    public void recreate() {
        this.position.x = MathUtils.random(720, 1280);
        this.position.y = MathUtils.random(370);
        active = false;
        lootHp.setSize(32, 32);
    }

    public void update() {
        speed = 3;
        active = true;
        position.x -= speed;
        if (position.x < -20) {
            disable();
        }

        lootHp.x = position.x;
        lootHp.y = position.y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
}
