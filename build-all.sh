#!/bin/bash

set -e

SERVICES=(
    configManage
    serviceRegistry
    ApiGateWay
    UserService
    HotelService
    RatingService
)

echo "Building all Spring Boot services..."

for service in "${SERVICES[@]}"
do
    echo ""
    echo "====================================="
    echo "Building $service"
    echo "====================================="

    cd "$service"

    if [ -f "./mvnw" ]; then
        chmod +x mvnw
        ./mvnw clean package -DskipTests
    else
        mvn clean package -DskipTests
    fi

    cd ..
done

echo ""
echo "All JAR files built successfully."
