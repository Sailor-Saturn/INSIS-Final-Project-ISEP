# INSIS-Final-Project-ISEP

This is a final Project for one of my master's degree courses. This project was made by me, Sónia Ferreira and Sérgio Ferreira (SF97) -> https://github.com/SF97 

The goal of this project was to make a platform to accompany the thesis project for students and teachers.

Most of the project was created using WSO2 and it's Eclipse platform. However, the last part of the project had the following.

There are some business processes that should be implemented using microservices:

1. Management Thesis Proposal;
2. Management Proposal Acceptance;
3. Formalization of thesis project;
4. Thesis defense management.

Each business process should interact with other processes in the program. And microservices should be created using 2 or more languages. In this case the team used NodeJS, Java, Postgres and Mongo DB. Every micro service interact with each other using a *Message Broker* (in this case Rabbit MQ).

Also, Docker files were created and Kubernetes pods were created so that everything could be uploaded to the cloud and be accessed there.

Google Cloud Drive was used as well.