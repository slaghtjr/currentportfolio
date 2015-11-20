using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace GroceryStore_Service.Models
{
    public class StoreDBContext: DbContext
    {
        public DbSet<Department> Department { get; set; }
        public DbSet<Order> Order { get; set; }
        public DbSet<OrderStatus> OrderStatus { get; set; }
        public DbSet<Product> Product { get; set; }
        public DbSet<Stock> Stock { get; set; }

    }
}