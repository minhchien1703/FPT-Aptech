using static System.Delegate;

internal class Program
{
    private delegate void CallbackSay(string text);
    private static void Main(string[] args)
    {
        CallbackSay callbackSay = Go;
        callbackSay.Invoke("FPT");

    }

     private static void Go(string text){
        Console.WriteLine($"That is {text} University");
    }
}