package test;

/**
 * Created by лол on 21.06.2017.
 */
public class Rectangle {
    int top;
    int left;
    int width;
    int height;


    public Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int left, int top) {
        this.left = left;
        this.top = top;
    }

    public Rectangle(int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
    }

    public Rectangle(Rectangle anotherRectangle) {
        this.left = anotherRectangle.left;
        this.top = anotherRectangle.top;
        this.width = anotherRectangle.width;
        this.height = anotherRectangle.height;
    }


    public static void main(String[] args) {

    }
}
