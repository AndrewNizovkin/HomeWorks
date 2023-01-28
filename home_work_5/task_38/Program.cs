/*
Задача 38: Задайте массив вещественных чисел. 
Найдите разницу между максимальным и минимальным элементов массива.
[3 7 22 2 78] -> 76
*/

// Fills an array with double random numbers
double[] fillArray(double[] array, int low, int top, int round)
{
    Random rnd = new Random();
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = Math.Round(rnd.NextDouble() * rnd.Next(low, top), round);
    }
    return array;
}
//___________________________________________

// Write double array
void writeArray(double[] array)
{
    for (int i = 0; i < array.Length; i++)
    {
        Console.Write($"{array[i]:f3} | ");
    }
    Console.WriteLine();
}
//___________________________________________

// Gets number from console
int getNumberFromConsole()
{
    Console.Write("Введите натуральное число --> ");
    int number = Convert.ToInt32(Console.ReadLine());
    return number;
}
//____________________________________________

// Gets min element from array
double minElement(double[] array)
{
    double min = array[0];
    for (int i = 1; i < array.Length; i++)
    {
        if (array[i] < min)
        {
            min = array[i];
        }
    }
    return min;
}
//____________________________________________

// Gets max element from array
double maxElement(double[] array)
{
    double max = array[0];
    for (int i = 1; i < array.Length; i++)
    {
        if (array[i] > max)
        {
            max = array[i];
        }
    }
    return max;
}
//____________________________________________


// Main
int number = getNumberFromConsole();
double[] array = fillArray(new double[number], -10, 11, 3);
writeArray(array);
Console.WriteLine($"Разница между максимальным и минимальным элементом = {maxElement(array) - minElement(array)}");