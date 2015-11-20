﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace GroceryStore_Service.Models
{
    [DataContract]
    public class Product
    {
        [DatabaseGenerated(databaseGeneratedOption: DatabaseGeneratedOption.Identity)]
        public int ProductID { get; set; }
        [Required]
        [DataMember]
        public string ProductName { get; set; }
    }
}