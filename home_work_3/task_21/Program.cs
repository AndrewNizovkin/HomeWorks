// Задача 21: Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.

// Gets point coordinates
double[] getCoordinates(string name)
{
    double[] newPoint = new double[3];

    Console.Write($"Введите X точки {name} --> ");
    newPoint[0] = Convert.ToDouble(Console.ReadLine());

    Console.Write($"Введите Y точки {name} --> ");
    newPoint[1] = Convert.ToDouble(Console.ReadLine());

    Console.Write($"Введите Z точки {name} --> ");
    newPoint[2] = Convert.ToDouble(Console.ReadLine());

    return newPoint;
}

double[] A = getCoordinates("A");
double[] B = getCoordinates("B");

double distanse = Math.Sqrt(Math.Pow((A[0] - B[0]), 2) + 
Math.Pow((A[1] - B[1]), 2) + 
Math.Pow((A[2] - B[2]), 2));

Console.WriteLine(Math.Round(distanse, 2));