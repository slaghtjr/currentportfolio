using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Redux_Appts.Startup))]
namespace Redux_Appts
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
