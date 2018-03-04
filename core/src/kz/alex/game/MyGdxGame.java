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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import kz.alex.game.objects.Asteroid;
import kz.alex.game.objects.Coin;
import kz.alex.game.objects.Loot;

import javax.print.DocFlavor;


public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Background background;
    private Hero hero;
    private Asteroid[] asteroids;
    private Texture textureBullet, textureHpBar, textureCoin;
    private Music music;
    private BitmapFont font, coinFont;
    private Loot loot;
    private Viewport viewport;
    private Coin coin;
    private int x = 20;
    private int y = 680;
    private float coinTime;

    public Viewport getViewport() {
        return viewport;
    }
    static Bullet[] bullets;
    public void create() {
        batch = new SpriteBatch();
        background = new Background(this, batch);
        viewport = new FitViewport(1280,720);
        hero = new Hero();
        asteroids = new Asteroid[20];
        loot = new Loot();
        font = new BitmapFont();
        coinFont = new BitmapFont();
        font.setColor(2, 0, 5, 8);
        coin = new Coin();
        textureHpBar = new Texture(Const.HERO_HP_BAR);
        textureCoin = new Texture(Const.COINBAR);
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid();
        }
        textureBullet = new Texture(Const.BULLET);
        bullets = new Bullet[200];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
        music = Gdx.audio.newMusic(Gdx.files.internal(Const.GAMEMUSIC));
        music.setLooping(true);
        music.play();
        music.setVolume(0.1f);
    }
    public void render() {
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.enableBlending();
        batch.begin();
        background.render(batch);
        hero.render(batch);
        if (loot.isActive()) loot.render(batch);
        if (hero.alive()) {
            font.draw(batch, "Score: " + hero.getScore(), x+ 20,y );
            batch.draw(textureHpBar, x, y - 35, 0, 0, 200, 20);
            batch.draw(textureHpBar, x, y - 35, 0, 20, 200 * hero.getHp() / 10, 20);
            font.draw(batch, "WASD - Move, SPACE - Fire", 500, 20);
            font.draw(batch, "HP: " + hero.getHp(), 220, 640);
            coinFont.draw(batch,"" + hero.getCoinScore(), 60, 640);
            int frame =(int) (coinTime/0.1f);
            frame = frame % 8;
            batch.draw(textureCoin,40, 626, frame*16, 0, 16,16);
        }
            else {
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
        if(coin.isActive()){
            coin.render(batch);
        }
        batch.end();
    }
    public void resize(int width, int height) {
        background.myGame.getViewport().update(width,height,true);
        background.myGame.getViewport().apply();
    }
    private void startNewGame() {
        hero = new Hero();
        music = Gdx.audio.newMusic(Gdx.files.internal(Const.GAMEMUSIC));
        music.play();
        music.setVolume(0.1f);
        music.setLooping(true);
    }
    private void update() {
        hero.update();
        background.update();
        if (!loot.isActive()){
            loot.recreate();
        }
        else if (loot.isActive()) {
            loot.update();
        }
        for (Asteroid asteroid1 : asteroids) {
            if (!asteroid1.isActive()) {
                asteroid1.setup();
                break;
            } else {
                asteroid1.update();
            }
        }
        for (Asteroid asteroid : asteroids) {
            if (asteroid.getRectangle().overlaps(hero.getRectangle())) {
                hero.takeDamage(1);
                asteroid.setup();
            }
        }
        for (Bullet bullet : bullets) {
            if (bullet.active) {
                bullet.update();
                for (Asteroid asteroid : asteroids) {
                    if (asteroid.getRectangle().contains(bullet.position)) {
                        asteroid.takeDamage(1);
                        bullet.deactivate();

                        if (asteroid.getHp() <= 0) {
                            loot.setActive(true);
                            hero.addScore(10);
                            if (!coin.isActive()) {
                                coin.addCoinRate(1);
                            }
                            break;
                        }
                    }
                }
            }
        }


        if (hero.getRectangle().overlaps(loot.getRectangle() ) &&  loot.isActive()) {
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
        if(!coin.isActive()){
            coin.recreate();
        }
        if (coin.isActive()){
            coin.update();
        }
        if (hero.getRectangle().overlaps(coin.getRectangle()) && coin.isActive()){
            hero.addCoinScore(1);
            coin.getSound().play(0.5f);
            coin.disable();
        }
        coinTime +=0.05f;
    }
    public void dispose() {
        batch.dispose();
        music.dispose();
    }
}
