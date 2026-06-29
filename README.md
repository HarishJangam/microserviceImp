# Microservices Implementation Project

This repository contains a production-ready, Java-based microservices architecture implementing service discovery, an API gateway, centralized configuration management, and containerized deployments.

## 🏗️ Architecture Overview

The system is built using a decoupled, cloud-native pattern where individual microservices handle specific domain logic, coordinated by a central infrastructure suite.

### Infrastructure & Ecosystem Components

* ### 🛰️ Service Registry (`serviceRegistry`)


Built using **Netflix Eureka Server**, this acts as the phonebook of your architecture.
* **How it works:** When individual microservices (like `UserService` or `HotelService`) boot up, they register their network locations (IP address and port) with this registry.
* **Why it's used:** It eliminates hardcoded URLs. Instead of services guessing where other services live, they query the Eureka server dynamically to find active instances. It also handles basic client-side load balancing and monitors service health via heartbeats.


* ### 🚪 API Gateway (`ApiGateWay`)


This is the single entry point for all client applications (web, mobile, or third-party) interacting with your backend ecosystem.
* **How it works:** Instead of a frontend making separate requests to multiple individual port numbers, it hits the API Gateway. The gateway inspects the incoming request URL path and forwards it to the appropriate microservice by querying the Service Registry.
* **Why it's used:** It provides security by hiding internal service topologies from the public internet. It is also the ideal place to implement cross-cutting concerns like global authentication (e.g., JWT validation), rate-limiting, CORS configuration, and request logging.


* ### ⚙️ Centralized Config Manager (`configManage`)


Built using **Spring Cloud Config Server**, this centralizes the environment-specific properties (`.properties` or `.yml` files) of all microservices in one place.
* **How it works:** Microservices request their specific configurations from this server upon startup.
* **Why it's used:** It decouples application code from deployment configurations. If you need to change a database URL or a feature flag across multiple environments (Dev, QA, Prod), you only update it once in the config manager without rebuilding or redeploying the actual service containers.



---

### Core Business Services

* **`UserService`**: Manages user profiles, credentials, authentication state, and core user-related business logic.
* **`HotelService`**: Handles hotel management inventory, metadata, location details, and availability status.
* **`RatingService`**: Manages user-submitted ratings, reviews, and feedback loops tied to specific hotels.

---

## 🛠️ Tech Stack

* **Language:** Java (94.1%)
* **Containerization:** Docker & Docker Compose (3.1%)
* **Automation/Scripting:** Shell Scripting (2.8%)
* **Database:** PostgreSQL / MySQL (Configured via `init.sql`)

---

## 🚀 Getting Started

### Prerequisites

* Java JDK
* Docker & Docker Compose
* Maven / Gradle (depending on your project's wrapper configuration)

### Quick Start

You can compile and spin up the entire ecosystem using the provided automation scripts:

1. **Build all service artifacts:**
```bash
chmod +x build-all.sh
./build-all.sh

```


2. **Start the infrastructure containers:**
```bash
chmod +x start.sh
./start.sh

```



Alternatively, you can launch the containerized multi-service environment directly via Docker Compose:

```bash
docker-compose up -d

```

---

## 📂 Repository Structure

```placeholders
├── .idea/               # IDE Configuration profiles
├── ApiGateWay/          # API Gateway Routing & Security Edge Service
├── HotelService/        # Hotel Domain Microservice
├── RatingService/       # Rating & Feedback Domain Microservice
├── UserService/         # User Domain Microservice
├── configManage/        # Centralized Configuration Server
├── serviceRegistry/     # Netflix Eureka Discovery Registry
├── build-all.sh         # Shell script to compile all project modules
├── docker-compose.yml   # Multi-container orchestration setup
├── init.sql             # SQL script for initializing necessary databases
└── start.sh             # Deployment execution script

```