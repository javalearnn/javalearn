package kz.alex.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero {

    private Vector2 position;
    private Texture texture;
    private Texture textureHpBar;
    private float speed;
    private int fireCounter;
    private int fireRate;
    Rectangle hitBox;
    private int hp, Maxhp;
    private int score;
    public boolean alive()
    {return hp > 0;}
    public int getHp(){ return hp; }

    public int getScore() {
        return score;
    }
    public void addScore(int n) { score +=n;}

    public Hero() {

        position = new Vector2(100, 328);
        texture = new Texture("Ship.png");
        textureHpBar = new Texture("hpBar.png");
        speed = 10.0f;
        fireCounter = 0;
        fireRate = 8;
        hitBox = new Rectangle(position.x, position.y, 120, 84);
        Maxhp = 10;
        hp = Maxhp;

    }
    public void takeDamage(int dmg)
    {
        hp -=dmg;

    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture, position.x, position.y);
    }

    public void renderHUD(SpriteBatch batch, BitmapFont font, int x,int y) {
        font.draw(batch, "Score: " + score, x + 20, y);
        batch.draw(textureHpBar, x, y - 35, 0,0, 200, 20);
        batch.draw(textureHpBar, x, y - 35, 0, 20,200*hp/10, 20);

    }

    public void update() {

    if(alive())
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
        }
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX() < position.x + 32) {
                position.x -= speed;
            }
            if (Gdx.input.getX() > position.x + 32) {
                position.x += speed;
            }
            if (720 - Gdx.input.getY() < position.y + 32) {
                position.y -= speed;
            }
            if (720 - Gdx.input.getY() > position.y + 32) {
                position.y += speed;
            }

        }
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > 1230) {
            position.x = 1230;
        }
        if (position.y < 0) {
            position.y = 720;
        }
        if (position.y > 720) {
            position.y = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            fireCounter++;
            if (fireCounter >= 8) {
                fireCounter = 0;
                fire();
            }
        }
        hitBox.setPosition(position);

    }

    private void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].active) {
                MyGdxGame.bullets[i].activate(position.x + 48, position.y + 32);
                break;
            }
        }
    }
}