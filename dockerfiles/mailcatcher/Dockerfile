FROM ruby:2.5
MAINTAINER sshaaf@redhat.com

RUN gem install mailcatcher

EXPOSE 8080 1025

ENTRYPOINT ["mailcatcher", "-f", "--ip", "0.0.0.0", "--http-port","8080"]