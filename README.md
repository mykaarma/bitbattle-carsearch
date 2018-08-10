# myKaarma bitbattle sample  
Basic sample for initial setup of myKaarma bitbattle project.

## How to setup? 
These instructions will get you a copy of the project up and running on your local machine.
### Prerequisites

Install Docker [Mac OS](https://docs.docker.com/docker-for-mac/install/) | [Windows 10](https://docs.docker.com/docker-for-windows/install/) | [Other OS](https://docs.docker.com/install/#supported-platforms) 

Install mysql client - [TablePlus](https://tableplus.io/)  |  [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
> Use MySQL Workbench for windows

Install git client - [GIT](https://www.atlassian.com/git/tutorials/install-git)

Install maven - Follow instructions [here](https://www.baeldung.com/install-maven-on-windows-linux-mac)
> Make sure to finally download the bin zip file(apache-maven-3.3.x-bin.zip) not the src zip file.

Run mysql server

```
docker run --restart=always -p 3306:3306 -d --name=mysql-server  -e MYSQL_ROOT_PASSWORD=root mysql:5.7
```

### Steps to run
Open TablePlus / MySQL workbench
Use following configurations to connect to mysql-server
```
host  - localhost
port  - 3306
user  - root
pass  - root
```
Copy paste and run content of this file [RawVehicleInventory.sql](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/resources/schema/RawVehicleInventory.sql)

Open command line tool

```
1. cd
2. rm -Rf myKaarma-bitbattle
3. mkdir myKaarma-bitbattle
4. cd myKaarma-bitbattle
5. git clone https://github.com/mykaarma/bitbattle-carsearch.git
6. cd bitbattle-carsearch
7. mvn clean package docker:build 
8. docker run -p 2517:2517 --link=mysql-server:mysql_host --restart=always --name=bitbattle -d bitbattle-carsearch:latest
```

Open http://localhost:2517/bitbattle-2018.html

Ready to use!!

After making changes you can follow steps 6-8 again to test your changes.

## Code Walkthrough  
### Client 

- [/src/main/resources/public/bitbattle-2018.html](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/resources/public/bitbattle-2018.html)

- [/src/main/resources/public/styles/bitbattle-2018.css](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/resources/public/styles/bitbattle-2018.css)

Together responsible for layout/styling of webpage.

Technologies used: [HTML](https://www.w3schools.com/html/) [CSS](https://www.w3schools.com/css/) [BOOTSTRAP](https://www.w3schools.com/bootstrap/) 


- [/src/main/resources/public/js/bitbattle-2018.js](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/resources/public/js/bitbattle-2018.js)

Functions/Logic to handle actions on client and calls rest endpoint for search results.

Technologies used: [ANGULARJS](https://www.w3schools.com/angular/) 
 


### Back-end

- [/src/main/java/com/mk/bitbattle/api/DealerServiceController.java](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/java/com/mk/bitbattle/api/DealerServiceController.java)
Use this class to introduce API endpoints.

- [/src/main/java/com/mk/bitbattle/api/impl/DealerServiceImpl.java](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/java/com/mk/bitbattle/api/impl/DealerServiceImpl.java)
Use this class to write implementation/logic for the API endpoints.

- [/src/main/java/com/mk/bitbattle/api/db/DealerDBImpl.java](https://github.com/mykaarma/bitbattle-carsearch/blob/master/src/main/java/com/mk/bitbattle/api/db/DealerDBImpl.java)
Use this class to connect to database.


## How to make final docker image which needs to be submitted

Go to project folder

Run following commands

```mvn clean package docker:build ``` - to create docker image

```docker save -o <destination path for tar file> bitbattle-carsearch``` - to convert image to tar

Put the tar file from destination path to the final submission zip file along with other documents.
