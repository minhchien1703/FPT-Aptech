using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CRP
{
    internal class EmployeeRepository
    {
        private string Name { get; set; }

        public double Salary { get; set; }
        public EmployeeRepository(string Name, double Salary) {
            this.Name = Name;
            this.Salary = Salary;
        }
    }
}
