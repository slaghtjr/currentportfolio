<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="Index.aspx.cs" Inherits="InventorySystem.Pages.Inventory" %>

 <asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
        <asp:DropDownList runat="server" ID="departments" AutoPostBack="true" OnSelectedIndexChanged="departments_SelectedIndexChanged"  AppendDataBoundItems="true">
            <asp:ListItem Value="All Departments">All Departments</asp:ListItem>
        </asp:DropDownList>


     <asp:UpdatePanel runat="server" UpdateMode="Conditional">
         <Triggers>
            <asp:AsyncPostBackTrigger  ControlID="departments" />
         </Triggers>

        <ContentTemplate>
            <asp:GridView runat="server" ID ="inv_gv" OnSelectedIndexChanged="inv_gv_SelectedIndexChanged">
            </asp:GridView>
        </ContentTemplate>
     </asp:UpdatePanel>

</asp:Content>

