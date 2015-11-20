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
using Microsoft.AspNet.Identity.Owin;
using Microsoft.AspNet.Identity;

namespace Redux_Appts.Controllers
{
    public class PatientsController : Controller
    {
        private ApptsDBEntities db = new ApptsDBEntities();

        // GET: Patients
        public ActionResult Index()
        {
            var patients = db.Patients.Include(p => p.AspNetUser);
            return View(patients.ToList());
        }

        // GET: Patients/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Patient patient = db.Patients.Find(id);
            if (patient == null)
            {
                return HttpNotFound();
            }
            return View(patient);
        }

        // GET: Patients/Create
        public ActionResult Create()
        {
            ViewBag.UserID = new SelectList(db.AspNetUsers, "Id", "Email");
            return View();
        }

        // POST: Patients/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,FirstName,LastName,Username")] Patient patient)
        {
            DBContext temp = new DBContext();
            if (ModelState.IsValid)
            {
                   if (db.Patients.Where(p=>p.Username == patient.Username).Count()==0)
                    {
                        ApplicationUser newUser = new ApplicationUser
                        {
                            Email = patient.Username,
                            UserName = patient.Username
                        };
                        ApplicationUserManager UserManager = HttpContext.GetOwinContext().GetUserManager<ApplicationUserManager>();
                        UserManager.Create(newUser, "Password1!");
                        var currentUser = UserManager.FindByName(patient.Username);
                        UserManager.AddToRole(currentUser.Id, "Patient");
                        db.Patients.Add(patient);
                        db.SaveChanges();
                        return RedirectToAction("PatientDoctor");
                    }
                    else
                    {
                        return View("PatientExists");
                    }
            }
            return View(patient);
        }

        // GET: Patients/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Patient patient = db.Patients.Find(id);
            if (patient == null)
            {
                return HttpNotFound();
            }
            ViewBag.UserID = new SelectList(db.AspNetUsers, "Id", "Email", patient.UserID);
            return View(patient);
        }

        // POST: Patients/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,FirstName,LastName,DisplayName,UserID")] Patient patient)
        {
            if (ModelState.IsValid)
            {
                db.Entry(patient).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("PatientDoctor");
            }
            ViewBag.UserID = new SelectList(db.AspNetUsers, "Id", "Email", patient.UserID);
            return View(patient);
        }

        // GET: Patients/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Patient patient = db.Patients.Find(id);
            if (patient == null)
            {
                return HttpNotFound();
            }
            return View(patient);
        }

        // POST: Patients/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Patient patient = db.Patients.Find(id);
            db.Patients.Remove(patient);
            db.SaveChanges();
            return RedirectToAction("PatientDoctor");
        }

        public ActionResult PatientDoctor()
        {
            ApptsDBEntities db = new ApptsDBEntities();
            MixedModel mm = new MixedModel();
            return View(db.Patients.ToList());
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
