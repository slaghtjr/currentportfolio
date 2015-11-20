//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Redux_Appts.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Prescription
    {
        public int ID { get; set; }
        public string Directions { get; set; }
        public int Quantity { get; set; }
        public int Doctor_ID { get; set; }
        public int Medication_ID { get; set; }
        public int Patient_ID { get; set; }
        public Nullable<int> Appointment_ID { get; set; }
    
        public virtual Appointment Appointment { get; set; }
        public virtual Doctor Doctor { get; set; }
        public virtual Medication Medication { get; set; }
        public virtual Patient Patient { get; set; }
    }
}