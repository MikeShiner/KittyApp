# build service docker image
docker build . -t kittyapp

# remove old service, if present
docker stop kittyapp || true && docker rm kittyapp || true

# deploy the new service
docker run -d --name=kittyapp \
	--restart=unless-stopped \
	-p 8080:8080 \
	-e AUTO_CONFIG=false \
	-v /config/kittyapp:/config \
	kittyapp