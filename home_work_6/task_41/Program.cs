/*
Задача 41: Пользователь вводит с клавиатуры M чисел. Посчитайте, 
сколько чисел больше 0 ввёл пользователь.
0, 7, 8, -2, -2 -> 2
1, -7, 567, 89, 223-> 3
*/

Console.Write("Введите целые числа через пробел--> ");
string? str = Console.ReadLine();
if (str != null)
{
    string[] strArray = str.Split(); 
    int[] numberArray = new int[strArray.Length];
    int countPositiv = 0;
    for (int i = 0; i < numberArray.Length; i++)
    {
        numberArray[i] = Convert.ToInt32(strArray[i]);
        countPositiv = numberArray[i] > 0 ? countPositiv + 1 : countPositiv;
    }
    Console.WriteLine($"Количество положительных чисел = {countPositiv}");
}
