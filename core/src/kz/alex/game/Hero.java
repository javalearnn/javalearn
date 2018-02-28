package kz.alex.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
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
    Rectangle rectangle;
    private int hp, Maxhp;
    public int score;
    private int heal;
    public boolean alive()
    {return hp > 0;}
    public int getHp(){ return hp; }
    private int keyUp,keyDown,keyRight,keyLeft,keyFire;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getScore() {
        return score;
    }
    public void addScore(int n) { score +=n;}

    public Hero(int keyUp, int keyDown, int keyLeft,int keyRight,int keyFire) {

        this.position = new Vector2(100, 328);
        this.texture = new Texture("ship64x74.png");
        this.rectangle= new Rectangle(position.x, position.y, 64, 74);
        this.textureHpBar = new Texture("hpBar.png");
        this.speed = 10.0f;

        this.Maxhp = 10;
        this.hp = Maxhp;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyFire = keyFire;
        this.fireRate = 8;


    }


    public void setHp(int hp) {
        this.hp = hp;
    }

    public void takeDamage(int dmg)
    {
        hp -=dmg;

    }
    public void takeHeal(int heal)
    {
        hp += heal;
        if (hp > Maxhp)
        {
            hp = Maxhp;
        }
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
        if (Gdx.input.isKeyPressed(keyUp))position.y += speed;
        if (Gdx.input.isKeyPressed(keyDown))position.y -= speed;
        if (Gdx.input.isKeyPressed(keyLeft))position.x -= speed;
        if (Gdx.input.isKeyPressed(keyRight))position.x += speed;
        if (position.x < 0) position.x = 0;
        if (position.x > 1230) position.x = 1230;
        if (position.y < 0) position.y = 720;
        if (position.y > 720) position.y = 0;
        else if (!alive())
        {
            position.x =100;
            position.y = 328;

        }


        if (Gdx.input.isKeyPressed(keyFire)) {
            fireCounter++;
            if (fireCounter >= fireRate) {
                fireCounter = 0;
                fire();
            }
        }
        rectangle.setPosition(position);

    }

    private void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].active) {
                MyGdxGame.bullets[i].activate(position.x +65, position.y + 34);
                break;
            }
        }
    }

}