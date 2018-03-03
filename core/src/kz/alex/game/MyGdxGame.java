package kz.alex.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import kz.alex.game.objects.Asteroid;
import kz.alex.game.objects.Loot;


public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Background background;
    private Hero hero;
    private Asteroid[] asteroids;
    private Texture textureBullet;
    private Music music;
    private BitmapFont font;
    private Loot loot;
    public Vector2 CrushPosition;
    int chance;

    static Bullet[] bullets;

    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        hero = new Hero();
        asteroids = new Asteroid[20];
        loot = new Loot();
        font = new BitmapFont();
        font.setColor(2, 0, 5, 8);

        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }

        Loot loot = new Loot();
        textureBullet = new Texture("beams32x18.png");
        bullets = new Bullet[200];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }

        music = Gdx.audio.newMusic(Gdx.files.internal("GameMusic.mp3"));
        music.setLooping(true);
        music.play();
        music.setVolume(0.1f);
    }

    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.enableBlending();
        batch.begin();
        background.render(batch);
        hero.render(batch);
        if (loot.isActive()) loot.render(batch);
        hero.renderHUD(batch, font, 40, 680);

        if (hero.alive()) {
            font.draw(batch, "WASD - Move, SPACE - Fire", 500, 20);
            font.draw(batch, "HP: " + hero.getHp(), 220, 640);
        } else {
            music.stop();
            font.draw(batch, "PRESS ENTER TO RESTART", 500, 328);
            font.draw(batch, "YOUR SCORE: " + hero.getScore(), 530, 348);
        }

        for (Asteroid asteroid : asteroids) {
            if (asteroid.isActive()) asteroid.render(batch);
        }

        for (Bullet bullet : bullets) {
            if (bullet.active) {
                batch.draw(textureBullet, bullet.position.x - 32, bullet.position.y - 16);
            }
        }
        batch.end();
    }

    private void startNewGame() {
        hero = new Hero();
        music.play();
    }

    private void update() {
        hero.update();
        background.update();

        if (!loot.isActive())
            loot.recreate();
        else
            loot.update();


        for (Asteroid asteroid1 : asteroids) {
            if (!asteroid1.isActive()) {
                asteroid1.setup();
                break;
            } else {
                asteroid1.update();
            }
        }

        for (Asteroid asteroid : asteroids) {
            if (asteroid.getHitbox().overlaps(hero.getRectangle())) {
                hero.takeDamage(1);
                asteroid.setup();
            }
        }

        for (Bullet bullet : bullets) {
            if (bullet.active) {
                bullet.update();
                for (Asteroid asteroid : asteroids) {
                    if (asteroid.getHitbox().contains(bullet.position)) {
                        asteroid.takeDamage(1);
                        bullet.deactivate();

                        if (asteroid.getHp() <= 0) {
                            loot.setActive(true);
                            hero.addScore(10);
                            break;

                        }
                    }
                }
            }
        }


        if (hero.getRectangle().overlaps(loot.getLootHp()) && loot.isActive()) {
            hero.takeHeal(1);
            loot.disable();
        }

        if (hero.getHp() <= 0) {
            for (Asteroid asteroid : asteroids) {
                asteroid.setup();
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            if (hero.getHp() <= 0) startNewGame();
        }
    }

    public void dispose() {
        batch.dispose();
        music.dispose();
    }
}
