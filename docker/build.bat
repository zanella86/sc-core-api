::docker run --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=admin" --env="MYSQL_DATABASE=sport-connection" mysql
docker build -t sc-core-api/backend ../.