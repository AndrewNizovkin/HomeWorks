/*
Задача 64: Задайте значение N. Напишите программу, 
которая выведет все натуральные числа в промежутке
 от N до 1. Выполнить с помощью рекурсии.
N = 5 -> "5, 4, 3, 2, 1"
N = 8 -> "8, 7, 6, 5, 4, 3, 2, 1"
*/

// Main
Random rnd = new Random();
int N = rnd.Next(1, 21);
Console.WriteLine($"Задано число \"{N}\"");
Console.WriteLine(GetNumbers(N).TrimEnd().TrimEnd(','));


// Gets string with numbers in range from number to 1 
string GetNumbers(int number)
{
    if (number == 0)
    {
        return String.Empty;
    }
    else
    {
        return $"{number}, " + GetNumbers(number - 1);
    }
}