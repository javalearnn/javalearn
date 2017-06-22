package test;


import java.util.Random;
// 14013.56 18:34;


/**
 * Created by лол on 06.06.2017.
 */
public class Test {
    static int Standartternar(int ifelse) {
        return ifelse < 10 ? ifelse * 100 : ifelse * 10;
    }

    static int Standartifelse(int ternar) {
        if (ternar < 10)
            return ternar * 100;
        else return ternar * 10;


    }

    static int elseif(int elseif) {
        if (elseif <= 10 && elseif != 14)
            return elseif;
        else return 0;
    }

    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.print(result + ", ");
        return result;
    }

    static int value = (5);


    public static void main(String[] args) {
// 1. Даны два ненулевых числа. Найти их сумму, разность, произведение и частное.
        int a = 5;
        int b = 6;
        System.out.println((a + b) + " " + (a - b) + " " + (a * b) + " " + (a / b));
// 2. Даны два числа. Найти среднее арифметическое их квадратов и среднее арифметическое их модулей.
        System.out.println((Math.sqrt(a) + Math.sqrt(b)) / 2);
        System.out.println((Math.abs(a) + Math.abs(b)) / 2);
//3. Скорость лодки в стоячей воде V км/ч, скорость течения реки U км/ч (U < V).
// Время движения лодки по озеру T1 ч, а по реке (против течения) — T2 ч. Определить путь S, пройденный лодкой.
        int v = 10;
        int u = 5;
        int hour = 1;
        int T1 = v * hour;
        int T2 = (v - u) * hour;
        System.out.println("Расстояние пройденное без течения" + T1 + " Расстояние пройденное с учетом течения в " + u + "/час = " + T2);
// Скорость первого автомобиля V1 км/ч, второго — V2 км/ч, расстояние между ними S км. Определить расстояние между ними через T часов, если автомобили удаляются друг от друга.
        int V1 = 10; //Скорость первого автомобиля
        int V2 = 20; // Скорость второго автомобиля
        int S = 5; // расстояние между ними
        int T = 2; //   Время
        System.out.println(((V1 * T) + (V2 * T)) + S);
// Скорость первого автомобиля V1 км/ч, второго — V2 км/ч, расстояние между ними S км.
// Определить расстояние между ними через T часов, если автомобили первоначально движутся навстречу друг другу.
        System.out.println((V1 * T - S) + (V2 * T - S));
// Найти периметр и площадь прямоугольного треугольника, если даны длины его катетов a и b.
        int katet1 = 10;
        int katet2 = 20;
        double gepotenuza = Math.pow((Math.sqrt(katet1) + Math.sqrt(katet2)), 2);
        double perimetr = katet1 + katet2 + gepotenuza;
        int ploshad = (katet1 * katet2) / 2;
// 	Даны две целые переменные a, b.
// Составить фрагмент программы, после исполнения которого значения переменных поменялись бы местами
// (новое значение a равно старому значению b и наоборот).
        int ab = 5;
        int bb = 6;
        int cc = ab;
        ab = bb;
        bb = cc;
        System.out.println(ab + " " + bb);

        int fourfivesix = 456;
        int four = fourfivesix / 100;
        int five = fourfivesix % 10;
        int six = (fourfivesix % 100) / 10;
        System.out.println(four + " " + five + " " + six);


        double zui = 3.104359353;
        int dfksf = (int) zui;


        Random rand = new Random(47);
        int rand1 = rand.nextInt(100);
        int rand2 = rand.nextInt(100);
        final boolean trueis = (rand1 > rand2);
        System.out.println(rand1 + " >" + rand2 + " is  " + trueis);
        System.out.println(Integer.toBinaryString(23));
        System.out.println(Standartternar(5));
        System.out.println(Standartternar(7));
        System.out.println(Standartifelse(5));
        System.out.println(Standartifelse(7));
        System.out.println(elseif(10));
        System.out.println(elseif(14));
        while (condition()) {
            System.out.println("Inside 'while' ");
            System.out.println("Exited 'while '");
        }


    }


}


