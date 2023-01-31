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
    int countPositiv = 0;
    int number;
    for (int i = 0; i < strArray.Length; i++)
    {
        number = Convert.ToInt32(strArray[i]);
        countPositiv = number > 0 ? countPositiv + 1 : countPositiv;
    }
    Console.WriteLine($"Количество положительных чисел = {countPositiv}");
}
