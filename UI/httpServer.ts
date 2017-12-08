import * as http from 'http';
import * as express from "express";
import * as path from "path";
import { NextFunction, Request, Response, Router } from "express";

class httpServer {

    private app: express.application;

    constructor(port: number) {
        this.app = express();
        this.serverMiddlewareConfig();
        this.serverRoutes();

        this.app.set("port", port);
        this.app.listen(port, () => {
            console.log("Listening on port " + port);
        });
    }

    public serverMiddlewareConfig(): void {
        this.app.use(express.static(path.join(__dirname, "dist")));
    }

    public serverRoutes(): void {
        let router: express.router = express.Router();

        // Home
        router.get('/**', (req: Request, res: Response, next: NextFunction) => {
            res.sendFile("dist/index.html", { root: __dirname });
        });
        this.app.use(router);
    }

    public static bootstrap(port: number): httpServer {
        return new httpServer(port);
    }
}
export default  httpServer.bootstrap(process.env.PORT || 80);
