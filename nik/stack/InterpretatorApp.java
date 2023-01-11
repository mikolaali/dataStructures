package nik.stack;

public class InterpretatorApp {
    public static void main(String[] args) {
        // разбираем буквенное выражение
        Interpretator intp = new Interpretator(
                "aa -(bb+c*d*e+f)/(g-h+i*k)+(l+m+n/q)*s+t");
        intp.transform();
        System.out.println("Преобразовать в постфиксную форму: aa -(bb+c*d*e+f)/(g-h+i*k)+(l+m+n/q)*s+t");
        System.out.println("Постфиксная запись: " + intp.getPostfix() + "\n");


        // простое числовое выражение - разбираем, затем считаем;
        intp.setInfix("12 -  (32 + 3)* 3 - 1");
        intp.transform();
        System.out.println("Разобрать и посчитать: 12 -  (32 + 3)* 3 - 1");
        System.out.println("Постфиксная запись: " + intp.getPostfix());
        System.out.println("Результат: " + intp.calculate() + "\n");

        //
        // посчитаем такое выражение - посложнее
        intp.setInfix("3 + (1 + 3 * 5 * 7 + 2)/(4 - 3 + 2 * 3) + (  7 + 9 + 10 / 5 ) * 3 + 2");
        intp.transform();
        System.out.println("Разобрать и посчитать: 3 + (1 + 3 * 5 * 7 + 2)/(4 - 3 + 2 * 3) + (  7 + 9 + 10 / 5 ) * 3 + 2");
        System.out.println("Постфиксная запись: " + intp.getPostfix());
        System.out.println("Результат: " + intp.calculate() + "\n");
    }
}
