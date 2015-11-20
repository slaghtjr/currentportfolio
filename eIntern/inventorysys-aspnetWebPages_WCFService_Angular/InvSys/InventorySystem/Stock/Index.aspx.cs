using InventorySystem.Inventory_Service;
using InventorySystem.UserControls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Services;
using System.Web.Services;
using System.Web.UI;

namespace InventorySystem.Pages
{
    public partial class Stock : System.Web.UI.Page
    {
        private static InventoryServiceClient isc = new InventoryServiceClient();

        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {

            }
        }

        [WebMethod]
        public static string[] GetProductNames(string prefixText, int count)
        {
            return isc.GetProductNames(prefixText).ToArray();
            }

        protected void productsInput_TextChanged(object sender, EventArgs e)
        {

        }

        protected void btnSearch_Click(object sender, EventArgs e)
        {
            List<string> s = new List<string>();
            string stk = isc.RetrieveStock(productsInput.Text);
            s.Add(stk);
            product_output.DataSource = s;
            product_output.DataBind();
        }
    }
}