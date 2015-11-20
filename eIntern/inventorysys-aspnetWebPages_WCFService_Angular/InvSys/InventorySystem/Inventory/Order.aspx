<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Order.aspx.cs" Inherits="InventorySystem.Inventory.Order" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <asp:DropDownList ID="departments" runat="server"></asp:DropDownList>
    <asp:Button ID="btnOrder" runat="server" Text="Submit Order" />

</asp:Content>
