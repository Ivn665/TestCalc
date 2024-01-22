import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //записываем пример в массив строк
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] exc = input.split(" ");
        //проверям количество ячеек
        if (exc.length !=3) {
            throw new IOException();
        }
        //проверям, чтобы оба числа были арабскими
        boolean num1 = true, num2 = true;
            try {
            int Value = Integer.parseInt(exc[0]);

        } catch (NumberFormatException e) {
            num1 = false;
        }
        try {
            int Value = Integer.parseInt(exc[2]);

        } catch (NumberFormatException e) {
            num2 = false;
        }
        //проверка, чтобы оба числа принадлежали одной системе
        if (num1 != num2) {
            throw new IOException();
        }
        int a=0 , b=0, x=0;

        //Запись чисел в переменные a и b

        if (!num1  && !num2){
                for (RomNum rn: RomNum.values()){
                    if(exc[0].equals(rn.toString())){
                        a = rn.getArabNum();
                    }
                    if(exc[2].equals(rn.toString())){
                        b = rn.getArabNum();
                    }
                    if(a !=0 && b != 0){
                        break;
                    }
                }
                //проверяем правильность записи римских чисел
                if(a==0 || b==0){
                    throw new IOException();
            }
        }else {
            a = Integer.parseInt(exc[0]);
            b = Integer.parseInt(exc[2]);
            //проверяем значение чисел
            if (a<1 || a>10 || b<1 || b> 10) {
                throw new IOException();
            }
        }
        //решаем пример
        switch(exc[1]){
            case "+":
                x = a + b;
                break;
            case "-":
                x = a - b;
                break;
            case "*":
                x = a * b;
                break;
            case "/":
                x = a / b;
                break;
            default: throw new IOException();
        }

        //Выводим решение арабского примера
        if(num1 == true) {
            System.out.println(x);
            //Выводим решение римского примера
        }else{
            if(x<1){
                throw new IOException();
            }
            String s = " ";
            if(x==100){
                s = "C";
                x = x - 100;
            }
            if(x>89){
                s = "XC";
                x = x - 90;
            }
            if(x>49){
                s = "L";
                x = x- 50;
            }
            if(x>39){
                s = "XL";
                x = x- 40;
            }
            a = x / 10;
            for(b=0; b<a; ++b){
               s = s.concat("X");
               x = x - 10;
            }
            for (RomNum rn: RomNum.values()){
                if(x == rn.getArabNum()){
                    s = s.concat(rn.toString());
                    break;
                }
            }
            System.out.println(s);
        }
    }
}
