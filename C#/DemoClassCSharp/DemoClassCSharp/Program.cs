using DemoClassCSharp;

internal class Program
{
    private static void Main(string[] args)
    {
        //Person person = new Person();
        //person.Run();
        //person.Id = 1;
        //person.Name = "Le Ngoc Anh";
        //person.Description = "Odd love person !";
        //person.Display();
        //person.Eat();
        
        Car car = new Car();
        Bycle bycle = new Bycle();

        car.Run();
        car.StartEngine();
        bycle.RunBycle();

        Management.ManagementRun();

    }
}