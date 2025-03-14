using DemoEntityFramework.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoEntityFramework.Repositories
{
    internal class ClassRepository : IClassRepository
    {
        private readonly EduDbContext eduDbContext;

        public ClassRepository(EduDbContext eduDbContext) {
            this.eduDbContext = eduDbContext;
        }
        public List<Class> getAll()
        {
            throw new NotImplementedException();
        }
    }
}
