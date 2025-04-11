using demo.Models;
using Microsoft.EntityFrameworkCore;

namespace demo.Context
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options) { }

        #region DbSet
        public DbSet<Product> Products { get; set; }

        #endregion
    }
}
