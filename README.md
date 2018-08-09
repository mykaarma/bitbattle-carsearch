# myKaarma bitbattle sample  
Basic sample for initial setup of myKaarma bitbattle project.

## How to setup? 
These instructions will get you a copy of the project up and running on your local machine.
### Prerequisites

Install Docker 

[Mac OS](https://docs.docker.com/docker-for-mac/install/)

[Windows 10](https://docs.docker.com/docker-for-windows/install/)

[Other OS](https://docs.docker.com/install/#supported-platforms) 

Install mysql client - [TablePlus](https://tableplus.io/) OR  [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

Run mysql server

```docker run -d --name=mysql-server --net=host mysql:latest```

### Steps to run

Open command line tool

```
wget https://mykaarma-bitbattle.s3.amazonaws.com/VehicleInventoryData_Sample1.sql

mysql -u root -proot -h localhost -P 3306 RawVehicleInventory -e "source VehicleInventoryData_Sample1.sql"

cd

mkdir myKaarma-bitbattle

cd myKaarma-bitbattle

git clone https://github.com/mykaarma/bitbattle-carsearch.git

cd bitbattle-carsearch

mvn clean package docker:build 
```

Open http://localhost:2517/bitbattle-2018.html

Ready to use!!

## Code Walkthrough  
### Client 
```
/src/main/resources/public/bitbattle-2018.html

/src/main/resources/public/styles/bitbattle-2018.css

Together responsible for layout/styling of webpage.

Technologies used: [HTML](https://www.w3schools.com/html/) [CSS](https://www.w3schools.com/css/) [BOOTSTRAP](https://www.w3schools.com/bootstrap) 


/src/main/resources/public/js/bitbattle-2018.js

Functions/Logic to handle actions on client and calls rest endpoint for search results.

Technologies used: [ANGULARJS](https://www.w3schools.com/angularjs) 
 
```

### Rest Layer 
### Database Layer

## How to make changes and redeploy and repackage
