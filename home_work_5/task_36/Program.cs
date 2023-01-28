/*
Задача 36: Задайте одномерный массив, заполненный случайными числами. 
Найдите сумму элементов, стоящих на нечётных позициях.
[3, 7, 23, 12] -> 19
[-4, -6, 89, 6] -> 0
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
    Console.Write("Введите натуральное число --> ");
    int number = Convert.ToInt32(Console.ReadLine());
    return number;
}
//____________________________________________

// Gets sum of numers on odd position
int sumOddPosition(int[] array)
{
    int sum = 0;
    if (array.Length > 1)
    {
        if (array.Length == 2)
        {
            sum = array[1];
        }
        else
        {
            for (int i = 1; i < array.Length; i += 2)
            {
                sum += array[i];
            }
        }
    }
    return sum;
}

// Main
int number = getNumberFromConsole();
int[] array = fillArray(new int[number], -10, 11);
writeArray(array);
Console.WriteLine($"Сумма элементов на нечётных позициях = {sumOddPosition(array)}");
