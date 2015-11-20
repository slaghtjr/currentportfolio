using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using InventorySystem.Inventory_Service;


namespace InventorySystem.Pages
{
    public partial class Inventory : System.Web.UI.Page
    {
        private InventoryServiceClient isc = new InventoryServiceClient();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (isc.GetDepartmentNames() != null)
                {
                    departments.DataSource = isc.GetDepartmentNames();

                    foreach (string d in isc.GetDepartmentNames())
                    {
                        departments.Items.Add(d);

                    }
                }
                inv_gv.DataSource = isc.RetrieveAllInventory();
                inv_gv.DataBind();
            }
        }

        protected void departments_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (departments.SelectedValue != "All Departments")
            {
                inv_gv.DataSource = isc.RetrieveInventory(departments.SelectedValue);
            }
            else
            {
                inv_gv.DataSource = isc.RetrieveAllInventory();
            }
            inv_gv.DataBind();
        }

        protected void inv_gv_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}