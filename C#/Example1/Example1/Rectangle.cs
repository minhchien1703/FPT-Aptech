using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Example1
{
    internal class Rectangle : IShap
    {

        public int Dai { get; set; }
        public int Rong { get; set; }

        public Rectangle() { }


        public void Area()
        {
            int Area = this.Dai * this.Rong;
            Console.WriteLine(string.Format("Area: {0}", Area));
        }

        public void Perimeter()
        {
            int Perimeter = (this.Dai + this.Rong) * 2;
            Console.WriteLine(string.Format("Perimeter: {0}", Perimeter));
        }
    }
}
