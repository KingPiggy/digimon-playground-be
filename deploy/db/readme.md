# Docker 를 이용한 MySQL 설치

## Docker Compose File을 이용한 MySql 설치 방법

컨테이너 생성 및 실행 (최초 1회)
$ docker-compose -f docker_compose_local_mysql.yml up -d

컨테이너 실행
$ docker start local_digimon_pg_mysql