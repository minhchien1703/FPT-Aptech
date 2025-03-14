using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoClassCSharp
{

    internal class Person : Animal
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public string Description { get; set; }


        public Person() { }
        

        public void Run()
        {
            Console.WriteLine("I can run!");
        }

        public override void Eat()
        {
            Console.WriteLine(string.Format(this.Name + " is eatting! "));
        }

        public void Display()
        {
            Console.WriteLine(string.Format(this.Id + "\n" + this.Name + "\n" + this.Description));
        }
    }
}
