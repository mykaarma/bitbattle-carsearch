# myKaarma bitbattle sample  
Basic sample for initial setup of myKaarma bitbattle project.
https://mykaarma-bitbattle.s3.amazonaws.com/VehicleInventoryData_Sample1.csv

https://mykaarma-bitbattle.s3.amazonaws.com/VehicleInventoryData_Sample2.csv

## How to setup? 
These instructions will get you a copy of the project up and running on your local machine.
### Prerequisites

Install Docker 

Mac OS     - https://docs.docker.com/docker-for-mac/install/

Windows 10 - https://docs.docker.com/docker-for-windows/install/

Other OS   - https://docs.docker.com/install/#supported-platforms 

Install mysql client

https://tableplus.io/ OR https://dev.mysql.com/downloads/workbench/

Run mysql server

```docker run -d --name=mysql-server --net=host mysql:latest```

### Steps to run

Open command line tool

```wget https://mykaarma-bitbattle.s3.amazonaws.com/VehicleInventoryData_Sample1.sql

mysql -u root -proot -h localhost -P 3306 RawVehicleInventory -e "source VehicleInventoryData_Sample1.sql"```

```cd```

```mkdir myKaarma-bitbattle```

```cd myKaarma-bitbattle```

```git clone https://github.com/mykaarma/bitbattle-carsearch.git```

```cd bitbattle-carsearch```

```mvn clean package docker:build```

Open http://localhost:2517/bitbattle-2018.html

Ready to use!!

## Code exlplanation : explain client, rest layer, middle layer and db layer

## How to make changes and redeploy and repackage
