using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CRP
{
    internal class Employee
    {
        public double CaculateSalary(EmployeeRepository employee)
        {
            return employee.Salary + 100;
        }
    }
}
