package test;
import com.sun.org.apache.regexp.internal.RE;

/**
*Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (верхняя координата, левая, ширина и высота).
*Создать для него как можно больше методов конструкторов.
*Примеры:
*— заданы 4 параметра: left, top, width, height
*— ширина/высота не задана (оба равны 0)
*— высота не задана (равно ширине) создаём квадрат
*— создаём копию другого прямоугольника (он и передаётся в параметрах)
*Требования:
*1. У класса Rectangle должны быть переменные top, left, width и height с типом int.
*2. У класса должен быть хотя бы один конструктор.
*3. У класса должно быть хотя бы два конструктора.
*4. У класса должно быть хотя бы три конструктора.
*5. У класса должно быть хотя бы четыре конструктора.
 **/
public class Rectangle {
int top;
int left;
int width;
int height;


    public Rectangle(int left,int top,int width,int height)
{
    this.left=left;this.top=top;this.width=width;this.height=height;
}
public Rectangle(int left,int top)
{
    this.left=left; this.top=top;
}
    public Rectangle(int left,int top, int width)
    {
        this.left=left;this.top=top;this.width=width;
    }
    public Rectangle(Rectangle anotherRectangle)    {
        this.left = anotherRectangle.left;
        this.top = anotherRectangle.top;
        this.width = anotherRectangle.width;
        this.height = anotherRectangle.height;
    }










    public static void main(String[] args) {

    }
}
