using DIP;
internal class Program
{
    private static void Main(string[] args)
    {
        Console.WriteLine("Begin");
        DataAccessLogger dataAccessLogger = new DataAccessLogger(new Logger());
        dataAccessLogger.Log();
        Console.WriteLine("End");
    }
}