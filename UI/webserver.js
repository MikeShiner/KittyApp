var express = require('express');
var path = require('path');
var app = express();

app.use(express.static(path.join(__dirname, 'dist')));

app.all('/', function(req, res, next) {
    // Just send the index.html for other files to support HTML5Mode
    res.sendFile('dist/index.html', { root: __dirname });
});
var port = process.env.PORT || 80;
app.listen(port, function() {
  console.log("Listening on " + port);
});