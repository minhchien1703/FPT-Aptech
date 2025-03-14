using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoClassCSharp
{
    internal class Car : IVehicle, ICar
    {
        public void Run()
        {
            Console.WriteLine("Car is runing");
        }

        public void StartEngine()
        {
            Console.WriteLine("Engine is started.");
        }
    }
}
