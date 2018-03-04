package kz.alex.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import kz.alex.game.Const;

public class Coin extends AbstractObject {

    private final int WIDTH = 30;
    private final int HEIGHT = 32;
    private float time;
    private int coinRate;
    private int random;
    private Sound sound;

    public Sound getSound() {
        return sound;
    }
    public void addCoinRate(int coinRate){
        this.coinRate += coinRate;
        if (this.coinRate == random) {
                active = true;
                this.coinRate = 0;
            random = MathUtils.random(1,7);
            }
        System.out.print(String.format("CoinRate random number [%d]", random ));
        System.out.println(String.format("/[%d]", this.coinRate));
    }
    public Coin() {
        this.position = new Vector2(0, 0);
        this.texture = new Texture(Const.COIN);
        this.active = false;
        this.rectangle = new Rectangle(position.x, position.y, 16, 16);
        this.random = MathUtils.random(3,10);
        this.sound = Gdx.audio.newSound(Gdx.files.internal(Const.COINSOUND));
        System.out.println(String.format("Start random number [%d]", random));
        }
        public void render(SpriteBatch batch) {
        int frame =(int) (time/0.1f);
        frame = frame % 8;
        batch.draw(texture, position.x, position.y, frame*32, 0, WIDTH, HEIGHT);
    }
        public void update() {
        speed = 1.5f;
        rectangle.setSize(16, 16);
        active = true;
        time+=0.05f;
        position.y -=speed;
        position.x -=speed;
        rectangle.setPosition(position.x, position.y);
        if (position.x < 0 || position.y < 0 ){
            recreate();
        }
    }
    public void recreate(){
        position.x = MathUtils.random(500,800);
        position.y = (736);
        }
}
