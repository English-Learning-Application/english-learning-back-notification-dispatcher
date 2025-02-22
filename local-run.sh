docker build -t notification-dispatcher-microservice .
minikube image load notification-dispatcher-microservice:latest
kubectl delete secret dispatcher-service-secret
kubectl create secret generic dispatcher-service-secret --from-env-file=local.env
kubectl delete deployment dispatcher-service-deployment
kubectl apply -f local-deployment.yaml