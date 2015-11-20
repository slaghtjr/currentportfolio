using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Redux_Appts;
using Redux_Appts.Models;

namespace Redux_Appts.Controllers
{
    public class PrescriptionsController : Controller
    {
        private DBContext db = new DBContext();

        // GET: Prescriptions
        public ActionResult Index()
        {
            var prescriptions = db.Prescriptions.Include(p => p.Appointment).Include(p => p.Doctor).Include(p => p.Medication).Include(p => p.Patient);
            return View(prescriptions.ToList());
        }

        // GET: Prescriptions/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Prescription prescription = db.Prescriptions.Find(id);
            if (prescription == null)
            {
                return HttpNotFound();
            }
            return View(prescription);
        }

        // GET: Prescriptions/Create
        public ActionResult Create()
        {
            ViewBag.Appointment_ID = new SelectList(db.Appointments, "ID", "Description");
            ViewBag.Doctor_ID = new SelectList(db.Doctors, "ID", "FirstName");
            ViewBag.Medication_ID = new SelectList(db.Medications, "ID", "MedicationName");
            ViewBag.Patient_ID = new SelectList(db.Patients, "ID", "FirstName");
            return View();
        }

        // POST: Prescriptions/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,Directions,Quantity,Doctor_ID,Medication_ID,Patient_ID,Appointment_ID")] Prescription prescription)
        {
            if (ModelState.IsValid)
            {
                db.Prescriptions.Add(prescription);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.Appointment_ID = new SelectList(db.Appointments, "ID", "Description", prescription.Appointment_ID);
            ViewBag.Doctor_ID = new SelectList(db.Doctors, "ID", "FirstName", prescription.Doctor_ID);
            ViewBag.Medication_ID = new SelectList(db.Medications, "ID", "MedicationName", prescription.Medication_ID);
            ViewBag.Patient_ID = new SelectList(db.Patients, "ID", "FirstName", prescription.Patient_ID);
            return View(prescription);
        }

        // GET: Prescriptions/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Prescription prescription = db.Prescriptions.Find(id);
            if (prescription == null)
            {
                return HttpNotFound();
            }
            ViewBag.Appointment_ID = new SelectList(db.Appointments, "ID", "Description", prescription.Appointment_ID);
            ViewBag.Doctor_ID = new SelectList(db.Doctors, "ID", "FirstName", prescription.Doctor_ID);
            ViewBag.Medication_ID = new SelectList(db.Medications, "ID", "MedicationName", prescription.Medication_ID);
            ViewBag.Patient_ID = new SelectList(db.Patients, "ID", "FirstName", prescription.Patient_ID);
            return View(prescription);
        }

        // POST: Prescriptions/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,Directions,Quantity,Doctor_ID,Medication_ID,Patient_ID,Appointment_ID")] Prescription prescription)
        {
            if (ModelState.IsValid)
            {
                db.Entry(prescription).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Appointment_ID = new SelectList(db.Appointments, "ID", "Description", prescription.Appointment_ID);
            ViewBag.Doctor_ID = new SelectList(db.Doctors, "ID", "FirstName", prescription.Doctor_ID);
            ViewBag.Medication_ID = new SelectList(db.Medications, "ID", "MedicationName", prescription.Medication_ID);
            ViewBag.Patient_ID = new SelectList(db.Patients, "ID", "FirstName", prescription.Patient_ID);
            return View(prescription);
        }

        // GET: Prescriptions/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Prescription prescription = db.Prescriptions.Find(id);
            if (prescription == null)
            {
                return HttpNotFound();
            }
            return View(prescription);
        }

        // POST: Prescriptions/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Prescription prescription = db.Prescriptions.Find(id);
            db.Prescriptions.Remove(prescription);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
