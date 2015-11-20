<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="ProductUControl.ascx.cs" Inherits="InventorySystem.UserControls.ProductUControl" %>

<div class="well">
    <asp:Label ID="pName" runat="server"></asp:Label>
    (<asp:Label ID="oNumber" runat="server" Text="----"></asp:Label>)
    <%--    <p>Quantity on Floor: <asp:Label ID="qFloor" runat="server" Text="----"></asp:Label></p>
    <p>Quantity in Backroom:<asp:Label ID="qBackroom" runat="server" Text="----"></asp:Label> </p>--%>
</div>
