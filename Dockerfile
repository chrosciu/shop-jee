FROM quay.io/wildfly/wildfly:26.1.2.Final-jdk11
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin
COPY postgresql-42.3.3.jar /opt/jboss/postgresql-42.3.3.jar
COPY config.cli /opt/jboss/wildfly/bin/config.cli
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file="/opt/jboss/wildfly/bin/config.cli" --echo-command
COPY shop-ear/target/shop-ear-1.0-SNAPSHOT.ear /opt/jboss/wildfly/standalone/deployments/shop-ear-1.0-SNAPSHOT.ear
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]