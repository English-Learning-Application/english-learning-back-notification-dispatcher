aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin 761018889743.dkr.ecr.ap-southeast-2.amazonaws.com
docker build -t course-microservice .
docker tag course-microservice:latest 761018889743.dkr.ecr.ap-southeast-2.amazonaws.com/course-microservice:latest
docker push 761018889743.dkr.ecr.ap-southeast-2.amazonaws.com/course-microservice:latest
kubectl delete deployment course-service-deployment
kubectl apply -f deployment.yaml