namespace Redux_Appts
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Web;
    using Redux_Appts.Models;
    public partial class DoctorPatientViewModel
    {
        private DBContext db = new DBContext();

        public List<Patient> Patients {get { return db.Patients.ToList();} }
        public List<Doctor> Doctors { get { return db.Doctors.ToList(); }}
        public List<AspNetUser> Users { get { return db.AspNetUsers.ToList(); }}
    }
}