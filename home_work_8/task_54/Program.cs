/*
Задача 54: Задайте двумерный массив. Напишите программу, 
которая упорядочит по убыванию элементы каждой строки двумерного массива.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
В итоге получается вот такой массив:
7 4 2 1
9 5 3 2
8 4 4 2
*/

// Main
Random rnd = new Random();
int[,] matrix = FillMatrix(new int[rnd.Next(2, 11), rnd.Next(2, 11)], 1, 11);
Console.WriteLine("Random matrix:");
WriteMatrix(matrix);

SortRowsMatrix();
Console.WriteLine("Sorted matrix:");
WriteMatrix(matrix);

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

// Sorts row elements in matrix
void SortRowsMatrix()
{
    int indexMax;
    int temp;
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
        {
            indexMax = j;
            for (int k = j + 1; k < matrix.GetLength(1); k++)
            {
                indexMax = matrix[i, indexMax] >= matrix[i, k] ? indexMax : k;
            }
            temp = matrix[i, j];
            matrix[i, j] = matrix[i, indexMax];
            matrix[i, indexMax] = temp;
        }
    }
}