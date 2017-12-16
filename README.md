# century-link-code-challenge

# To run
1. This is a Spring-Boot application, to run this, download the source code,
    * <code>cd century-link-code-challenge/</code>
    * <code>mvn package && java -jar target/century-link-code-challenge-0.0.1-SNAPSHOT.jar</code>
2. This will start the webserver on port 8080
3. To call the api to retrieve github followers,
   * <code>GET http://localhost:8080/github/followers/<username> </code>
