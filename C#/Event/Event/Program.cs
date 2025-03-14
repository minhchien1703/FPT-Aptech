using Event;

internal class Program
{
    
    private static void Main(string[] args)
    {
        ProcessBusiness processBusiness = new ProcessBusiness();
        processBusiness.OnProcess += ProcessBusiness_OnProcess();
        processBusiness.OnProcess;
    }

    private static void ProcessBusiness_OnProcess()
    {
        Console.WriteLine();
    }
}