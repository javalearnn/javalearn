package kz.alex.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Loot {
    private Texture texture;
    private int speed;
    private Vector2 position;
    private boolean active;
    Rectangle loothp;
    float chance;

    public void setActive(boolean active) {
        this.active = active;
    }



    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getSpeed() {
        return speed;
    }

    public Loot()

    {

        this.texture = new Texture("heal32x32.png");
        this.position = new Vector2(0,0);
        this.active = false;
        loothp = new Rectangle(position.x, position.y , 32,32);


    }

    public void recreate()
    {
        this.position.x = MathUtils.random(720,1280);
        this.position.y = MathUtils.random(370);
        active = false;
        loothp.setSize(32,32);

    }

    public void update(){

         speed = 3;
         active = true;
        position.x -= speed;
        if (position.x < -20)
        {
            disable();

        }
        loothp.x = position.x;
        loothp.y = position.y;


    }

 public void render(SpriteBatch batch)
 {batch.draw(texture, position.x, position.y);}


 public void disable()
 {
     active = false;
 }

}
