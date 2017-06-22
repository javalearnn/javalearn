package test2;



        import java.io.BufferedReader;
        import java.io.InputStreamReader;

/*
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String sum = "сумма";
        int s = 0;
        for (int i = 0; i != -1; i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String a = br.readLine();
            if (a.equals(sum)) {
                break;
            }
            else {
                int w = Integer.parseInt(a);
                s = s + w;
            }
        }
        System.out.println(s);//напишите тут ваш код
    }
}













/*Консоль-копилка
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введет слово «сумма».
Вывести на экран полученную сумму.


 Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна корректно работать, если пользователь ввел одно число и слово «сумма».
3. Программа должна корректно работать, если пользователь ввел два числа число и слово «сумма».
4. Программа должна корректно работать, если пользователь ввел более двух чисел и слово «сумма».
5. Программа должна выводить текст на экран.
6. Программа должна прекращать считывать данные с клавиатуры после того пользователь введет слово "сумма" и нажмет Enter.*/