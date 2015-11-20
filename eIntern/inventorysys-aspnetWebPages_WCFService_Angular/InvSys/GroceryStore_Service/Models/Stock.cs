using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace GroceryStore_Service.Models
{
    [DataContract]
    public class Stock
    {
        [DatabaseGenerated(databaseGeneratedOption: DatabaseGeneratedOption.Identity)]
        public int StockID { get; set; }

        [Required]
        [DataMember]
        public virtual Product Product { get; set; }
        [DataMember]
        public int Count { get; set; }
        [DataMember]
        public virtual Department Department { get; set; }
        [DataMember]
        public bool IsDisc { get; set; }

        public override string ToString()
        {
            string s = string.Format("{0} (#{1}): {2} in stock. Product is Discontinued: {3}.",Product.ProductName,StockID,Count, IsDisc);
            return s;
        }
    }
}