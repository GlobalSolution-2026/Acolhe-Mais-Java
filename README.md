# Acolhe+ · API REST (Java)

**FIAP – Análise e Desenvolvimento de Sistemas**
Global Solution 2026/2 – CitizenTech
Disciplina: Domain Driven Design Using Java

O Acolhe+ orienta o cidadão sobre onde buscar atendimento no SUS. Nos casos de baixa gravidade, oferece uma consulta na UBS, aproveitando os horários que seriam perdidos por falta. Esta API REST concentra o cadastro e o agendamento da solução. Ela trabalha com quatro entidades do domínio:

- **Unidade:** UBS ou UPA;
- **Horário:** horário de atendimento oferecido por uma unidade;
- **Cidadão:** identificado pelo Cartão SUS (CNS);
- **Consulta:** liga um cidadão a um horário.

## Integrantes

| Nome | RM | Turma |
| --- | --- | --- |
| Ana Carolina Orcelli Bautzer | 570281 | 1TDSPI |
| Cauã Mathias Bertini | 570451 | 1TDSPI |
| Eduardo Lima de Souza | 570412 | 1TDSPI |
| Nicolas Frazão Vieira Molina | 568780 | 1TDSPO |
| Nicolas Rodrigues Martins | 573178 | 1TDSPW |

## Links

- **API publicada (Render):** https://acolhe-mais-java.onrender.com
- **Vídeo de demonstração:** https://youtu.be/WliFxXppgn4
- **Front-end:** https://github.com/GlobalSolution-2026/acolhe-mais-front

> A API está no plano gratuito do Render. Depois de um tempo sem uso, ela "dorme", e a primeira requisição pode levar cerca de 1 minuto para responder. As seguintes respondem normalmente.

## Tecnologias

- Java 25 e Spring Boot 4.1.2 (Spring Web MVC, JDBC e Bean Validation)
- Banco de dados Oracle, com acesso por JDBC (`PreparedStatement`), sem JPA
- Docker (multi-stage) e Render para a publicação

## Estrutura do projeto

```
src/main/java/br/com/fiap/AcolheMais
├── model        entidades do domínio (Unidade, Horario, Cidadao, Consulta)
├── dto          dados de entrada e de saída da API, com as validações
├── controller   rotas REST e status HTTP
├── service      regras de negócio
├── repository   acesso ao banco com JDBC (DAO)
├── exception    exceções do domínio
├── handler      tratamento global dos erros (JSON padronizado)
└── config       liberação do CORS para o front-end
```

Na raiz do projeto ficam:

- `script.sql`: cria as tabelas e as sequences e insere os dados de demonstração;
- `Dockerfile`: monta a imagem publicada no Render;
- `javadoc/`: documentação das classes.

## Como executar

### 1. Banco de dados

Execute o `script.sql` no banco Oracle. Ele cria as tabelas com prefixo `ACM_`, as chaves estrangeiras e as sequences, e carrega os dados de demonstração. Se o banco já tiver dados do Acolhe+, descomente e rode antes a seção 0 do script (limpeza).

### 2. Variáveis de ambiente

A API lê a conexão com o banco de variáveis de ambiente. Usuário e senha não ficam no código.

| Variável | Uso |
| --- | --- |
| `DB_URL` | Endereço JDBC do banco Oracle |
| `DB_USER` | Usuário do banco |
| `DB_PASSWORD` | Senha do banco |
| `PORT` | Porta da API (opcional; padrão 8080) |

Windows (PowerShell):

```powershell
$env:DB_URL="jdbc:oracle:thin:@<host>:<porta>/<servico>"
$env:DB_USER="<usuario>"
$env:DB_PASSWORD="<senha>"
```

Linux ou macOS:

```bash
export DB_URL="jdbc:oracle:thin:@<host>:<porta>/<servico>"
export DB_USER="<usuario>"
export DB_PASSWORD="<senha>"
```

### 3. Iniciar a API

Requisito: Java 25. Na pasta do projeto, no mesmo terminal em que as variáveis foram definidas:

```bash
# Windows
mvnw.cmd spring-boot:run

# Linux ou macOS
./mvnw spring-boot:run
```

A API fica disponível em `http://localhost:8080`.

### Alternativa: Docker

```bash
docker build -t acolhe-mais-api .
docker run -p 8080:8080 -e DB_URL="..." -e DB_USER="..." -e DB_PASSWORD="..." acolhe-mais-api
```

## Endpoints

| Recurso | Rotas |
| --- | --- |
| Unidade | `POST /unidades` · `GET /unidades` · `GET /unidades/{id}` · `PUT /unidades/{id}` · `DELETE /unidades/{id}` |
| Horário (1:N com Unidade) | `GET /unidades/{idUnidade}/horarios` · `POST /unidades/{idUnidade}/horarios` · `GET /horarios/{id}` · `PUT /horarios/{id}` · `DELETE /horarios/{id}` |
| Cidadão | `POST /cidadaos` · `GET /cidadaos` · `GET /cidadaos?cns={nrCns}` · `GET /cidadaos/{id}` · `PUT /cidadaos/{id}` · `DELETE /cidadaos/{id}` · `POST /cidadaos/login` |
| Consulta (1:N com Horário e com Cidadão) | `POST /consultas` · `GET /consultas` · `GET /consultas/{id}` · `PUT /consultas/{id}` · `PUT /consultas/{id}/status` · `DELETE /consultas/{id}` |

Os erros são devolvidos sempre no mesmo formato, sem stack trace nem detalhes do SQL:

```json
{ "status": 409, "mensagem": "Horário já ocupado por outra consulta" }
```

A documentação técnica completa está no PDF entregue junto com o projeto. Ela traz o diagrama de classes, o DER, os endpoints, as regras de negócio, as validações e o deploy.
