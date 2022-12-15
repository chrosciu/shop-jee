FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk11
ADD products-ear/target/products-ear-1.0-SNAPSHOT.ear /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]