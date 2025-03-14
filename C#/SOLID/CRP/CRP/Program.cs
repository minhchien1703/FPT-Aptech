using CRP;

internal class Program
{
    private static void Main(string[] args)
    {
        EmployeeRepository employeeRepository = new EmployeeRepository("Hao", 500);
        Employee employee = new Employee();
        double Salary =employee.CaculateSalary(employeeRepository);
        Console.WriteLine(string.Format("Salary is: {0}", Salary));
    }
}