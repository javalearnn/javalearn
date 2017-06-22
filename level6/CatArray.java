package level6;

import java.util.ArrayList;

import static javax.swing.UIManager.get;

/*
Статические коты
1. В классе CatArray добавь public статическую переменную cats (ArrayList<CatArray>).
2. Пусть при каждом создании кота (нового объекта CatArray) в переменную cats добавляется этот новый кот. Создать 10 объектов CatArray.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.


Требования:
1. Добавь в класс CatArray public статическую переменную cats (ArrayList).
2. Переменная cats должна быть проинициализирована.
3. Метод main должен создавать 10 объектов CatArray.
4. Метод main должен добавить всех созданных котов в переменную cats.
5. Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
 */
public class CatArray {


    public static ArrayList cats = new ArrayList();




        //напишите тут ваш код

        public CatArray() {



        }

        public static void main(String[] args) {
            CatArray cat[] = new CatArray[10];
            for (int i = 0; i < 10; i++) {
                cat[i] = new CatArray();
                cats.add(cat[i]);
            }
            printCats();
        }

        public static void printCats() {
            for (int i = 0; i < cats.size() ; i++) {
                System.out.println(CatArray.cats.get(i));
            }

        }
    }


