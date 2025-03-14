using Interace;

internal class Program
{
    private static void Main(string[] args)
    {
        Airplane airplane = new Airplane();
        airplane.Fly();
        Bird bird = new Bird(); 
        bird.Fly(); 
    }
}