/*
Задача 58: Задайте две матрицы. Напишите программу, 
которая будет находить произведение двух матриц.
Например, даны 2 матрицы:
2 4 | 3 4
3 2 | 3 3
Результирующая матрица будет:
18 20
15 18
*/

// Main
Random rnd = new Random();
int[,] firstMatrix = FillMatrix(new int[rnd.Next(2, 6), rnd.Next(2, 6)], 1, 11);
int[,] secondMatrix = FillMatrix(new int[firstMatrix.GetLength(1), rnd.Next(2, 6)], 1, 11);

Console.WriteLine("The firstMatrix:");
WriteMatrix(firstMatrix);

Console.WriteLine("The secondMatrix:");
WriteMatrix(secondMatrix);

Console.WriteLine("The resultMatrix:");
WriteMatrix(ProductMatrix(firstMatrix, secondMatrix));

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

// Gets product matrix
int[,] ProductMatrix(int[,] first, int[,] second)
{
    int[,] resultMatrix = new int[first.GetLength(0), second.GetLength(1)];
    for (int i = 0; i < resultMatrix.GetLength(0); i++)
    {
        for (int j = 0; j < resultMatrix.GetLength(1); j++)
        {
            resultMatrix[i, j] = ScalalSum(first, second, i, j);
        }
    }
    return resultMatrix;
}

// Gets scalar product
int ScalalSum(int[,] first, int[,] second, int row, int column)
{
    int sum = 0;
    for (int i = 0; i < first.GetLength(1); i++)
    {
        sum += first[row, i] * second[i, column];
    }
    return sum;
}