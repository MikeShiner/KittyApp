FROM openjdk:8-jre-alpine
VOLUME /config

# Install curl
RUN apk update \
    && apk add curl \
    # Clean package cache
    && rm -rf /var/cache/apk/*

MAINTAINER Mike Shiner <mike.shiner@hotmail.com>
LABEL description="kittyapp"

# Expose port for API
EXPOSE 8080

RUN mkdir -p /kittyapp
# Creates a symlink directory appearing at /kittyapp/config
RUN ln -s /config /kittyapp

# Prepare the service itself
COPY target/kittyapp.jar /kittyapp/kittyapp.jar
WORKDIR /kittyapp
CMD ["java","-jar","./kittyapp.jar"]
