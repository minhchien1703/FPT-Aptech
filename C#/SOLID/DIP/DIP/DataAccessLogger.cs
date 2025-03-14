
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DIP
{
    internal class DataAccessLogger
    {
        private Logger Logger;

        public DataAccessLogger(Logger logger)
        {
            this.Logger = logger;
        }

        public void Log() {
            Logger.Log("Chien");
        }
        

    }
}
