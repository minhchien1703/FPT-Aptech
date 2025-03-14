using Example4;
internal class Program
{
    private static void Main(string[] args)
    {
        Customer customer = new Customer();
        customer.SetSavingAmount("Minh Chien", 200);
        customer.GetAmount();
        customer.CreditAmount(100);

    }
}