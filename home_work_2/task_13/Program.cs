// Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.

Console.Write("Введите натуральное число--> ");
int number = Convert.ToInt32(Console.ReadLine());

if (number < 100)
{
    Console.Write("Третьей цифры нет");
}
else
{
    Console.Write(number / 100 % 1000 % 10);
}
