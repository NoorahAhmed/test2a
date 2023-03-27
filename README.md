# High complexity code example
This repo serves as an example of badly written high complex code and what to do 
to solve the high complexity issues

# build
'$ mvn clean install'

# sonarqube
Configure the following environment variables to be able to upload your project analysis data to sonarqube
'SONAR_LOGIN=user
SONAR_PASSWORD=password
SONAR_URL=http://sonar.examplehost.com'

Then run

'$ mvn sonar:sonar'