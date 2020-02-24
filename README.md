## Manual start cluster of mongo db

Creating network
```
docker network create my-mongo-cluster
```
Starting dockers    
```
docker run \
-p 30001:27017 \
--name mongo1 \
--net my-mongo-cluster \
mongo mongod --replSet my-mongo-set


docker run \
-p 30003:27017 \
--name mongo3 \
--net my-mongo-cluster \
mongo mongod --replSet my-mongo-set


docker run \
-p 30002:27017 \
--name mongo2 \
--net my-mongo-cluster \
mongo mongod --replSet my-mongo-set

```
In mongo shell: 
```
> db = (new Mongo('localhost:27017')).getDB('test')
test
> config = {
  	"_id" : "my-mongo-set", \
  	"members" : [ \
  		{ \
  			"_id" : 0, \
  			"host" : "mongo1:27017” \
  		}, \
  		{ \
  			"_id" : 1, \
  			"host" : "mongo2:27017" \
  		}, \
  		{ \
  			"_id" : 2, \
  			"host" : "mongo3:27017" \
  		} \
  	] \
  } \

Or

rs.initiate(
  {
    _id : 'rs0',
    members: [
      { _id : 0, host : "mongo1:27017" },
      { _id : 1, host : "mongo2:27017" },
      { _id : 2, host : "mongo3:27017" }
    ]
  }
)
```
Testing
```
db.mycollection.insert({name : 'sample'})
db.mycollection.find()
```

environment:
  - MONGO_INITDB_ROOT_USERNAME=root
  - MONGO_INITDB_ROOT_PASSWORD=root
  - MONGO_INITDB_DATABASE=test
  

Or you can start cluster of mongodb from docker-compose     

docker exec -it mongo_db_mongo1_1 mongo