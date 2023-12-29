#!/usr/bin/env bash

REPOSITORY=/home/ec2-user/rolling-paper
LOG_DIR=$REPOSITORY/logs
LOG_FILE="$LOG_DIR/$(date +'%Y%m%d%H%M').log"

if [ ! -d $LOG_DIR ]
then
  mkdir -p $LOG_DIR
fi

cd $REPOSITORY

APP_NAME=cicdproject
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME
CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할것 없음."
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

# echo "> $JAR_PATH 배포"
nohup java -jar $JAR_PATH > $LOG_FILE 2>&1 &
