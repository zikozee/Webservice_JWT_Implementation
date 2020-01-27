# Webservice_JWT_Implementation



Insert JWT class+ resource

1. call localhost:8080/authenticate  
  passing in {"username" : "...",
              "password" : "..."}
  to get token

2. Add token to the header
  key-> Authorization
  value-> Bearer <token>

3. Call endpoint now n u'll get a 200

