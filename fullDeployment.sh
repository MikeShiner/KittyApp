echo "Auto Deployment Start."
echo "-----------------------"
echo "*** Server Upgrade ***"
echo "**********************"
# Server upgrade
cd Server
# Maven build microserver
mvn package
# Deploy jar in docker container
sudo ./dockerDeploy.sh

echo "-----------------------"
echo "*** UI Upgrade ***"
echo "**********************"
cd ../UI
# Build Angular frontend
sudo ng build --env=prod
# Build HttpServer
cd webserver
tsc httpServer.ts
# Remove any running instances of webserver.js
sudo kill $(ps aux | grep 'httpServer.js' | awk '{print $2}')
# Start Node process in background
sudo nohup node httpServer.js > ~/webserver.log &
