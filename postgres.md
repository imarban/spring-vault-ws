**Instructions if you are using a PostgreSQL instance**

- Run ``` vault write database/config/postgresql \ 
plugin_name=postgresql-database-plugin \
allowed_roles="readonly" \
connection_url="postgresql://vault:vault@localhost:5432/postgres?sslmode=disable" ```. 

**Make sure to replace the user and password in the url connection string.**

The previous command will configure PostgreSQL database backend. 

- Run ``` vault write database/roles/readonly \
    db_name=postgresql \
    creation_statements="CREATE ROLE \"{{name}}\" WITH LOGIN PASSWORD '{{password}}' VALID UNTIL '{{expiration}}'; \
        GRANT SELECT ON ALL TABLES IN SCHEMA public TO \"{{name}}\";" \
    default_ttl="1h" \
    max_ttl="24h" ```. 

This will define the statement to be used every time a user/password is created by the PostgreSQL backend.