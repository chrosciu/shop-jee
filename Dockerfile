FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk11
ADD products-ear/target/products-ear-1.0-SNAPSHOT.ear /opt/jboss/wildfly/standalone/deployments/
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent
COPY config.cli /opt/jboss/wildfly/bin/config.cli
COPY postgresql-42.3.3.jar /opt/jboss/postgresql-42.3.3.jar
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file="/opt/jboss/wildfly/bin/config.cli" --echo-command
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]