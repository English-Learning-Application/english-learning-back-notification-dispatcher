aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin 761018889743.dkr.ecr.ap-southeast-2.amazonaws.com
docker build -t notification-dispatcher-microservice .
docker tag notification-dispatcher-microservice:latest 761018889743.dkr.ecr.ap-southeast-2.amazonaws.com/notification-dispatcher-microservice:latest
docker push 761018889743.dkr.ecr.ap-southeast-2.amazonaws.com/notification-dispatcher-microservice:latest
kubectl delete deployment dispatcher-service-deployment
kubectl apply -f deployment.yaml