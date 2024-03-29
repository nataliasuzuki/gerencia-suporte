# :telephone_receiver: Suporte App

Suporte App é um pequeno projeto que disponibiliza cadastro, consulta de dados, geração de arquivo e autenticação com banco de dados. Foi utilizado a API Swing para o desenvolvimento da interface do usuário.

### Funcionalidades do projeto
- Cadastro de suporte
- Consulta de suportes disponíveis nas três áreas: hardware, rede, banco de dados/aplicação
- Geração de relatório na extensão .xls com base na consulta do item anterior

### Recursos utilizados
- Eclipse Java EE IDE 2023-03 (4.27.0)
- API Swing
- Plugin WindowBuilder
- Linguagem Java
- Banco de dados MySQL

### Executar Suporte App localmente
- Fazer o download deste projeto em algum diretório local,
- Localizar o arquivo ```queries.sql``` e executar as quatro queries no banco de dados MySQL,
- Abrir algum terminal de comando da sua máquina (Prompt de Comando, Windows PowerShell),
- Executar o comando ```mvn clean package```,
- Executar o comando ```cd target```,
- Executar o comando ```java -jar suporteApp-1.0-SNAPSHOT-jar-with-dependencies.jar```,
- Após isso, será apresentada a interface do projeto
- Obs.: O arquivo ```.xls``` é gerado na pasta target. A path exata é apresentada no console ao clicar no botão "Gerar relatório".
