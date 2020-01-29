# Webservice_JWT_Implementation Inmemory Authentication

[![CircleCI](https://circleci.com/gh/zikozee/Webservice_JWT_Implementation/tree/master.svg?style=svg)](https://circleci.com/gh/zikozee/Webservice_JWT_Implementation/tree/master)

Insert JWT class+ resource

1. call a POST localhost:8080/authenticate  
  passing in {"username" : "...",
              "password" : "..."}
  to get token

2. Add token to the header
  key-> Authorization
  value-> Bearer <token>

3. Call endpoint now n u'll get a 200. since token has now been passed in header no need for username and password

4. To refresh token, call localhost:8080/refresh
 with header
  key-> Authorization
  value-> Bearer <token>
