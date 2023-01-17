// Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.

Console.Write("Введите номер дня недели--> ");
int dayNumber = Convert.ToInt32(Console.ReadLine());

if (dayNumber > 0 & dayNumber < 8) 
{
    if (dayNumber > 5)
    {
        Console.Write("Это выходной день");
    }
    else
    {
        Console.Write("Это не выходной день");
    }
}
else
{
    Console.Write("Это не номер дня недели");
}