using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegate
{ 
    internal class Me : IActions
    {
        public string Name { get; set; }

        public string Description { get; set; }

        public Me(string Name, string Description) {
            this.Name = Name;
            this.Description = Description;
        }

        public void Say(string str)
        {
            Console.WriteLine($"{str}");
        }

        public void About()
        {
            Console.WriteLine($"Name: {this.Name}");
            Console.WriteLine($"Description: {this.Description}");
        }
    }
}
