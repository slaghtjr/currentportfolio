using InventorySystem.Inventory_Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InventorySystem.Inventory
{
    public partial class Order : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            InventoryServiceClient isc = new InventoryServiceClient();

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
            }
        }
    }
}