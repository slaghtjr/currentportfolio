var port = 1337;
var connect = require('connect');
var serveStatic = require('serve-static');
var app = connect();

app.use(serveStatic('../Angular SS/POS/')).listen(port);

