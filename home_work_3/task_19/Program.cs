// Задача 19: Напишите программу, которая принимает на вход пятизначное
// число и проверяет, является ли оно палиндромом.

// Gets revers number
int reversNumber(int number)
{
    double revers = 0;
    int count = 5;
    
    while (number > 0)
    {
        revers += (number % 10) * Math.Pow(10.0, (double)(count - 1));
        number = number / 10;
        count--;
    }

    return (int)revers;
}

Console.Write("Введите пятизначное натуральное число--> ");
int naturalNumber = Convert.ToInt32(Console.ReadLine());

if (reversNumber(naturalNumber) == naturalNumber)
{
    Console.Write("Это палиндром");
}
else
{
    Console.Write("Это не палиндром");
}

