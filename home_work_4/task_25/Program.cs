/*
Задача 25: Напишите цикл, который принимает на вход 
два числа (A и B) и возводит число A в натуральную степень B.
*/

// Reads number from console
int getNumber(string name)
{
    Console.Write("Введите число " + name + "--> ");
    int number = Convert.ToInt32(Console.ReadLine());
    return number;
}

// Gets number A to the power of B
int getPower(int a, int b)
{
    int result = a;
    for (int i = 1; i < b; i++)
    {
        result = result * a;
    }
    return result;
}

int firstNumber = getNumber("A");
int secondNumber = getNumber("B");

Console.Write(firstNumber + " в степени " + secondNumber+ " = " + getPower(firstNumber, secondNumber));
