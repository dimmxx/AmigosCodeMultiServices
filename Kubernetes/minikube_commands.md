

minikube start
minikube start --nodes=2
minikube status
minikube ssh
minikube stop
minikube delete

kubectl get nodes
kubectl get pods
kubectl get pods -A
kubectl describe hello-world
kubectl delete pod hello-world

kubectl run hello-world1 --image=amigoscode/kubernetes:hello-world --port=80
kubectl port-forward pod/hello-world 9090:80   

