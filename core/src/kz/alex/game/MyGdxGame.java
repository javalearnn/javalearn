package kz.alex.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Background background;
    private Hero hero;
    private Asteroid[] asteroids;
    private Texture textureBullet;
    private Music music;

    static Bullet[] bullets;

    public void create() {
        batch = new SpriteBatch();
        background = new Background();
        hero = new Hero();
        asteroids = new Asteroid[20];

        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }

        textureBullet = new Texture("bullets.png");
        bullets = new Bullet[200];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }

        music = Gdx.audio.newMusic(Gdx.files.internal("GameMusic.mp3"));
        music.setLooping(true);
        music.play();
        music.setVolume(0.1f);
        music.setLooping(true);
    }


    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        hero.render(batch);
        for (Asteroid asteroid : asteroids) {
            asteroid.render(batch);

        }
        for (Bullet bullet : bullets) {
            if (bullet.active) {
                batch.draw(textureBullet, bullet.position.x - 32, bullet.position.y - 16);
            }
        }
        batch.end();
    }

    private void update() {
        hero.update();
        background.update();
        for (Asteroid asteroid : asteroids) {
            asteroid.update();
        }

        for (Bullet bullet : bullets) {
            if (bullet.active) {
                bullet.update();
                for (Asteroid asteroid : asteroids) {
                    if (asteroid.hitBox.contains(bullet.position)) {
                        asteroid.recreate();
                        bullet.deactivate();
                    }
                    if (asteroid.hitBox.overlaps(hero.hitBox)) {
                        music.pause();
                    }
                }
            }
        }
    }

    public void dispose() {
        batch.dispose();
        music.dispose();
    }
}
