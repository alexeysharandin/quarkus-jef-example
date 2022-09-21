#!/bin/bash
mvn compile quarkus:dev -Dmaven.test.skip=true -DdebugHost=0.0.0.0