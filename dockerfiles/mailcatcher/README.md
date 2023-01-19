![Build Status,link=https://travis-ci.org/sshaaf/docker-mailcatcher](https://api.travis-ci.org/sshaaf/docker-mailcatcher.svg?branch=development)
=========

A container image for [MailCatcher](http://mailcatcher.me/)

### What is MailCatcher:
MailCatcher is a light-weight simple SMTP server that catches all messages sent to it and displays them in its web interface. Why is this useful? If you are doing tests locally or mocking application behaviour, this is what you want. Read more at mailcatcher.me


### What does this repo give you
* run the container locally

```
    docker run -p 8080:8080 -p 1025:1025 quay.io/sshaaf/mailcatcher                                                            
```

* run it on Openshift and ensure the service listens on 8080
```
    oc new-app quay.io/sshaaf/mailcatcher --name=mailcatcher
    oc expose svc/mailcatcher --port 8080 
```



