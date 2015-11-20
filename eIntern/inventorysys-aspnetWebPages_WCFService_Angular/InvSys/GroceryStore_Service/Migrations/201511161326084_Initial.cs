namespace GroceryStore_Service.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Departments",
                c => new
                    {
                        DepartmentID = c.Int(nullable: false, identity: true),
                        DepartmentName = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.DepartmentID);
            
            CreateTable(
                "dbo.Stocks",
                c => new
                    {
                        StockID = c.Int(nullable: false, identity: true),
                        Count = c.Int(nullable: false),
                        OrderNumber = c.Int(nullable: false),
                        IsDisc = c.Boolean(nullable: false),
                        Department_DepartmentID = c.Int(),
                        Product_ProductID = c.Int(nullable: false),
                        Order_OrderID = c.Int(),
                    })
                .PrimaryKey(t => t.StockID)
                .ForeignKey("dbo.Departments", t => t.Department_DepartmentID)
                .ForeignKey("dbo.Products", t => t.Product_ProductID, cascadeDelete: true)
                .ForeignKey("dbo.Orders", t => t.Order_OrderID)
                .Index(t => t.Department_DepartmentID)
                .Index(t => t.Product_ProductID)
                .Index(t => t.Order_OrderID);
            
            CreateTable(
                "dbo.Products",
                c => new
                    {
                        ProductID = c.Int(nullable: false, identity: true),
                        ProductName = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.ProductID);
            
            CreateTable(
                "dbo.Orders",
                c => new
                    {
                        OrderID = c.Int(nullable: false, identity: true),
                        Status_OrderStatusID = c.Int(),
                        Department_DepartmentID = c.Int(),
                    })
                .PrimaryKey(t => t.OrderID)
                .ForeignKey("dbo.OrderStatus", t => t.Status_OrderStatusID)
                .ForeignKey("dbo.Departments", t => t.Department_DepartmentID)
                .Index(t => t.Status_OrderStatusID)
                .Index(t => t.Department_DepartmentID);
            
            CreateTable(
                "dbo.OrderStatus",
                c => new
                    {
                        OrderStatusID = c.Int(nullable: false, identity: true),
                        StatusName = c.String(nullable: false),
                        StatusDescription = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.OrderStatusID);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Orders", "Department_DepartmentID", "dbo.Departments");
            DropForeignKey("dbo.Orders", "Status_OrderStatusID", "dbo.OrderStatus");
            DropForeignKey("dbo.Stocks", "Order_OrderID", "dbo.Orders");
            DropForeignKey("dbo.Stocks", "Product_ProductID", "dbo.Products");
            DropForeignKey("dbo.Stocks", "Department_DepartmentID", "dbo.Departments");
            DropIndex("dbo.Orders", new[] { "Department_DepartmentID" });
            DropIndex("dbo.Orders", new[] { "Status_OrderStatusID" });
            DropIndex("dbo.Stocks", new[] { "Order_OrderID" });
            DropIndex("dbo.Stocks", new[] { "Product_ProductID" });
            DropIndex("dbo.Stocks", new[] { "Department_DepartmentID" });
            DropTable("dbo.OrderStatus");
            DropTable("dbo.Orders");
            DropTable("dbo.Products");
            DropTable("dbo.Stocks");
            DropTable("dbo.Departments");
        }
    }
}
