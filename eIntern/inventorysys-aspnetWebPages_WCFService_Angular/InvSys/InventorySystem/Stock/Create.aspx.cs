using InventorySystem.Inventory_Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InventorySystem.Stock
{
    public partial class Create : System.Web.UI.Page
    {
        private InventoryServiceClient isc = new InventoryServiceClient();
        public List<string> departments = new List<string>();

        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                if (isc.GetProductsDD() != null)
                {
                    products.DataSource = isc.GetProductsDD();

                    foreach (string d in isc.GetProductsDD())
                    {
                        products.Items.Add(d);

                    }
                }
            }

        }
        //private void ResetBoxes()
        //{
        //    this.Alcohol.Checked = false;
        //    this.Bakery.Checked = false;
        //    this.Bulk.Checked = false;
        //    this.CoC.Checked = false;
        //    this.Dairy.Checked = false;
        //    this.Deli.Checked = false;
        //    this.Floral.Checked = false;
        //    this.FrontEnd.Checked  = false;
        //    this.Frozen.Checked  = false;
        //    this.GeneralMerchandise.Checked  = false;
        //    this.Grocery.Checked = false;
        //    this.HBC.Checked = false;
        //    this.Meat.Checked = false;
        //    this.Produce.Checked  = false;
        //    this.Seafood.Checked = false;

        //}
        private void CheckIfSelected()
        {
            
            //if (this.Alcohol.Checked == true)
            //{
            //    departments.Add("Alcohol");
            //}
            //if (this.Bakery.Checked == true)
            //{
            //    departments.Add("Bakery");
            //}
            //if (this.Bulk.Checked == true)
            //{
            //    departments.Add("Bulk");
            //}
            //if (this.CoC.Checked == true)
            //{
            //    departments.Add("Carry Out Cafe");
            //}
            //if (this.Dairy.Checked == true)
            //{
            //    departments.Add("Dairy");
            //}
            //if (this.Deli.Checked == true)
            //{
            //    departments.Add("Deli");
            //}
            //if (this.Floral.Checked == true)
            //{
            //    departments.Add("Floral");
            //}
            //if (this.FrontEnd.Checked == true)
            //{
            //    departments.Add("Front End");
            //}
            if (this.Frozen.Checked == true)
            {
                departments.Add("Frozen");
            }
            //if(this.GeneralMerchandise.Checked == true)
            //{
            //    departments.Add("General Merchandise");
            //}
            if (this.Grocery.Checked == true)
            {
                departments.Add("Grocery");
            }
            if (this.HBC.Checked == true)
            {
                departments.Add("HBC");
            }
            //if (this.Meat.Checked == true)
            //{
            //    departments.Add("Meat");
            //}
            if (this.Produce.Checked==true)
            {
                departments.Add("Produce");
            }
            //if (this.Seafood.Checked==true)
            //{
            //    departments.Add("Seafood");
            //}

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            isc.CreateStock(products.SelectedValue);

            CheckIfSelected();
            if (departments.Count != 0)
            {
                foreach(string s in departments)
                {
                    //isc.CreateInventory(s);
                    isc.UpdateInventory(s,products.SelectedValue);
                }
            }

            //this.FindControl("cb_health");
        }
    }
}