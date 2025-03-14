using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interace
{
    internal class Airplane : IFlyable
    {

        public void Fly()
        {
            Console.WriteLine("Airplane flying.");
        }
    }
}
