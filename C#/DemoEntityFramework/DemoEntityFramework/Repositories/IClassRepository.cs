using DemoEntityFramework.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoEntityFramework.Repositories
{
    internal interface IClassRepository
    {
        List<Class> getAll();
    }
}
