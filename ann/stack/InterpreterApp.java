package ann.stack;


public class InterpreterApp {public static void main(String[] args) {
    // буквенное выражение
    Interpreter intp = new Interpreter(
            "aa -(bb+c*d*e+f)/(g-h+i*k)+(l+m+n/q)*s+t");
    intp.translate();
    System.out.println("An expression to translate: aa -(bb+c*d*e+f)/(g-h+i*k)+(l+m+n/q)*s+t");
    System.out.println("Postfix output: " + intp.translate() + "\n");


    // простое числовое выражение
    intp.setInfix("12 -  (32 + 3)* 3 - 1");
    intp.translate();
    System.out.println("To do: 12 -  (32 + 3)* 3 - 1");
    System.out.println("Postfix output: " + intp.translate());
    System.out.println("Answer: " + intp.calc() + "\n");

    //
    // посчитаем такое выражение - посложнее
    intp.setInfix("3 + (1 + 3 * 5 * 7 + 2)/(4 - 3 + 2 * 3) + (  7 + 9 + 10 / 5 ) * 3 + 2");
    intp.translate();
    System.out.println("To do: 3 + (1 + 3 * 5 * 7 + 2)/(4 - 3 + 2 * 3) + (  7 + 9 + 10 / 5 ) * 3 + 2");
    System.out.println("Postfix output: " + intp.translate());
    System.out.println("Answer: " + intp.calc() + "\n");
}
}
