using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using GroceryStore_Service.Models;
using System.ServiceModel.Activation;
using System.Web.Script.Services;

namespace GroceryStore_Service.Services
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "InventoryService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select InventoryService.svc or InventoryService.svc.cs at the Solution Explorer and start debugging.

    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    [ScriptService]
    public class InventoryService : IInventoryService
    {

        private StoreDBContext db = new StoreDBContext();
        #region Inventory
        public void CreateInventory(string departmentName)
        {
//            db.Department.Find(departmentName).Inventory=;
        }
        public List<string> RetrieveInventory(string departmentName)
        {
            List<string> inventory = new List<string>();

            foreach(Stock s in db.Department.Where(d => d.DepartmentName == departmentName).First().Inventory)
            {
                inventory.Add(s.ToString());
            }
            return inventory;
        }

        public void UpdateInventory(string departmentName, string stock)
        {
            Stock stk = db.Stock.Where(s => s.Product.ProductName == stock).First();

            Department dpt = db.Department.Where(d => d.DepartmentName == departmentName).First();
            dpt.Inventory.Add(stk);
            db.SaveChanges();
        }
        public void DeleteInventory(string departmentName, string stock)
        {
            throw new NotImplementedException();
        }
        public List<string> RetrieveAllInventory()
        {
            List<string> s = new List<string>();

            foreach(Department d in db.Department)
            {
                foreach(Stock stk in d.Inventory)
                {
                    s.Add(stk.ToString());
                }
            }
            return s;
        }
        #endregion

        #region Stock
        public void CreateStock(string productName)
        {
            Product p = db.Product.Where(pt => pt.ProductName == productName).First();
            db.Stock.Add(new Stock() { Product = p, Count = 10, IsDisc = false });
            db.SaveChanges();
        }
        public string RetrieveStock(string productName)
        {
            return db.Stock.Where(p=>p.Product.ProductName== productName).First().ToString();
        }
        public void UpdateStock(string productName)
        {
            Stock s = db.Stock.Find(productName);
        }
        public void DeleteStock(string productName)
        {
            if(db.Stock.Find(productName).IsDisc == false)
            {
                db.Stock.Find(productName).IsDisc = true;
            }
            else
            {
                db.Stock.Find(productName).IsDisc = false;
            }
            db.SaveChanges();
        }
        #endregion




        public List<string> GetDepartmentNames()
        {
            List<string> dNames = new List<string>();

            foreach (Department d in db.Department)
            {
                dNames.Add(d.DepartmentName);
            }
            return dNames;
        }

        public List<string> GetProductNames(string prefixName)
        {
            List<string> pNames = new List<string>();

            foreach(Product p in db.Product)
            {
                if(p.ProductName.Contains(prefixName))
                {
                    pNames.Add(p.ProductName);
                }
            }
            return pNames;
        }

        public List<Product> GetProducts(string product)
        {
            throw new NotImplementedException();
        }
        public List<string> GetProductsDD()
        {
            List<string> pNames = new List<string>();

            foreach (Product p in db.Product)
            {
                pNames.Add(p.ProductName);
            }
            return pNames;

        }


        
    }
}
