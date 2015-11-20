<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Create.aspx.cs" Inherits="InventorySystem.Stock.Create" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <asp:UpdatePanel ID="UpdatePanel1" runat="server">
        <Triggers>
            <asp:AsyncPostBackTrigger  ControlID="btnSubmit" />
        </Triggers>
        <ContentTemplate>
            <asp:DropDownList runat="server" ID="products" AutoPostBack="true" AppendDataBoundItems="true">
                <asp:ListItem Value="All Products">All Products</asp:ListItem>
            </asp:DropDownList>
<%--            <div class="well btn-primary" id="added">
            <p>Product Added.</p>
            </div>    --%>
            <div class="well">
                <asp:Panel ID="deptsboxes" runat="server">
                    <table>
                        <tr><td><asp:CheckBox ID="Produce" Text="Produce" runat="server"/></td>
                            <td><asp:CheckBox ID="Frozen" Text="Frozen" runat="server"/></td>
                            <td><asp:CheckBox ID="HBC" Text="HBC" runat="server"/></td>
                            <td><asp:CheckBox ID="Grocery" Text="Grocery" runat="server"/></td>
                        </tr>
                        <%--<tr><td><asp:CheckBox ID="Alcohol" Text="Alcohol" runat="server"/></td><td>
                        <asp:CheckBox ID="Bakery" Text="Bakery" runat="server" /></td><td>
                        <asp:CheckBox ID="Bulk" Text="Bulk" runat="server" /></td></tr>
                        <tr><td><asp:CheckBox ID="CoC" Text="CoC" runat="server" /></td><td>
                        <asp:CheckBox ID="Dairy" Text="Dairy" runat="server" /></td><td>
                        <asp:CheckBox ID="Deli" Text="Deli" runat="server" /></td></tr>
                        <tr><td><asp:CheckBox ID="Floral"  Text="Floral" runat="server" />    </td><td>
                        <asp:CheckBox ID="FrontEnd" Text="FrontEnd" runat="server" />      </td><td> 
                        <asp:CheckBox ID="Frozen" Text="Frozen" runat="server" /></td></tr>
                        <tr><td><asp:CheckBox ID="GeneralMerchandise" Text="General Merchandise" runat="server" /></td><td>
                        <asp:CheckBox ID="Grocery" Text="Grocery" runat="server" /></td><td>
                        <asp:CheckBox ID="HBC" Text="HBC" runat="server" /></td></tr>
                        <tr><td><asp:CheckBox ID="Meat"  Text="Meat" runat="server" /></td><td>
                        <asp:CheckBox ID="Produce"  Text="Produce" runat="server" /></td><td>
                        <asp:CheckBox ID="Seafood" Text="Seafood" runat="server" /></td></tr>--%>
                    </table>
                </asp:Panel>
            </div>
        </ContentTemplate>
    </asp:UpdatePanel>
    <asp:Button ID="btnSubmit" runat="server" Text="Create Stock" CssClass="btn btn-primary" OnClick="btnSubmit_Click" />
</asp:Content>
