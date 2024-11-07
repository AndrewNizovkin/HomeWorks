#!/bin/bash
docker run -d --name postgres-container -e POSTGRES_DB=walletsdb -e POSTGRES_USER=tester -e POSTGRES_PASSWORD=1234 -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres:alpine3.19
