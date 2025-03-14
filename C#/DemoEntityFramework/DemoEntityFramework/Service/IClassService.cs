using DemoEntityFramework.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoEntityFramework.Service
{
    internal interface IClassService
    {
        List<Class> GetClasses();
    }
}
