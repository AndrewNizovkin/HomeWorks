/* Задача 2: Напишите программу, которая на вход принимает два числа и выдаёт,
 какое число большее, а какое меньшее.
 Упрощённая версия, не включающая обработку исключений при вводе 
 пустой строки или чисел не соответсвующих типу Int32
*/

Console.WriteLine("Введите первое число");
int firstNumber = System.Convert.ToInt32(Console.ReadLine());

Console.WriteLine("Введите второе число");
int secondNumber = System.Convert.ToInt32(Console.ReadLine());

if (firstNumber > secondNumber)
{
    Console.WriteLine(firstNumber + " - большее из двух чисел");
}

else if (firstNumber < secondNumber)
{
    Console.WriteLine(secondNumber + " - большее из двух чисел");
}

else
{
    Console.WriteLine("Числа равны");
}
