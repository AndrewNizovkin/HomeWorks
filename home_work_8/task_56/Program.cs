/*
Задача 56: Задайте прямоугольный двумерный массив. Напишите программу, 
которая будет находить строку с наименьшей суммой элементов.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
5 2 6 7
Программа считает сумму элементов в каждой строке и выдаёт номер строки 
с наименьшей суммой элементов: 1 строка
*/

// Main
Random rnd = new Random();
int[,] matrix = FillMatrix(new int[rnd.Next(2, 11), rnd.Next(2, 11)], 1, 11);
WriteMatrix(matrix);

int minSum = GetRowSum(matrix, 0);
int indexMinSum = 0;
int curentSum;

for (int i = 1; i < matrix.GetLength(0); i++)
{
    curentSum = GetRowSum(matrix, i);
    if (curentSum < minSum)
    {
        minSum = curentSum;
        indexMinSum = i;
    }
}

Console.WriteLine($"Строка с индексом {indexMinSum} - первая встреченная с минимальной суммой элементов");

// Gets sum of row of the matrix
int GetRowSum(int[,] matrix, int row)
{
    int sum = 0;
    for (int i = 0; i < matrix.GetLength(1); i++)
    {
         sum += matrix[row, i];
    }
    return sum;
}

// Fills matrix
int[,] FillMatrix(int[,] matrix, int low, int top)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
            matrix[i, j] = rnd.Next(low, top);
    }
    return matrix;
}

// Outputs int matrix to console 
void WriteMatrix(int[,] matrix)
{
    string separator = new String('-', 8 * matrix.GetLength(1));
    Console.WriteLine(separator);
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
            Console.Write($"{matrix[i, j],4}   |");
        Console.WriteLine();
    }
    Console.WriteLine(separator);
}
