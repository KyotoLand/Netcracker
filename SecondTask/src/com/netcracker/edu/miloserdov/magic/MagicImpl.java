package com.netcracker.edu.miloserdov.magic;

/* Task

Создайте интерфейс Magic с методами setNumber(int x),
doMagic(), int getNumber(). Реализуйте интерфейс в классе
MagicImpl. Метод setNumber(int x) устанавливает текущее число
в x. int getNumber() возвращает текущее число. doMagic()
переставляет цифры числа в обратном порядке.

 */

import java.util.Arrays;

public class MagicImpl implements Magic{

    private int number;

    @Override
    public void setNumber(int x) {
        number = x;
    }

    @Override
    public void doMagic() {
        String numStr = Integer.toString(number);
        char[] strArr = numStr.toCharArray();
        String res = "";
        for( int i = strArr.length - 1 ; i>=0 ; i--){
            res += strArr[i];
        }
        number = Integer.parseInt(res);
    }

    @Override
    public int getNumber() {
        return number;
    }

}
