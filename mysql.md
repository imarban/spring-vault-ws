**Instructions if you are using a MySQL instance**

- Run ``` vault write database/config/mysql \
    plugin_name=mysql-database-plugin \
    connection_url="root:mysql@tcp(127.0.0.1:3306)/" \
    allowed_roles="readonly" ```. 

**Make sure to replace the user and password in the url connection string.**

The previous command will configure MySQL database backend. 

- Run ``` vault write database/roles/readonly \
    db_name=mysql \
    creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT ON *.* TO '{{name}}'@'%';" \
    default_ttl="1h" \
    max_ttl="24h" ```. 

This will define the statement to be used every time a user/password is created by the MySQL backend.