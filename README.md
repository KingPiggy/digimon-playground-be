# digimon-playground-be

## Project Info
- Java 11
- Spring boot
- 2022.10.09 ~ 2022.10.XX

## Build & Run
### Local

아래의 VM Option으로 실행


    -Dspring.profiles.include=core,local

아래 방법은 사용하지 않음
~~legacy : -Dspring.active.profiles=core,local~~

### Docker build


    docker build --tag {hostIP}:5000/test:0.1

## Modules
1. api-server
   - API Server
   - port : 8090
2. core
   - Entity, Repository
   - Common
   - Util
3. schedule-server
   - Schedule Server
   - port : 8091

## Feature
1. Digimon Wiki
2. ~~TCG Card Wiki~~ 
3. ~~Today's Digimon~~
4. ~~Community~~

## External API
### Digimon
- https://digimon-api.vercel.app/api/digimon

### TCG Cards
Requests are rate limited and are rate limited to 15 requests per 10 seconds.
