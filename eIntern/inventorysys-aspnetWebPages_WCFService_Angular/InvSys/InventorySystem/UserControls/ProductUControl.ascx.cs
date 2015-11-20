using InventorySystem;
using InventorySystem.Inventory_Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InventorySystem.UserControls
{
    public partial class ProductUControl : UserControl
    {
        private InventoryServiceClient isc = new InventoryServiceClient();

        public List<Product> products { get; set; }
        public string product
        {
            get { return product; }
            set
            {
                products = isc.GetProducts(value).ToList();
            }
        }
        public int orderNumber { get; set; }

        protected void Page_Load(object sender, EventArgs e)
        {
            foreach (Product p in products)
            {
                Console.WriteLine("The Product Name is: " + p.ProductName);
                pName.Text = p.ProductName;
            }
        }


    }
}