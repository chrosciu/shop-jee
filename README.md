### Budowa obrazu Docker

`docker build --tag=wildfly-app .  `

### Uruchomienie obrazu

`docker run -p 8080:8080 -p 9990:9990 -it wildfly-app`

Przykładowy endpoint w wersji z EAR


