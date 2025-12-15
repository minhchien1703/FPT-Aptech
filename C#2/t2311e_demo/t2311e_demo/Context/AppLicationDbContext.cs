using Microsoft.EntityFrameworkCore;

namespace t2311e_demo.Context
{
    public class AppLicationDbContext : DbContext
    {
        public AppLicationDbContext(DbContextOptions<AppLicationDbContext> options): base(options) { }

        #region DbSet

        #endregion

    }
}
