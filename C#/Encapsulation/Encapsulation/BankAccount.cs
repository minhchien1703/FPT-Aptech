using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Encapsulation
{
    internal class BankAccount
    {


        private double Balance { get; set; }

        private int AccountNumber { get; set; }

        public BankAccount (int AccountNumber)
        {
            this.AccountNumber = AccountNumber;
        }

        public void deposit (double amount)
        {
            Balance += amount;
            Console.WriteLine("Deposit success.");
        }

        public void WithDraw (double amount)
        {
            if (Balance > amount)
            {
                Balance -= amount;
                Console.WriteLine("With draw success. ");
            }
            else
            {
                Console.WriteLine("With draw fails!");
            }
        }

        public void CheckBalance()
        {
            Console.WriteLine(string.Format("Balance is: " + Balance));
        }

    }
}
