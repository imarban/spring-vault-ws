# Spring Vault Workshop

## What is Vault?

HashiCorp’s Vault provides a central place to manage external secret data for applications across all environments. Vault can manage static and dynamic secrets such as application data, username/password for remote applications/resources and provide credentials for external services such as MySQL, PostgreSQL, Apache Cassandra, Consul, AWS and more.

## Requirements

- Java 6 or higher
- Vault 0.5 or higher

### Installing Vault
1. Run ``` brew install vault ```. This will update brew and install Vault. At the time of writing it will be 0.7.2

2. Run ``` vault version ```. It should return the version.

### Running up a Vault server

1. Run ``` vault server -dev ```. This will start a server with dev purposes only in the foreground.
2. Run ``` export VAULT_ADDR='http://127.0.0.1:8200' ``` in a separate terminal. By default Vault address is set to HTTPS, since we are using dev server we need to set it to HTTP version.
3. Verify server is running and reachable by running ``` vault status ```.

Important things about this server:
- TLS is not supported
- Backend for secrets/passwords is in-memory
- Is not a server ready for production environments

### Storing a secret with Vault only

Goal: To know more about Vault operations. 

- Run ``` vault write secret/hello value=world ```3

- Run ``` vault read secret/hello ```. Stored secrets will be shown.
- Add -format=json to previous sentence to get output as json

- Run ``` vault delete secret/hello ```. Delete secret

## What is Spring Vault?

Spring Vault is a framework from Spring that provides familiar Spring abstractions and client-side support for accessing, storing and revoking secrets interacting with Vault.

### What has Spring Vault to offer?

- @VaultPropertySource annotation to enable loading secrets from Vault
- EnvironmentVaultConfiguration which is an AutoConfiguration class for creating a context for Vault (connection, authentication)
- VaultTemplate which is a class that provides methods for Vault common operations (write, read, delete)

### Exercise 1. Reading a secret with Spring

1. Create a secret on your local vault server
2. Open the exercise1 folder in your IDE. 
3. Complete the missing code for reading the Vault secret.
4. Make sure to print to standard output the value Vault returns.


### Exercise 2. Write and read a secret from Spring.



