using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Delegate
{
    internal class OldLover : IActions
    {
        public string Name { get; set; }

        public string Description { get; set; }

        public OldLover(string Name, string Description) {
            this.Name = Name;
            this.Description = Description;
        }

        public void About()
        {
            Console.WriteLine($"Name: {Name}");
            Console.WriteLine($"Description: {Description}");
        }

        public void Say(string str)
        {
            Console.WriteLine($"{str}!");
        }
    }
}
