<%@ Page Title="About" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="About.aspx.cs" Inherits="InventorySystem.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <asp:DropDownList runat="server" ID="mydropdown" AutoPostBack="true" OnSelectedIndexChanged="mydropdown_SelectedIndexChanged" AppendDataBoundItems="true">
        <asp:ListItem Value="">All Departments</asp:ListItem>
        <asp:ListItem Value="people">people</asp:ListItem>

        <asp:ListItem Value="places">places</asp:ListItem>

    </asp:DropDownList>

    <asp:UpdatePanel runat="server" UpdateMode="Conditional">
        <Triggers>
            <asp:AsyncPostBackTrigger  ControlID="mydropdown" />
        </Triggers>

        <ContentTemplate>
            <asp:GridView runat="server" ID ="mygv" OnSelectedIndexChanged="mygv_SelectedIndexChanged">
            </asp:GridView>
        </ContentTemplate>


    </asp:UpdatePanel>
</asp:Content>
