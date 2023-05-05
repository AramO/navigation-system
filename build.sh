#!/bin/bash

mvn clean package
docker-compose build
