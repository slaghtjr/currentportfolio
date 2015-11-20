using GroceryStore_Service.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Activation;
using System.Text;

namespace GroceryStore_Service.Services
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IInventoryService" in both code and config file together.
    [ServiceContract]
    public interface IInventoryService
    {
        #region Inventory Based Services

        [OperationContract]
        void CreateInventory(string departmentName); //Create Inventory creates an Inventory for each Department.

        [OperationContract]
        List<string> RetrieveInventory(string departmentName); //Retrieves existing data for the department's inventory

        [OperationContract]
        void UpdateInventory(string departmentName, string stock); //Add or Remove Items from the Inventory

        [OperationContract]
        void DeleteInventory(string departmentName, string stock); //Deletes a full inventory from a department

        [OperationContract]
        List<string> RetrieveAllInventory(); //Retrieves existing data for the department's inventory

        #endregion Inventory Based Services

        #region Stock Based Services
        [OperationContract]
        void CreateStock(string productName); //Create a Product

        [OperationContract]
        string RetrieveStock(string productName);//Retrieves existing data for a Product

        [OperationContract]
        void UpdateStock(string productName); //Update a Product

        [OperationContract]
        void DeleteStock(string productName); //Deletes a Product, sets it to discontinued
        #endregion Stock Based Services

        [OperationContract]
        [System.ServiceModel.Web.WebInvoke(Method = "POST", ResponseFormat = System.ServiceModel.Web.WebMessageFormat.Json)]
        List<string> GetProductNames(string prefixName);


        [OperationContract]
        List<string> GetProductsDD();

        [OperationContract]
        List<Product> GetProducts(string product);

        [OperationContract]
        List<string> GetDepartmentNames();
    }
}

