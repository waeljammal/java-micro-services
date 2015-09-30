FROM centos

RUN yum -y install mysql-server
RUN touch /etc/sysconfig/network

RUN service mysqld start &&  \
	sleep 5s && \
	mysql -e "GRANT ALL ON *.* to 'root'@'%'; FLUSH PRIVILEGES"

EXPOSE 3306

CMD ["/usr/bin/mysqld_safe"]