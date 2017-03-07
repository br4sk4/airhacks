#Resources

http://www.adam-bien.com/roller/abien/entry/building_plug_in_with_java
https://en.wikipedia.org/wiki/Law_of_triviality
https://foxglovesecurity.com/2015/11/06/what-do-weblogic-websphere-jboss-jenkins-opennms-and-your-application-have-in-common-this-vulnerability/
https://tools.ietf.org/html/rfc2616#page-54
https://github.com/AdamBien/docklands

 6398  mvn clean install && docker build -t localhost:5000/soptim/samples .
 6390  docker ps
 6391  docker logs soptim1
 6392  docker logs soptim2
 6393  docker images
 6394  docker history soptim/samples
 6395  docker run -d -p 5000:5000 --name registry registry:2
 6396  docker tag soptim/samples localhost:5000/soptim/samples
 6397  docker push localhost:5000/soptim/samples
 6399  docker push localhost:5000/soptim/samples
 docker run -d -p 8484:8080 --name soptim2 localhost:500/soptim/samples

