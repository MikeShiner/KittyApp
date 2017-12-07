"use strict";
exports.__esModule = true;
var express = require("express");
var path = require("path");
var httpServer = (function () {
    function httpServer(port) {
        this.app = express();
        this.serverMiddlewareConfig();
        this.serverRoutes();
        this.app.set("port", port);
        this.app.listen(port, function () {
            console.log("Listening on port " + port);
        });
    }
    httpServer.prototype.serverMiddlewareConfig = function () {
        this.app.use(express.static(path.join(__dirname, "../dist")));
    };
    httpServer.prototype.serverRoutes = function () {
        var router = express.Router();
        // Home
        router.get('/**', function (req, res, next) {
            res.sendFile('dist/index.html', { root: __dirname });
        });
        this.app.use("/", router);
    };
    httpServer.bootstrap = function (port) {
        return new httpServer(port);
    };
    return httpServer;
}());
exports["default"] = httpServer.bootstrap(process.env.PORT || 80);
