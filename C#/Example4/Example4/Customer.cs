using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Text;
using System.Threading.Tasks;

namespace Example4
{
    internal class Customer : IBank,ISavingAmount,ICreditAccount
    {

        public string Name { get; set; }
        public float Amount { get; set; }

        
        public void CreditAmount(float CreditAmount)
        {
            if (this.Amount > CreditAmount)
            {
                this.Amount -= CreditAmount;
                Console.WriteLine("Thanh toan thanh cong.");
                GetAmount();
            } else
            {
                Console.WriteLine("So du khong du !");
            }
        }

        public void GetAmount()
        {
            Console.WriteLine(string.Format("So du la: {0}", this.Amount));
        }

        public void SetSavingAmount(string Name, float Amount)
        {
            this.Name = Name;
            this.Amount = Amount;
            Console.WriteLine("Them thanh cong.");
        }
    }
}
