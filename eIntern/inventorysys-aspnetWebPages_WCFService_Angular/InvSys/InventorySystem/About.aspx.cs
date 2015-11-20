using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InventorySystem
{
    public partial class About : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            //if (!IsPostBack) this if statement makes sure this isn't a postback from an ajax call
               //load all depts
           



        }

        protected void mygv_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void mydropdown_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch (mydropdown.SelectedValue)
            {
                case "people":
                    mygv.DataSource = new List<string>() {"Ben", "Jake", "Keni"  };
                    break;
                case "places":
                    mygv.DataSource = new List<string>() { "eIntern", "finland", "the bed" };
                    break;
                default:
                    break;
            }

            mygv.DataBind();
        }
    }
}