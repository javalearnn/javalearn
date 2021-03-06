package kz.alex.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import kz.alex.game.objects.AbstractObject;
import com.badlogic.gdx.Input.Keys;

import java.text.MessageFormat;



public class Hero extends AbstractObject {

    private int fireCounter;
    private int fireRate;
    private Rectangle rectangle;
    private int hp, maxHp;
    private int score;
    private int coinScore;

    public Rectangle getRectangle() {
        return rectangle;
    }
    public int getScore() {
        return score;
    }
    public void addScore(int n) {
        score += n;
    }
    public int getHp() {
        return hp;
    }
    public int getCoinScore() {
        return coinScore;
    }
    public void addCoinScore(int i) {
        this.coinScore += i;
    }
    public Hero() {
        this.position = new Vector2(100, 328);
        this.texture = new Texture(Const.HERO);
        this.rectangle = new Rectangle(position.x, position.y, 64, 74);
        this.speed = 5.0f;

        this.maxHp = 10;
        this.hp = maxHp;
        this.fireRate = 8;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
    }

    public void takeHeal(int heal) {

        System.out.println("Current health " + hp);
                // форматированный лог
        System.out.println(MessageFormat.format("Current health [{0}]", hp));
                // форматированный со стрингом
        System.out.println(String.format("Current health [%d]", hp));
        hp += heal;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }



    public void update() {
        if (alive()) {
            if (isControlPressed(Keys.W, Keys.UP)) position.y += speed;
            if (isControlPressed(Keys.S, Keys.DOWN)) position.y -= speed;
            if (isControlPressed(Keys.A, Keys.LEFT)) position.x -= speed;
            if (isControlPressed(Keys.D, Keys.RIGHT)) position.x += speed;

            position.x = position.x < 0 ? 0 : position.x;
            position.x = position.x > 1230 ? 1230 : position.x;
            position.y = position.y < 0 ? 0 : position.y;
            position.y = position.y > 720-74 ?720-74  : position.y;

            if (Gdx.input.isKeyPressed(Keys.SPACE)) {
                fireCounter++;
                if (fireCounter >= fireRate) {
                    fireCounter = 0;
                    fire();
                }
            }
            rectangle.setPosition(position);
        } else if (!alive()) {
            position.x = 100;
            position.y = 328;
        }
    }

    private boolean isControlPressed(int... controls) {
        for (int control : controls) {
            if (Gdx.input.isKeyPressed(control)) {
                return true;
            }
        }
        return false;
    }

    private void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].active) {
                MyGdxGame.bullets[i].activate(position.x + 65, position.y + 34);
                break;
            }
        }
    }

    public boolean alive() {
        return hp > 0;
    }

}