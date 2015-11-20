namespace Redux_Appts
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using Redux_Appts.Models;

    public partial class DBContext : DbContext
    {
        public DBContext()
            : base("name=ApptsDBEntities")
        {
        }

        public virtual DbSet<C__MigrationHistory> C__MigrationHistory
        {
            get; set;
        }
        public virtual DbSet<Appointment> Appointments
        {
            get; set;
        }
        public virtual DbSet<AspNetRole> AspNetRoles
        {
            get; set;
        }
        public virtual DbSet<AspNetUserClaim> AspNetUserClaims
        {
            get; set;
        }
        public virtual DbSet<AspNetUserLogin> AspNetUserLogins
        {
            get; set;
        }
        public virtual DbSet<AspNetUser> AspNetUsers
        {
            get; set;
        }
        public virtual DbSet<Doctor> Doctors
        {
            get; set;
        }
        public virtual DbSet<Medication> Medications
        {
            get; set;
        }
        public virtual DbSet<Patient> Patients
        {
            get; set;
        }
        public virtual DbSet<Prescription> Prescriptions
        {
            get; set;
        }
        public virtual DbSet<sysdiagram> sysdiagrams
        {
            get; set;
        }

        //protected override void OnModelCreating(DbModelBuilder modelBuilder)
        //{
        //    modelBuilder.Entity<Appointment>()
        //        .HasMany(e => e.Prescriptions)
        //        .WithOptional(e => e.Appointment)
        //        .HasForeignKey(e => e.Appointment_ID);

        //    modelBuilder.Entity<AspNetRole>()
        //        .HasMany(e => e.AspNetUsers)
        //        .WithMany(e => e.AspNetRoles)
        //        .Map(m => m.ToTable("AspNetUserRoles").MapLeftKey("RoleId").MapRightKey("UserId"));

        //    modelBuilder.Entity<AspNetUser>()
        //        .HasMany(e => e.AspNetUserClaims)
        //        .WithRequired(e => e.AspNetUser)
        //        .HasForeignKey(e => e.UserId);

        //    modelBuilder.Entity<AspNetUser>()
        //        .HasMany(e => e.AspNetUserLogins)
        //        .WithRequired(e => e.AspNetUser)
        //        .HasForeignKey(e => e.UserId);

        //    modelBuilder.Entity<AspNetUser>()
        //        .HasMany(e => e.Doctors)
        //        .WithOptional(e => e.AspNetUser)
        //        .HasForeignKey(e => e.User_ID);

        //    modelBuilder.Entity<AspNetUser>()
        //        .HasMany(e => e.Patients)
        //        .WithOptional(e => e.AspNetUser)
        //        .HasForeignKey(e => e.UserID);

        //    modelBuilder.Entity<Doctor>()
        //        .HasMany(e => e.Appointments)
        //        .WithRequired(e => e.Doctor)
        //        .HasForeignKey(e => e.Doctor_ID);

        //    modelBuilder.Entity<Doctor>()
        //        .HasMany(e => e.Prescriptions)
        //        .WithRequired(e => e.Doctor)
        //        .HasForeignKey(e => e.Doctor_ID);

        //    modelBuilder.Entity<Doctor>()
        //        .HasMany(e => e.Patients)
        //        .WithMany(e => e.Doctors)
        //        .Map(m => m.ToTable("PatientsDoctors").MapLeftKey("DoctorID").MapRightKey("PatientID"));

        //    modelBuilder.Entity<Medication>()
        //        .HasMany(e => e.Prescriptions)
        //        .WithRequired(e => e.Medication)
        //        .HasForeignKey(e => e.Medication_ID);

        //    modelBuilder.Entity<Patient>()
        //        .HasMany(e => e.Appointments)
        //        .WithRequired(e => e.Patient)
        //        .HasForeignKey(e => e.Patient_ID);

        //    modelBuilder.Entity<Patient>()
        //        .HasMany(e => e.Prescriptions)
        //        .WithRequired(e => e.Patient)
        //        .HasForeignKey(e => e.Patient_ID);
        //}
    }
}
