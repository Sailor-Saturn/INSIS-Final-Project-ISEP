0 - brew install minikube kubectl
1 - minikube start
2 - minikube enable metrics-server
2 - kubectl apply -f .

Running on minikube:

1 - kubectl get po -n tea-earl-grey-hot // pod status
1.5 - kubectl describe po <pod-name> -n tea-earl-grey-hot // detailed status of a pod
2 - kubectl get svc -n tea-earl-grey-hot // service status
2.5 - kubectl describe svc <service-name> -n tea-earl-grey-hot // detailed status of a service
3 - minikube service <svc-name> --url -n tea-earl-grey-hot // open tunnel to an existing service
4 - kubectl exec -it <pod-name> -- bash -n tea-earl-grey-hot // get a shell into a pod

Running on a real cluster
1 - kubectl get po -n tea-earl-grey-hot // pod status
2 - kubectl get svc -n tea-earl-grey-hot // service status
3 - http(s)://<any-node-ip>:<nodeport-ip> - access pods behind a service

Files explained:

ns.yaml - creates a kubernetes namespace to logically separate the environment (since this is the only environment, this is only here to look "pro" and "pretty")
deployment.yaml - creates a deployment which creates pods according to a given spec. Can handle replication and (more relevantly probs) rolling deploys
service.yaml - expose the above to the outside. Normally uses type NodePort (a high port opened automatically in the nodes) in dev, and type LoadBalancer in prod. Goes like user -> entry service NodePort/LB -> internal services / Internal services use type ClusterIp
hpa.yaml - scales the deployment based on a metric (cpu is built-in). Just to ensure we fulfill the "elasticity" requirement
secrets.yaml - secrets that can be mounted as env vars or files in the pods
    - values must be encoded as base64
    - use for stuff that is supposed to be kept secret
    - encode: echo VALUE | base64
    - decode: echo ENCODED_VALUE | base64 -d
    - kubernetes decodes automatically for the pods
    - this file should never be committed to VC
    - mounted in deployment.yaml
configmap.yaml - configuration variables that can be mounted as env vars or files in the pods
    - values in plaintext
    - use for "safe" config values such as URLs
    - mounted in deployment.yaml

Dns Resolution:

Use the service name to reach the services within the cluster