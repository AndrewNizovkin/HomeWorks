/* Задача 4: Напишите программу, которая принимает на вход 
три числа и выдаёт максимальное из этих чисел.
Упрощённая версия, не включающая обработку исключений при вводе 
 пустой строки или чисел не соответсвующих типу Int32
*/

int[] array = new int[3];
int max;

for (int i = 0; i < array.Length; i++)
{
    Console.Write("Введите число--> ");
    array[i] = System.Convert.ToInt32(Console.ReadLine());
}

max = array[0];

for (int i = 1; i < array.Length; i++)
{
    if (array[i] > max)
    {
        max = array[i];
    }
}

Console.WriteLine("Наибольшее из чисел = " + max);
