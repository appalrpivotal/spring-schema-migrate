# spring-schema-migrate

This is a demo to perform a schema migration or changes before we swtich versions of our Application. Below are the two scenarios in which we can demo this:

Scenario 1:

The shell script will perform end to end blue green deployment and perform blue green deployment in three steps.

- Pushing the first version of the application

- Run the flywayDB migration commands

- Push the second version which will be backed by the new changes to the MySQL instance 

- Run ./script.sh 


Steps:

cd corp-store-blue

cf push

cd corp-store-green

cf push

Scenario 2:

Pushing the first version of the Application (corp-store-blue) and then have the second version (corp-store-green) perform the schema changes and add a column to Mysql instance.

Steps:
1) 

cd corp-store-blue

cf push

3) cd corp-store-green

4) cf push

You will notice that the green version of the application is backed with the new changes to the database.

