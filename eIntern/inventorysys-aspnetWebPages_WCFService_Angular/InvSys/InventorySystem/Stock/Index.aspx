<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="Index.aspx.cs" Inherits="InventorySystem.Pages.Stock" %>
<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="ajaxToolkit"%>
<%@ Register TagPrefix="puc" TagName="ProductControl" Src="~/UserControls/ProductUControl.ascx"  %>


<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
        <a href="Create.aspx">Create Inventory Item</a><br />
       <asp:Label ID="Label1" runat="server" Text="Product Search:"></asp:Label>
       <asp:TextBox ID="productsInput" runat="server" AutoPostBack="true" AutoCompleteType="Enabled"></asp:TextBox>
       <ajaxToolkit:AutoCompleteExtender ID="AutoCompleteExtender1" MinimumPrefixLength="1" runat="server" TargetControlID="productsInput" CompletionInterval="100" ServicePath="http://localhost:65305/Stock/Index.aspx" ServiceMethod="GetProductNames" EnableCaching="false" FirstRowSelected="false"></ajaxToolkit:AutoCompleteExtender>
    <asp:Button ID="btnSearch" runat="server" Text="Search" OnClick="btnSearch_Click" />
    <asp:UpdatePanel runat="server" UpdateMode="Always">
        <Triggers>
            <asp:AsyncPostBackTrigger  ControlID="btnSearch" />
        </Triggers>

        <ContentTemplate>
            <asp:GridView runat="server" ID ="product_output" OnSelectedIndexChanged="btnSearch_Click" >
            </asp:GridView>
        </ContentTemplate>
    </asp:UpdatePanel>

</asp:Content>

