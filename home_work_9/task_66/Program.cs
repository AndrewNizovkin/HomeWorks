/*
Задача 66: Задайте значения M и N. Напишите программу, 
которая найдёт сумму натуральных элементов в промежутке от M до N.
M = 1; N = 15 -> 120
M = 4; N = 8. -> 30
*/

// Main
Random rnd = new Random();
int M = rnd.Next(1, 11);
int N = M + rnd.Next(3, 11);
Console.WriteLine($"Заданы числа:\nM = {M}\nN = {N}");
Console.WriteLine($"Сумма натуральных элементоа в промежутке между {M} и {N} = {GetSumRecursion(M, N)}");

// Gets the sum in the interval between M and N
int GetSumRecursion(int m, int n)
{
    if (n == m) return m;

    else
    {
        return n + GetSumRecursion(m, n - 1);
    }
}