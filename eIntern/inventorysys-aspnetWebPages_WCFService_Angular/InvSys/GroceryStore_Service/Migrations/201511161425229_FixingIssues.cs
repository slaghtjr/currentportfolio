namespace GroceryStore_Service.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FixingIssues : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Stocks", "OrderNumber");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Stocks", "OrderNumber", c => c.Int(nullable: false));
        }
    }
}
