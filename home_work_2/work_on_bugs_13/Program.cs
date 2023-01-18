// Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.

Console.Write("Введите натуральное число--> ");
int number = Convert.ToInt32(Console.ReadLine());

if (number < 100)
{
    Console.Write("Третьей цифры нет");
}
else
{
    while (number > 999)
    {
        number = number / 10;
    }

    Console.Write(number % 10);
}
