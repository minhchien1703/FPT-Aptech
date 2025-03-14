using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ISP
{
    internal class Fly : IFly
    {
         public void Flyi()
        {
            Console.WriteLine("Flying...");
        }
    }
}
