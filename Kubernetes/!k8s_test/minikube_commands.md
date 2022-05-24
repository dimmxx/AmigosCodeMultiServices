

minikube start
minikube start --nodes=2
minikube status
minikube ssh
minikube stop
minikube delete

kubectl get all
kubectl get all -A
kubectl get nodes
kubectl get pods
kubectl get pods -A
kubectl get pods -w

kubectl apply -f .

kubectl get pod hello-world
kubectl get pod hello-world -o wide
kubectl get pod hello-world --output wide [yaml, json]

kubectl logs hello-world
kubectl logs hello-world -c ola-mundo

kubectl exec -it hello-world -- bin/bash
kubectl exec -it hello-world -c hello-world -- bin/bash
kubectl exec hello-world -c hello-world -- ls

kubectl delete pod hello-world
kubectl delete -f pod.yml

kubectl run hello-world1 --image=amigoscode/kubernetes:hello-world --port=80

kubectl port-forward hello-world 9090:80
kubectl port-forward pod/hello-world 9090:80
kubectl port-forward service/some-service 9090:80
kubectl port-forward deployment/some-service 9090:80

kubectl api-resources

kubectl --help

kubectl get deployments

kubectl get services -w

kubectl get endpoints

kubectl get ep

kubectl describe deployment hello-world
kubectl delete deployment hello-world

kubectl get rs hello-wolrd-78gfg
kubectl describe rs hello-wolrd-78gfg
kubectl delete rs hello-wolrd-78gfg