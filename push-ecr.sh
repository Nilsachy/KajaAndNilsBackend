#!/bin/bash

# Script to build an image to pushing to ECR

echo '######## BUILDING TO IMAGE ########'
./gradlew docker
echo '######## CONNECTING TO ECR ########'
aws ecr get-login-password --region eu-west-3 | docker login --username AWS --password-stdin 971006391811.dkr.ecr.eu-west-3.amazonaws.com
echo '######## TAGGING ########'
docker tag kaja-nils-backend:latest 971006391811.dkr.ecr.eu-west-3.amazonaws.com/kaja-nils-backend:latest
echo '######## PUSHING TO ECR ########'
docker push 971006391811.dkr.ecr.eu-west-3.amazonaws.com/kaja-nils-backend:latest