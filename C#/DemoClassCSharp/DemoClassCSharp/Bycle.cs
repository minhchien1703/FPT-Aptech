using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoClassCSharp
{
    internal class Bycle : IBycle
    {
        public void RunBycle()
        {
            Console.WriteLine("The Bycle is runing.");
        }
    }
}
