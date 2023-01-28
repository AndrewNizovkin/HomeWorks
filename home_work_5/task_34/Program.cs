/*
Задача 34: Задайте массив заполненный случайными положительными 
трёхзначными числами. Напишите программу, которая покажет 
количество чётных чисел в массиве.
[345, 897, 568, 234] -> 2
*/

// Fills an array with random numbers
int[] fillArray(int[] array, int low, int top)
{
    Random rnd = new Random();
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = rnd.Next(low, top);
    }
    return array;
}
//___________________________________________

// Write array
void writeArray(int[] array)
{
    for (int i = 0; i < array.Length; i++)
    {
        Console.Write(array[i] + " | ");
    }
    Console.WriteLine();
}
//___________________________________________

// Gets number from console
int getNumberFromConsole()
{
    Console.Write("Введите натуральное число -->");
    int number = Convert.ToInt32(Console.ReadLine());
    return number;
}
//____________________________________________

// Counts even numbers
int getCountEven(int[] array)
{
    int count = 0;
    foreach(int number in array)
    {
        if (number % 2 == 0)
        {
            count++;
        }
    }
    return count;
}
//____________________________________________

// Main
int number = getNumberFromConsole();
int[] array = fillArray(new int[number], 100, 1000);
writeArray(array);
Console.WriteLine($"Количество чётных элементов в массиве = {getCountEven(array)}");

