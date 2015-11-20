namespace GroceryStore_Service.Migrations
{
    using Models;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<GroceryStore_Service.Models.StoreDBContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(GroceryStore_Service.Models.StoreDBContext context)
        {

            context.Product.AddOrUpdate(
                    p=>p.ProductName,
                    new Product{ ProductName = "Apple"},
                    new Product { ProductName = "Lipstick" },
                    new Product { ProductName = "Tootsie Pops" },
                    new Product { ProductName = "Hungryman" }
                );

            context.Department.AddOrUpdate(
                    d => d.DepartmentName,
                    new Department { DepartmentName = "Produce" },
                    new Department { DepartmentName = "HBC" },
                    new Department { DepartmentName = "Grocery" },
                    new Department { DepartmentName = "Frozen" }
                );
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //
        }
    }
}
