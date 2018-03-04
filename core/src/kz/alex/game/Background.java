package kz.alex.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {


    class Star {
        // coordinates x and y
        Vector2 position;
        float speed;

        Star() {
            position = new Vector2(MathUtils.random(0, 1280), MathUtils.random(0, 720));
            speed = MathUtils.random(0.5f, 3.0f);
        }

        void update() {
            position.x -= speed;
            if (position.x < -20) {
                position.x = 1280;
                position.y = MathUtils.random(0, 720);
                speed = MathUtils.random(0.5f, 3.0f);
            }
        }
    }

    private Texture texture;
    private Texture textureStar;
    private Star[] stars;
    public MyGdxGame myGame;
    public SpriteBatch batch;

   public Background(MyGdxGame myGame, SpriteBatch batch) {
       this.myGame = myGame;
       this.batch = batch;


        texture = new Texture(Const.BACKGROUND);
        textureStar = new Texture(Const.STAR);
        stars = new Star[240];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
        for (Star star : stars) {
            batch.draw(textureStar, star.position.x, star.position.y);
        }
    }

    public void update() {
        for (Star star : stars) {
            star.update();
        }
    }
}
