FROM httpd

LABEL version="0.1"

MAINTAINER Adil

WORKDIR /usr/local/apache2/htdocs/

RUN rm -f *

RUN apt update && apt install -y git

RUN git clone https://github.com/Adil-ha/Tp-TodoList.git .

EXPOSE 80
