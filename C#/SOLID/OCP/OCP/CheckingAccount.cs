using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OCP
{
    internal class CheckingAccount : IAccount
    {
        public double CaculateBalance(Account account)
        {  
            return account.Balance + (account.Balance * 0.2);
        }
    }
}
