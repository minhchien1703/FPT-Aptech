using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ISP
{
    internal class SuperCar : IDriver, IFly
    {
        public void Driver()
        {
            Console.WriteLine("Super car Driving...");
        }

        public void Flyi()
        {
            Console.WriteLine("Super car Flying...");
        }
    }
}
