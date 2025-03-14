internal class Program
{
    private static void Main(string[] args)
    {
        double SquareResoult = square(4);
        Console.WriteLine(string.Format("Square: " + SquareResoult));

        double RectangleResult = Rectangle(2,5);
        Console.WriteLine(string.Format("Rectangle: " + RectangleResult));

        double CircleResult = Circle(2);
        Console.WriteLine(string.Format("Circle: " + CircleResult));
    }

    public static double square(double a)
    {
        return a * a;
    }

    public static double Rectangle (double Height, double width)
    {
        return Height * width;
    }

    public static double Circle(double radius)
    {
        double Pi = 3.14;
        return (radius * radius) *  Pi;
    }
}