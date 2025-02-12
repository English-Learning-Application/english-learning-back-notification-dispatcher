#!/bin/bash

aws codebuild create-project \
    --name notification-dispatcher-service-build \
    --source type=GITHUB,location=https://github.com/English-Learning-Application/english-learning-back-notification-dispatcher.git \
    --artifacts type=NO_ARTIFACTS \
    --environment type=LINUX_CONTAINER,computeType=BUILD_GENERAL1_SMALL,image=aws/codebuild/standard:5.0 \
    --service-role arn:aws:iam::761018889743:role/CodeBuildServiceRole
