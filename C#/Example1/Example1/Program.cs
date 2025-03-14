

using Example1;

internal class Program
{
    private static void Main(string[] args)
    {
        Rectangle rectangle = new Rectangle();
        rectangle.Dai = 3;
        rectangle.Rong = 4;
        rectangle.Area();
        rectangle.Perimeter();

        Square square = new Square();
        square.Dai = 6;
        square.Canh = 4;
        square.Area();
        square.Perimeter();

        

    }
}