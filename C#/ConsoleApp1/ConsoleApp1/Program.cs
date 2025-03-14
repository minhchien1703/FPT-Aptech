internal class Program
{
    private static void Main(string[] args)
    {
        //ExampleFloopFor();
        //ExampleFloopWhile();
        //Foreach();
        //int a = 7, b = 7, sum;
        //sum = a + b;
        //Console.WriteLine(string.Format(" {0} +  {1} = {2}", a, b, sum));

        do {
            Console.WriteLine("\n1. Create a User.");
            Console.WriteLine("2. Sum of tow numbers.");
            Console.WriteLine("3. Count sum spaces of string.");
            Console.WriteLine("4. Sum of the elements in an array.");
            Console.WriteLine("5. Contains odd number in an array.");
            Console.WriteLine("6. Largest value between first and last elements.");
            Console.WriteLine("7. Direction rotate of an array.");
            Console.WriteLine("8. Check the first element or last of the two arrays are equal.");
            Console.WriteLine("9. The sum of all elements in an array.");
            Console.WriteLine("10. Check that ingteger element is appears in the first and last elements in array.");
            Console.WriteLine("11. Get the ASCII of a given value character.");
            Console.WriteLine("12. Convert a integer to a string and a string to an integer. ");
            Console.WriteLine("13. Remove all vowels from a given string.");
            Console.WriteLine("14. Count positive and negative numbers in a\r\ngiven array of integers.");

            Console.Write("Enter choose: ");
            int choose = Convert.ToInt32(Console.ReadLine());
            switch(choose)
            {
                case 1:
                    Console.WriteLine("Enter first name: ");
                    string name = Console.ReadLine();
                    UserDefined(name);
                    break;

                case 2:
                    Console.WriteLine("Enter numer a:");
                    int a = Convert.ToInt32(Console.ReadLine());
                    Console.WriteLine("Enter numer a:");
                    int b = Convert.ToInt32(Console.ReadLine());
                    SumOfTwoNumbers(a, b);
                    break;

                case 3:
                    Console.Write("Enter string:");
                    string stringInput = Console.ReadLine();
                    CountSpacesInString(stringInput);
                    break;

                case 4:
                    int[] arr = new int[5];
                    for (int i = 0; i < arr.Length; i++)
                    {
                        Console.Write(string.Format("Enter element {0}: ", i));
                        arr[i] = Convert.ToInt32(Console.ReadLine());
                    }
                    SumOfElementInAnArray(arr);
                    break;

                case 5:
                    int[] arr2 = {8, 4, 5, 14, 10 };
                    ContainsAnOddNumber(arr2);
                    break;

                case 6:
                    int[] arr3 = {9, 3, 1, 5, 2, 10 };
                    getTheLargestValueOfAnArray(arr3);
                    break; 

                case 7:
                    int[] arr4 = {1, 4, 9 };
                    DirectionRotateOfAnArray(arr4);
                    break;

                case 8:
                    int[] array1 = { 1, 2, 2, 3, 3, 4, 5, 6, 5, 7, 7, 7, 8, 8, 1 };
                    int[] array2 = { 1, 2, 2, 3, 3, 4, 5, 6, 5, 7, 7, 7, 8, 8, 5 };
                    CheckFirstElementOrLastElementOfTheTwoArrays(array1, array2);
                    break;

                case 9:
                    int[] arr5 = { 1, 2, 2, 3, 3, 4, 5, 6, 5, 7, 7, 7, 8, 8, 1 };
                    TheSumOfAllElementsInArray(arr5);
                    break;

                case 10:
                    int[] arr6 = { 5, 9, 1, 3, 5 };
                    Console.Write("Enter an integer: ");
                    int x = Convert.ToInt32(Console.ReadLine());
                    AreIntegerElementIsAppearsInTherFirstAndLastElement(arr6, x);
                    break;

                case 11:
                    GetTheASCIIOfAGivenCharacter();
                    break;

                case 12:
                    int n = 10;
                    string str = "122";
                    ConvertAnintegerToAStringAndAStringToAnInteger(n, str);
                    break;

                case 13:
                    string PythonStr = "Python";
                    string CSharpStr = "C Sharp";
                    string JavaScriptStr = "JavaScript";

                    break;

                    case 14:
                    int[] numbers = { 9, -6, 1, 12, -43, 5, 6, -11 };
                    CountPositiveAndNegative(numbers);
                    break;



            }
        }while (true);
    }

    private static void CountPositiveAndNegative(int[] nunbers)
    {
        int PositiveCount = 0;
        int NegativeCount = 0;
        foreach (int n in nunbers) { 
            if (n > 0)
            {
                PositiveCount++;
            }
            if (n < 0)
            {
                NegativeCount++;
            }
        }
        Console.WriteLine($"Sum of positive: {PositiveCount}");
        Console.WriteLine($"Sum of Negative: {NegativeCount}");
    }

    private static void RemoveAllVowels(string str1, string str2, string str3)
    {
        string vowels1 = str1;
        string vowels2 = str2;
        string vowels3 = str3;

        Console.WriteLine($"{str1.Where(c => vowels1.Contains(c)).ToArray()}");
        Console.WriteLine($"{str2.Where(c => vowels2.Contains(c)).ToArray()}");
        Console.WriteLine($"{str3.Where(c => vowels3.Contains(c)).ToArray()}");
    }

    private static void ConvertAnintegerToAStringAndAStringToAnInteger(int n, string str)
    { 
        Console.WriteLine($"Int to String: {Convert.ToString(n)}");
        Console.WriteLine($"String to Int {Convert.ToInt32(str)}");
    }


    private static void GetTheASCIIOfAGivenCharacter()
    {
        Console.WriteLine(string.Format("ASCII value of 1 is {0}", Convert.ToInt32('1')));
        Console.WriteLine(string.Format("ASCII value of A is {0}", Convert.ToInt32('A')));
        Console.WriteLine(string.Format("ASCII value of a is {0}", Convert.ToInt32('a')));
        Console.WriteLine(string.Format("ASCII value of # is {0}", Convert.ToInt32('#')));
    }

    private static void AreIntegerElementIsAppearsInTherFirstAndLastElement(int[] array, int x)
    {
        int arrLength = array.Length;
        if (array[0] == x && array[arrLength - 1] == x)
        {
            Console.WriteLine("True");
        } else
        {
            Console.WriteLine("False");
        }
    }

    private static void TheSumOfAllElementsInArray(int[] array)
    {
        int sumElements = 0;
        foreach (int element in array)
        {
            sumElements += element;
        }
        Console.WriteLine(string.Format("Sum: {0}", sumElements));
    }

    private static void CheckFirstElementOrLastElementOfTheTwoArrays(int[] array1, int[] array2)
    {
        int arrLength = array1.Length;
        if (array1[0] == array2[0])
        {
            Console.WriteLine("The first element of array 1 equal the first element of array 2.");
        } else
        {
            Console.WriteLine("THe first element of array 1 is not equal the first element of array 2.");
        }

        if (array1[arrLength - 1] == array2[arrLength - 1])
        {
            Console.WriteLine("The last element of array 1 equal the last element of array 2.");
        } else
        {
            Console.WriteLine("The last element of array 1 is not equal the last element of array 2.");
        }
    }

    private static void DirectionRotateOfAnArray(int[] array)
    {
        Console.Write("Array1: ");
        foreach (int i in array)
        {
            Console.Write(string.Format("{0}, ", i));
        }

        int arrLenght = array.Length;
        int[] newArray = new int[arrLenght];
        for (int i = 0; i < arrLenght; i++)
        {
            newArray[i] = array[arrLenght - 1 - i];
        }

        Console.Write("\nAfter rotating array becomes: ");
        foreach (int i in newArray)
        {
            Console.Write(string.Format("{0}, ", i));
        }
    }

    private static void getTheLargestValueOfAnArray(int[] array)
    {
        int arrLenght = array.Length - 1;
        int valueFirstElement = array[0];
        int valueLastElement = array[arrLenght];
        Console.Write("Array1: ");
        foreach (int i in array)
        {
            Console.Write(string.Format("{0}, ", i));
        }
        if (valueFirstElement > valueLastElement)
        {
            Console.WriteLine("\nHighest value between first and last values of the said array: {0}", valueFirstElement);
        }
        if (valueLastElement > valueFirstElement)
        {
            Console.WriteLine("\nHighest value between first and last values of the said array: {0}", valueLastElement);
        }


    }


    private static void ContainsAnOddNumber(int[] array)
    {
        Boolean flag = false;
        Console.Write("Original array: ");
        foreach (int i in array)
        {
            Console.Write(string.Format("{0}, ", i));

            if (i % 2 != 0)
            {
                flag = true;
            }
        }
        if (flag == false)
        {
            Console.WriteLine(string.Format("Check if an array contains an odd number? {0}", flag));
        }
        else
        {
            Console.WriteLine(string.Format("Check if an array contains an odd number? {0}", flag));

        }

    }

    private static void SumOfElementInAnArray(int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < arr.Length; i++)
        {
            sum = sum + arr[i];
        }
        Console.WriteLine(string.Format("The sum of the elements of the array is: {0}", sum));
    }

    private static void CountSpacesInString(string stringInput)
    {
        int countSpaces = 0;
        string newString;
        for (int i = 0; i < stringInput.Length; i++)
        {
            newString = stringInput.Substring(i, 1);
            if (newString == " ")
            {
                countSpaces = countSpaces + 1;
            }  
        }
        Console.Write(string.Format("{0}", stringInput));
        Console.WriteLine(" contains {0} spaces",countSpaces);
    }

    private static void SumOfTwoNumbers(int a, int b)
    {
        Console.WriteLine(string.Format("{0} + {1} = {2}", a, b, a + b));
    }

    private static void UserDefined(string name)
    {
        Console.WriteLine(string.Format("Welcome friend {0}!", name));
        Console.WriteLine("Have a nice day!");
    }
    
    private static void ExampleFloopFor()
    {
        Console.WriteLine("\n");
        for (int i = 0; i < 10; i++)
        {
            Console.WriteLine(i);
        }
    }

    private static void ExampleFloopWhile() {
        int i = 1;
        Console.WriteLine("\n");
        while (i <= 10) {
            if (i % 2 == 0)
            {
                Console.WriteLine(string.Format("Chan: i {0}", i));
            }
            else {
                Console.WriteLine(string.Format("Le: i {0}", i));
            }
            i++;
        } 
    }

    private static void Foreach()
    {
        int[] arr = { 1, 2, 3, 23, 32, 65, 34 };
        Console.WriteLine("\n");
        foreach (int i in arr)
        {
            Console.WriteLine(string.Format("item: i {0}", i));
        }
    }
}