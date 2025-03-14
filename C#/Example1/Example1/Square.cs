using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Example1
{
    internal class Square : IShap
    {
        public int Dai { get; set; }
        public int Canh { get; set; }
        public Square() { }
        public void Area()
        {
            int Area =  this.Canh + this.Canh;
            Console.WriteLine(string.Format($"Area: {Area}"));
        }

        public void Perimeter()
        {
            int Perimeter = this.Dai * this.Canh;
            Console.WriteLine(string.Format($"Perimeter: {Perimeter}"));
        }
    }
}
