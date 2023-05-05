FROM flyway/flyway:latest

ADD scripts/* /flyway/sql/
ADD conf/flyway.conf /flyway/conf/

CMD ["migrate"]
