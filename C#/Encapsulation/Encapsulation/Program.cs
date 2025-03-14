using Encapsulation;

internal class Program
{
    private static void Main(string[] args)
    {
        BankAccount bank = new BankAccount(1234);

        while (true) {
            Console.WriteLine("1. Deposit.");
            Console.WriteLine("2. With draw.");
            Console.WriteLine("3. Check balance.");
            int choose = Convert.ToInt32(Console.ReadLine());
            if (choose == 1)
            {
                bank.deposit(300);
            }
            if (choose == 2) 
            {
                bank.WithDraw(100);
            }
            if (choose == 3)
            {
                bank.CheckBalance();
            }


        }


    }
}