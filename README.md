# msa-springcloud-example

spring-cloud 환경을 위한 연습 코드

예제와 설명이 잘 나온 [블로그](https://assu10.github.io/dev/2020/09/12/spring-cloud-oauth2.0/) 를 기반으로 작성.
블로그 예제에서 빠진 부분들이 있음.
(빠진 부분 : config server에 git 저장소 연결, eureka server 에 peer to peer, Auth server에 MSA간 엑세스 토큰 전파, jwt 적용 등등)
zuul gateway 대신 spring cloud gateway 사용.

----

gradle 환경에 멀티모듈로 구성.