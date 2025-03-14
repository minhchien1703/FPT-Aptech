using ISP;

internal class Program
{
    private static void Main(string[] args)
    {
        Car car = new Car();
        car.Driver();
        Fly fly = new Fly();
        fly.Flyi();
        SuperCar SuperCar = new SuperCar();
        SuperCar.Driver();
        SuperCar.Flyi();
    }
}