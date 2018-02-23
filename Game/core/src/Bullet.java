import com.badlogic.gdx.math.Vector2;

class Bullet {
    Vector2 position; // coords x coors y
    float speed;
    boolean active;

    public Bullet() {
        position = new Vector2(0,0);
        speed = 14;
        active = false;
    }
    public void activate(float x, float y)
    {
        position.set(x, y);
        active = true;

    }
    public void deactivate()
    {
     active = false;

    }


    public void update() {
        position.x += speed;
        if (position.x > 1280) {
            deactivate();



        }
    }
}