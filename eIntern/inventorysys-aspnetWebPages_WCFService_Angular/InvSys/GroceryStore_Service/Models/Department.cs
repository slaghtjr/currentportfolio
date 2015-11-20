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
    public class Department
    {
        [DatabaseGenerated(databaseGeneratedOption: DatabaseGeneratedOption.Identity)]
        public int DepartmentID { get; set; }
        [Required]
        [DataMember]
        public string DepartmentName { get; set; }
        [DataMember]
        public virtual ICollection<Stock> Inventory { get; set;} 
        [DataMember]
        public virtual ICollection<Order> Orders { get; set; }
    }
}