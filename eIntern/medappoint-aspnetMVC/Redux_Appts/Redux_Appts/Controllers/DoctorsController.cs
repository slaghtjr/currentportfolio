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
    public class DoctorsController : Controller
    {
        private DBContext db = new DBContext();

        // GET: Doctors
        public ActionResult Index()
        {
            //var doctors = db.Doctors.Include(d => d.AspNetUser);
            return View(/*doctors.ToList()*/);
        }

        // GET: Doctors/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Doctor doctor = db.Doctors.Find(id);
            if (doctor == null)
            {
                return HttpNotFound();
            }
            return View(doctor);
        }

        // GET: Doctors/Create
        public ActionResult Create()
        {
            ViewBag.User_ID = new SelectList(db.AspNetUsers, "Id", "Email");
            return View();
        }

        // POST: Doctors/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,FirstName,LastName,Username,User_ID")] Doctor doctor)
        {
            if (ModelState.IsValid)
            {
                if (db.Doctors.Where(d => d.Username == doctor.Username).Count() == 0)
                {
                    ApplicationUser newUser = new ApplicationUser
                    {
                        Email = doctor.Username,
                        UserName = doctor.Username
                    };

                    ApplicationUserManager UserManager = HttpContext.GetOwinContext().GetUserManager<ApplicationUserManager>();
                    UserManager.Create(newUser, "Password1!");
                    var currentUser = UserManager.FindByName(doctor.Username);
                    UserManager.AddToRole(currentUser.Id, "Doctor");
                    db.Doctors.Add(doctor);
                    db.SaveChanges();
                    return RedirectToAction("DoctorPatient");
                }
                else
                {
                    return View("DoctorExists");
                }
            }

            return View(doctor);
        }

        // GET: Doctors/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Doctor doctor = db.Doctors.Find(id);
            if (doctor == null)
            {
                return HttpNotFound();
            }
            ViewBag.User_ID = new SelectList(db.AspNetUsers, "Id", "Email", doctor.User_ID);
            return View(doctor);
        }

        // POST: Doctors/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,FirstName,LastName,DisplayName,User_ID")] Doctor doctor)
        {
            if (ModelState.IsValid)
            {
                db.Entry(doctor).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.User_ID = new SelectList(db.AspNetUsers, "Id", "Email", doctor.User_ID);
            return View(doctor);
        }

        // GET: Doctors/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Doctor doctor = db.Doctors.Find(id);
            if (doctor == null)
            {
                return HttpNotFound();
            }
            return View(doctor);
        }
        public ActionResult DoctorPatient()
        {
            MixedModel mm = new MixedModel();
            return View(mm);
        }
        // POST: Doctors/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Doctor doctor = db.Doctors.Find(id);
            db.Doctors.Remove(doctor);
            db.SaveChanges();
            return RedirectToAction("DoctorPatient");
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
