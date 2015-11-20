using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Redux_Appts.Models
{
    public class MixedModel
    {
        private DBContext db = new DBContext();

        public DBContext DB
        {
            get
            {
                return db;
            }
        }
        public List<Patient> Patients
        {
            get
            {
                return db.Patients.ToList();
            }
        }
        public List<Doctor> Doctors
        {
            get
            {
                return db.Doctors.ToList();
            }
        }
        public List<AspNetUser> Users
        {
            get
            {
                return db.AspNetUsers.ToList();
            }
        }
        public List<Appointment> Appointments
        {
            get
            {
                return db.Appointments.ToList();
            }
        }
        public List<Prescription> Prescriptions
        {
            get
            {
                return db.Prescriptions.ToList();
            }
        }
    }
}