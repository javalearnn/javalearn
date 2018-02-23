import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    Vector2 position;
    Texture texture;
    float speed;
    Rectangle hitBox;


    public Asteroid() {
        texture = new Texture("Asteroid.png");
        position = new Vector2(MathUtils.random(1280,2560), MathUtils.random(0, 720));
        speed = MathUtils.random(3,6);
        hitBox = new Rectangle(position.x, position.y, 120,84);
    }
   public void render(SpriteBatch batch)
   {
       batch.draw(texture, position.x, position.y);
   }
    public void update() {
        position.x -= speed;
        if (position.x < -200)
        {
            position.x = 1280;
            position.y = MathUtils.random(0,720);
            speed = MathUtils.random(3,6);
            recreate();
        }
        hitBox.setPosition(position);




    }
    public void recreate()
    {
        position.x = MathUtils.random(1280,2560);
        position.y = MathUtils.random(0,720);
        speed = MathUtils.random(3,6);

    }

}