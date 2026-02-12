# ✨🕶️ EyeGen Back-end: Acessibilidade e inclusão por meio da tecnologia
<img width="100%" height="325" alt="Frame 1686551777 (1)" src="https://github.com/user-attachments/assets/5385fcb1-248a-41ae-9025-7266f5604f86" />

# Sobre o Back-end do EyeGen
É uma API REST desenvolvida em Java com Spring Boot que implementa as melhores práticas de desenvolvimento backend, oferecendo uma solução completa para gestão dos produtos e pedidos do EyeGen, além de cadastro e login seguros.

O projeto foi construído com foco em:
- ✅ **Clean Code** - Código limpo e manutenível
- 🏗️ **Arquitetura em Camadas** - Separação clara de responsabilidades
- 🔐 **Segurança Robusta** - JWT + Spring Security
- 📊 **Persistência Eficiente** - Spring Data JPA + Flyway Migrations
- 🎯 **Validações Consistentes** - Bean Validation para validações dos dados enviados para a API
- ⚙️ **Tratamento erros - Tratamento de erros globais**

### 🎯 Visão do Produto

O EyeGen está consolidando uma plataforma completa para os usuários com deficiência visual, onde futuramente poderam:
- 🔍 Adquirir óculos o EyeGlass (Ainda é um MVP)
- 📋 Contratar planos nossos planos
- 🔧 Agendar manutenções preventivas

---

## ⚡ Funcionalidades

### 🔐 Autenticação e Autorização
- Cadastro de novos usuários com validação de dados
- Login seguro com geração de tokens JWT
- Proteção de endpoints com Spring Security
- Senhas criptografadas com BCrypt
- Tokens com expiração configurável

### 🛍️ Gestão de Pedidos
- Criação de pedidos com múltiplos itens
- Cálculo automático de valores totais
- Suporte a diferentes métodos de pagamento
- Validação de estoque e disponibilidade de produtos
- Rastreamento de status dos pedidos

### 👤 Gestão de Usuários
- Perfis de usuário completos
- Validação de e-mails duplicados
- Dados de autenticação seguros

---

## 🔌 Endpoints da API

### 🔓 Autenticação (Público)

#### Cadastro de Usuário
```http
POST /usuarios/cadastro
```
**Request Body:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "senha123",
  "data_nascimento": "20-08-2005",
  "telefone": "11987654321",
  "tipo_def_visual": "BAIXA_VISAO"
}
```

**Response:** `201 Created`
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "senha123",
  "data_nascimento": "20-08-2005",
  "telefone": "11987654321",
  "tipo_def_visual": "BAIXA_VISAO"
}
```

#### Login
```http
POST /usuarios/login
```
**Request Body:**
```json
{
  "email": "joao@email.com",
  "senha": "senha123"
}
```

**Response:** `200 OK`
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 🔒 Pedidos (Requer Autenticação)

#### Realizar Pedido
```http
POST /pedidos
Authorization: Bearer {token}
```
**Request Body:**
```json
{
  "idUsuario": 2,
  "metodoPagamento": "PIX",
  "itens": [
    {
      "idProduto": 1,
      "quantidade": 1
    },
    {
      "idProduto": 3,
      "quantidade": 1
    }
  ]
}
```

**Response:** `201 Created`
```json
{
  "dataRealizacao": "2026-02-12T14:30:00",
  "status": "PENDENTE",
  "metodoPagamento": "PIX",
  "valorTotal": 3060.00,
  "idUsuario": 2,
  "itens": [
    {
      "produto": {
        "nome": "EyeGlass"
        "precoUnitario": 3000.00,
        "quantidade": 1,
        "total": 3000.00
      },
    "produto": {
        "nome": "Guardian"
        "precoUnitario": 60.00,
        "quantidade": 1,
        "total": 60.00
      },
    }
  ]
}
```

---

## 🛠️ Tecnologias Utilizadas

### Core
- **Java 17** - Linguagem de programação
- **Spring Boot 3.x** - Framework principal
- **Maven** - Gerenciamento de dependências

### Segurança
- **Spring Security** - Framework de autenticação e autorização
- **JWT (JsonWebToken)** - Geração e validação de tokens
- **BCrypt** - Algoritmo de hash para senhas

### Persistência
- **Spring Data JPA** - Abstração de acesso a dados
- **MySQL 8.0** - Banco de dados relacional
- **Flyway** - Versionamento de banco de dados

### Utilitários
- **Lombok** - Redução de código boilerplate
- **Bean Validation** - Validação de dados
- **Records (Java 17)** - DTOs imutáveis

### DevOps
- **Docker** - Containerização da aplicação

---

## 📁 Estruturação de Pastas

```
EyeGen-Back-End/
│
├── src/
│   └── main/
│       └── java/
│           └── br.com.eyegen.api_eyegen/
│               │
│               ├── controller/           # Controladores REST
│               │   ├── AutenticacaoController.java
│               │   └── PedidoController.java
│               │
│               ├── domain/              # Camada de Domínio
│               │   │
│               │   ├── assinatura/     # Dominio da Assinatura (Entidade, DTO e enums)
│               │   │   ├── Assinatura.java
│               │   │   ├── DadosAssinatura.java
│               │   │   └── enums/
│               │   │
│               │   ├── dispositivo/    # Dominio do dispositivo EyeGlass (Entidade, DTO e enums)
│               │   │   ├── Dispositivo.java
│               │   │   ├── DadosDispositivo.java
│               │   │   └── enums/
│               │   │
│               │   ├── item_pedido/    # Dominio do ItemPedido (Entidade, DTO e enums)
│               │   │   ├── ItemPedido.java
│               │   │   ├── DadosItemPedido.java
│               │   │   └── DadosItemResposta.java
│               │   │
│               │   ├── manutencao/     # Dominio da manutenção (Entidade, DTO e enums)
│               │   │   ├── Manutencao.java
│               │   │   ├── DadosManutencao.java
│               │   │   └── enums/
│               │   │
│               │   ├── pedido/         # Dominio do Pedido (Entidade, DTO e enums)
│               │   │   ├── Pedido.java
│               │   │   ├── DadosRealizaPedido.java
│               │   │   ├── DadosRespostaPedido.java
│               │   │   └── enums/
│               │   │       ├── StatusPedido.java
│               │   │       └── DadosRealizaPedido.java
│               │   │
│               │   ├── produto/        # Dominio do Produto (Entidade, DTO e enums)
│               │   │   ├── Produto.java
│               │   │   └── enums/
│               │   │
│               │   └── usuario/        # Agregado de Usuário
│               │       ├── Usuario.java
│               │       ├── DadosAutenticacao.java
│               │       ├── DadosCadastroUsuario.java
│               │       ├── DadosRespostaUsuario.java
│               │       └── enums/
│               │
│               ├── infra/              # Camada de Infraestrutura
│               │   ├── exception/      # Tratamento de Exceções
│               │   │   └── ControllerExceptionHandler.java
│               │   │
│               │   └── security/       # Configurações de Segurança
│               │       ├── SecurityConfigurations.java
│               │       ├── SecurityFilter.java
│               │       └── TokenService.java
│               │
│               ├── repository/         # Repositórios JPA
│               │   ├── PedidoRepository.java
│               │   ├── ProdutoRepository.java
│               │   └── UsuarioRepository.java
│               │
│               ├── services/           # Camada de Regras de Negócio
│               │   ├── AutenticacaoService.java
│               │   ├── CadastroUsuarioService.java
│               │   └── PedidoService.java
│               │
│               └── ApiEyegenApplication.java
│
├── resources/
│   ├── application.properties         # Configurações da aplicação
│   ├── application-dev.properties         # Configurações da desenvolvimento
│   ├── application-prod.properties         # Configurações de produção
│   └── db/
│       └── migration/                 # Scripts Flyway
│
├── test/                              # Testes automatizados
│
├── Dockerfile                         # Containerização
├── pom.xml                           # Dependências Maven
└── README.md                         
```

### 🎯 Arquitetura em Camadas

1. **Controller** - Recebe requisições HTTP e delega para os services
2. **Service** - Contém a lógica de negócio da aplicação
3. **Repository** - Interface de manipulação de dados
4. **Domain** - Entidades e regras de domínio
5. **Infra** - Configurações de segurança e tratamento de exceções

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- ☕ Java 17 ou superior
- 🐳 Docker
- 📦 Maven 3.6+
- 🎲 MySQL

### 📋 Passo a Passo

#### 1️⃣ Clone o Repositório
```bash
git clone https://github.com/seu-usuario/eyegen-backend.git
cd eyegen-backend
```

#### 2️⃣ Configure as Variáveis de Ambiente

```env
# Banco de Dados
DB_PASSWORD: com_sua_senha

# JWT
JWT_SECRET: sua_chave_secreta_aqui_minimo_256_bits
```

#### 3️⃣ Opção B: Executar Localmente

**a)Crie um banco de dados no MySQL**
```bash
eyegen_db
```

**b) Configure o `application.properties`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eyegen_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

api.security.token.secret=${JWT_SECRET}
```

A aplicação estará disponível em: `http://localhost:8080`
---

## 🔒 Segurança

### Autenticação JWT

O sistema utiliza JWT (JSON Web Tokens) para autenticação:

1. Usuário faz login com email e senha
2. Sistema valida credenciais e gera um token JWT
3. Token é retornado ao cliente
4. Cliente envia o token no header `Authorization` em requisições subsequentes
5. Sistema valida o token antes de processar a requisição

### Proteção de Endpoints

- ✅ **Endpoints Públicos:** `/usuarios/cadastro`, `/usuarios/login`
- 🔒 **Endpoints Protegidos:** Todos os demais (requerem token JWT válido)

### Boas Práticas Implementadas

- Senhas nunca armazenadas em texto plano (BCrypt)
- Tokens com expiração configurável
- CORS configurado para origens específicas
- Validação de entrada em todos os endpoints
- Tratamento centralizado de exceções

---

## 🗄️ Migrações de Banco de Dados

O projeto utiliza **Flyway** para versionamento do banco de dados. As migrações são executadas automaticamente no startup da aplicação.

Localização: `src/main/resources/db/migration/`

Exemplo de nomenclatura:
- `V1__criar_tabela_usuarios.sql`
- `V2__criar_tabela_produtos.sql`
- `V3__criar_tabela_pedidos.sql`

---

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add: nova funcionalidade incrível'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👥 Autores

Desenvolvido pelo EyeGen. Inteligência que Guia os Seus Passos 🕶️
