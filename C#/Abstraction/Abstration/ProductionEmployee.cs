using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Abstraction
{
    internal class ProductionEmployee : Employee
    {
        public string Name { get; set; }
        private double Salary { get; set; }
        private double Tips { get; set; }

        public ProductionEmployee(string Name, double Salary, double Tips)
        {
            this.Name = Name;
            this.Salary = Salary;
            this.Tips = Tips;
        }
        public override double SalaryCaculate()
        {
            return this.Salary + this.Tips;
        }
    }
}
