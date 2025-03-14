using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Event
{
    public delegate void Notify();
    internal class ProcessBusiness
    {
        public event Notify OnProcess;

        public void Process()
        {
            Console.WriteLine("Begin ");
            Console.WriteLine("Holding ....");
            Thread.Sleep(1000);
            Completing();
        }

        public void Completing() {
            Console.WriteLine("Completed.");
        }

    }

}
