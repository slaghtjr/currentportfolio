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
    public class Order
    {
        [DatabaseGenerated(databaseGeneratedOption: DatabaseGeneratedOption.Identity)]
        public int OrderID { get; set; }
        [Required]
        [DataMember]
        public virtual ICollection<Stock> OrderedStock { get; set; }
        public virtual OrderStatus Status { get; set; }
    }
}