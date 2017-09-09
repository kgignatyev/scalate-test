demonstrates problem with scalate inside executable jar

Traditional app works
---

    creating assembly
    mvn clean  install appassembler:assemble
    trying it
    bash target/appassembler/bin/ctrl



When all packaged into executable jar, ssp compiler does NOT work
---

    Packaging all the jars into executable jar
    mvn -f pom-executable-jar.xml clean install
    
    Trying it
    java -jar target/scalate-test-1.0-SNAPSHOT.jar 

