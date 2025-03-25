# BookStoreApp-Distributed-Application 

<hr>

## About this project
This is an Ecommerce project still `development in progress`, where users can adds books to the cart and buy those books.

Application is being developed using Java, Spring and React.

Using Spring Cloud Microservices and Spring Boot Framework extensively to make this application distributed. 

<hr>

## Frontend Checkout Flow
![CheckOutFlow](https://user-images.githubusercontent.com/14878408/103235826-06d5ca00-4969-11eb-87c8-ce618034b4f3.gif)

## Architecture
All the Microservices are developed using spring boot. 
This spring boot applications will be registered with eureka discovery server.

FrontEnd React App makes request's to NGINX server which acts as a reverse proxy.
NGINX server redirects the requests to Zuul API Gateway. 

Zuul will route the requests to microservice
based on the url route. Zuul also registers with eureka and gets the ip/domain from eureka for microservice while routing the request. 

<hr>

## Run this project in Local Machine

>Frontend App 

Navigate to `bookstore-frontend-react-app` folder
Run below commnads to start Frontend React Application

```
yarn install
yarn start
```

>Backend Services
>
To Start Backend Services follow below steps.
>Using Intellij/Eclipse or Command Line

Import this project into IDE and run all Spring boot projects or 
build all the jars running `mvn clean install` command in root parent pom, which builds all jars.
All services will be up in the below mentioned ports.

But running this way we wont get monitoring of microservices. 
So if monitoring needed to see metrics like jvm memory, tomcat error count and other metrics.

Use below method to deploy all the services and monitoring setup in docker.

>Using Docker(Recommended)

Start Docker Engine in your machine.

Run `mvn clean install` at root of project to build all the microservices jars.

Run `docker-compose up --build` to start all the containers.

Use the `Postman Api collection` in the Postman directory. To make request to various services.

Services will be exposed in this ports

```
Api Gateway Service       : 8765
Eureka Discovery Service  : 8761
Consul Discovery          : 8500
Account Service           : 4001
Billing Service           : 5001
Catalog Service           : 6001
Order Service             : 7001
Payment Service           : 8001
```

<hr>

### Service Discovery
This project uses Eureka or Consul as Discovery service.

While running services in local, then using eureka as service discovery.

While running using docker, then consul is the service discovery. 

Reason to use Consul is it has better features and support compared to Eureka. Running services individually in local uses Eureka as service discovery because dont want to run consul agent and set it up as it becomes extra overhead to manage. Since docker-compose manages all consul stuff hence using Consul while running services in docker.

<hr>

## Deploying a Microservices Project on Kubernetes with GitLab and ArgoCD
### Overviews
After completing the CI (Continuous Integration) process, I built and pushed Docker images for each microservice to a container registry. To deploy the project in a Kubernetes environment, I defined the required configurations using manifest files.

### Kubernetes Resources
The project includes the following Kubernetes resources:
- Secret & ConfigMap: Store configuration information and sensitive data.
- Deployment: Declare and manage the lifecycle of services.

- Service: Define how services communicate within the cluster.

- Ingress: Configure access routes from external sources to services within the cluster.

- PersistentVolume (PV) & PersistentVolumeClaim (PVC): Manage persistent storage for services.

All these manifest files are stored in a GitLab repository for version control and easy management.

### Automated Deployment with ArgoCD

To enable automated deployment when there are changes in the manifest files, I use ArgoCD, a GitOps tool that supports Continuous Deployment (CD). ArgoCD monitors the GitLab repository containing the manifest files and automatically updates the application state in Kubernetes whenever changes occur.

Workflow:

1. Commit changes to GitLab

- When modifying a manifest file (e.g., updating an image version, changing service configurations, modifying ingress rules, etc.), I push the changes to the GitLab repository.

2. ArgoCD detects changes

- ArgoCD continuously watches the repository and synchronizes the cluster state with the updated configurations.

3. Application deployment

- ArgoCD automatically applies the changes to the Kubernetes cluster, ensuring the deployment stays up-to-date without manual intervention.

### Benefits of Using GitLab + ArgoCD

✅ Fully automates the deployment process, eliminating the need for manual operations.

✅ Enables easy rollback in case of issues by tracking change history in Git.

✅ Ensures high consistency, keeping the deployment environment aligned with the declared configurations.

✅ Simplifies version management, making it easy to monitor and control changes.

By combining GitLab and ArgoCD, I can deploy microservices applications in a flexible, fast, and reliable manner on Kubernetes. 🚀


<!-- ![Bookstore Final](https://user-images.githubusercontent.com/14878408/65784998-000e4500-e171-11e9-96d7-b7c199e74c4c.jpg) -->

<p align="center">
  <img src="./document/images/microservice2.png" alt="Image" style="width: 90%; max-width: 1000px;">
</p>


<hr>

## Monitoring
I setup PNG Stack & ELK Stack on Kubernetes

1. PNG Stack (Prometheus, Node Exporter, Grafana)
   - **Prometheus**: Collects and stores monitoring data using a pull model.
   - **Node Exporter**: Gathers system metrics (CPU, RAM, Disk, Network).
   - **Grafana**: Visualizes Prometheus data through dashboards.

    ➡ **Used for monitoring system performance and resources in Kubernetes.**

2. ELK Stack (Elasticsearch, Logstash, Kibana)
   - **Elasticsearch**: Stores, searches, and analyzes logs.
   - **Logstash**: Collects, processes, and sends logs to Elasticsearch.
   - **Kibana**: Provides a UI for visualizing logs and data analysis.

    ➡ **Used for log collection, processing, and analysis in Kubernetes.**


<hr>

**Screenshots of Tracing in Zipkin.**

<img alt="Zipkin" src="https://user-images.githubusercontent.com/14878408/65939069-6b426a80-e442-11e9-90fd-d54b60786d41.png">
<hr>
<img alt="Zipkin" src="https://user-images.githubusercontent.com/14878408/65939165-bb213180-e442-11e9-9ad7-5cfd4fa121ef.png">

<hr>

**Screenshots of Monitoring in Graphana.**

<img width="1680" alt="Screen Shot 2019-10-16 at 9 16 21 PM" src="https://user-images.githubusercontent.com/14878408/66936473-65ac6d80-f05b-11e9-9e7d-9652059438cd.png">


<img width="1680" alt="Screen Shot 2019-10-16 at 9 16 12 PM" src="https://user-images.githubusercontent.com/14878408/66936524-79f06a80-f05b-11e9-8898-1002813aad8e.png">

<hr>

**Screenshots of Monitoring in Chronograf(TICK).**

![Screen Shot 2019-10-16 at 12 44 20 PM](https://user-images.githubusercontent.com/14878408/66934353-f8e3a400-f057-11e9-82ab-eda7a230c09d.png)

![Screen Shot 2019-10-16 at 12 52 08 PM](https://user-images.githubusercontent.com/14878408/66934482-2e888d00-f058-11e9-8dea-f1f275765265.png)

<hr>

> Account Service

To Get `access_token` for the user, you need `clientId` and `clientSecret`

```
clientId : '93ed453e-b7ac-4192-a6d4-c45fae0d99ac'
clientSecret : 'client.devd123'
```

There are 2 users in the system currently. 
ADMIN, NORMAL USER

```
Admin 
userName: 'admin.admin'
password: 'admin.devd123'
```

```
Normal User 
userName: 'devd.cores'
password: 'cores.devd123'
```

*To get the accessToken (Admin User)* 

```curl 93ed453e-b7ac-4192-a6d4-c45fae0d99ac:client.devd123@localhost:4001/oauth/token -d grant_type=password -d username=admin.admin -d password=admin.devd123```

<hr>
