# TCC Sistemas

### Ferramentas de desenvolvimento

Programas para desenvolver:
* IDE JEE / SE (Eclipse , netbeans)
* Postman (testar os endpoints)
* Git


### Configurando ambiente

Após instalar as ferramentas citadas, seguir  [este tutorial caso não tenha jdk](http://www.matera.com/blog/post/tutorial-instalacao-do-java-jdk-e-eclipse-no-windows).

```sh
git clone https://github.com/roselinho/udf-tcc-rest
```

Após isso, abrir o Eclipse e importar o projeto para a IDE:

File > Import > Existing Maven Projects > Browse (escolher a pasta e clicar em Finish)


#### Eclipse e MySQL

Feito isso, clicar com o botão direito em cima do projeto > Maven > Download sources (irá baixar as dependências do maven).
O arquivo de configuração do Spring-Boot `application.properties` está da seguinte maneira:
```sh
spring.datasource.url = jdbc:mysql://localhost:3306/udf_app - 3306 é a porta que o Xampp inicia o mysql
spring.datasource.username = root - Login do MySQL
spring.datasource.password = - senha do MySQL
spring.datasource.driverClassName=com.mysql.jdbc.Driver
```
Lembrando que as configurações acima são as defaults do xampp, vc pode ver a sua no arquivo `my.ini`

No momento, para rodar o projeto é necessário ter o xampp, iniciar o serviço MySQL e criar um database (schema) com o nome **`udf_app`**. Para criar o schema, pode ser pelo MySQL Workbench.
Após criar o schema, iniciar o projeto entrando na classe *main* (**com.udf.tcc.UdfTccApplication**) e clicando com o botão direito em cima dela > Run As > Java Application. Será iniciado um servidor que atuará como uma API REST no contexto `http://localhost:8080/api/xxxxxx`. Para certificar que está tudo ok, entrar na URL `http://localhost:8080/api/criancas` e deve ser retornado uma lista de crianças: 

![alt text](https://i.imgur.com/3lemBS7.png)

