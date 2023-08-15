package com.netcracker.edu.miloserdov.magic;

/* Task

Создайте интерфейс Magic с методами setNumber(int x),
doMagic(), int getNumber(). Реализуйте интерфейс в классе
MagicImpl. Метод setNumber(int x) устанавливает текущее число
в x. int getNumber() возвращает текущее число. doMagic()
переставляет цифры числа в обратном порядке.

 */

public interface Magic {

    void setNumber(int x);

    void doMagic();

    int getNumber();

}
