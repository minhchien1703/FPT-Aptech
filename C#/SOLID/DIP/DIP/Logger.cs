using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DIP
{
    internal class Logger : IFileLogger
    { 
        public void Log(string message)
        {
            Console.WriteLine($"Content: {message}");
        }
    }
}
