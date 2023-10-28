# 42-VerifySafe

## Descrição:
A 42VerifySafe é a sua solução confiável para verificação de antecedentes e segurança. Com acesso direto às informações do FBI e Interpol, estamos comprometidos em
ajudá-lo a tomar decisões de contratação informadas e seguras.<br/>

**Por que Escolher a 42VerifySafe**?<br/>
Estamos empenhados em fornecer uma solução de confiança que redefine a segurança e a eficácia nos processos de contratação. A 42VerifySafe não é apenas uma ferramenta,
é uma parceria que coloca o poder das informações do FBI e da Interpol diretamente em suas mãos. Com essa aplicação, você terá a capacidade de proteger sua organização 
contra riscos imprevistos, garantindo que cada candidato seja cuidadosamente avaliado quanto a antecedentes e integridade. Oferecemos tranquilidade e a certeza de que sua 
equipe de RH está tomando decisões informadas e estratégicas, essenciais para o sucesso a longo prazo da sua organização. Escolha a 42VerifySafe e eleve o nível da segurança
e confiabilidade em suas contratações!

## Versao:
- v1.0.5

## Tecnologias:
- Java 17
- PostgreSQL
- SpringBoot v3.1.0 (validation/ gson/ devtools/ jdbc/ lombok/ security/ jwt/ sendmail)
- Docker


## ENDPOINTS:
### User

-  <b>Endpoint responsável por:</b> Cadastrar um novo <b>Usuário</b> no sistema.<br/>
- **Obs**.:
    - Assim que for cadastrado um novo usuário no sistema, o mesmo, irá enviar um email para notificação.
```http
  POST api/v1/auth/register
```
| Parâmetro  | Tipo     | Descrição                       | 
|:-----------|:---------|:--------------------------------| 
| `email`    | `string` | **Obrigatório**. Email.         | 
| `password` | `string` | **Obrigatório**. Senha.         | 
| `name`     | `string` | **Obrigatório**. Primeiro nome. | 
| `lastname` | `string` | **Obrigatório**. Ultimo nome.   | 
| `phone`    | `string` | **Obrigatório**. Telefone.      | 

-  <b>Endpoint responsável por:</b> Autenticar um <b>usuário</b> existente no sistema.<br/>
- **Obs**.:
  - _Retorno_: <code>{"user_id": 1, "create_at": "", "token": ""}</code>

```http
  POST api/v1/auth/authenticate
```
| Parâmetro  | Tipo     | Descrição                       | 
|:-----------|:---------|:--------------------------------| 
| `email`    | `string` | **Obrigatório**. Email.         | 
| `password` | `string` | **Obrigatório**. Senha.         | 

-  <b>Endpoint responsável por:</b> Criar uma nova anotação do usuário.<br/>
```http 
  POST api/v1/annotation/save
``` 
| Parâmetro                | Tipo     | Descrição                                             | 
|:-------------------------|:---------|:------------------------------------------------------| 
| `user_id`                | `long`   | **Obrigatório**. Id do usuário.                       | 
| `card_name`              | `string` | **Obrigatório**. Título da anotação.                  | 
| `card_info.email`        | `string` | **Obrigatório**. Email do entrevistado, ou pessoa.    | 
| `card_infodescription.`  | `string` | **Obrigatório**. Descrição da anotação.               | 
| `card_info.address`      | `string` | **Obrigatório**. Endereço do entrevistado, ou pessoa. | 
| `card_info.phone_number` | `string` | **Obrigatório**. Telefone do entrevistado, ou pessoa. | 

-  <b>Endpoint responsável por:</b> Recuperar todas as anotações do usuário.<br/>
```http 
  GET api/v1/annotation/{{user_id}} 
``` 
| Parâmetro  | Tipo   | Descrição                       | 
|:-----------|:-------|:--------------------------------| 
| `user_id ` | `long` | **Obrigatório**. Id do usuário. | 

### WEB-SCRAPING.

-  <b>Endpoint responsável por:</b> Realizar a chamada que dá start ao processo de web-scraping. <br/>
- **Obs**.:
  - Somente usuários com permissão de ADMIN tem acesso a esse endpoint.
  - Para à execução, é necessário informar a agência em que será feito a coleta do dados. Atualmente contando somente com FBI e Interpol.
  - Para execução do processo de web-scraping no FBI, faz-se necessário a utilização de VPN (North America).
```http 
  POST api/v1/web-scraping/{{agency}}
``` 
| Parâmetro | Tipo     | Descrição                                                                      | 
|:----------|:---------|:-------------------------------------------------------------------------------| 
| `agency`  | `string` | **Obrigatório**. Agência em que será feito a coleta de dados. FBI ou Interpol. | 

### VERIFY-SUSPECT.

-  <b>Endpoint responsável por:</b> Recuperar todos os suspeitos envolvidos com Money Laudering.<br/>
```http 
  GET api/v1/verify-suspect/aml
``` 

-  <b>Endpoint responsável por:</b> Recuperar informações de um suspeito específico por Id.<br/>
```http 
  GET api/v1/verify-suspect/{{suspect_id}}
``` 
| Parâmetro    | Tipo   | Descrição                                  | 
|:-------------|:-------|:-------------------------------------------| 
| `suspect_id` | `long` | **Obrigatório**. Id (interno) do suspeito. | 

-  <b>Endpoint responsável por:</b> Recuperar informações de um suspeito específico por Id.<br/>
- **Obs**.:
  - Não se faz necessário o nome completo. Apenas com frações do nome, ele já terá um retorno.
```http 
  GET api/v1/verify-suspect?name=
```
| Parâmetro | Tipo     | Descrição                                      | 
|:----------|:---------|:-----------------------------------------------| 
| `name`    | `string` | **Obrigatório**. Nome desejável para consulta. | 

## CONTRIBUIÇÃO:
1. Faça um fork desse repositório;
2. Cria uma branch com a sua feature: `git checkout -b minha-feature`;
3. Faça commit das suas alterações: `git commit -m 'feat: Minha nova feature'`;
4. Faça push para a sua branch: `git push origin minha-feature`.
5. Depois que o merge da sua pull request for feito, você pode deletar a sua branch.

## INTEGRAÇÃO:
FBI API ([https://api.fbi.gov/](https://api.fbi.gov)).
INTERPOL API ([https://ws-public.interpol.int/notices/v1](https://ws-public.interpol.int/notices/v1)).

## UTEIS
Segue o link de informações adicionais da aplicação: 
Notion: (https://www.notion.so/42VerifySafe-c1e6d64c02d64676992220dd5d64c3ea).

### INFO
Desenvolvedor: Victor Hugo Arruda
Contato: (https://beacons.ai/tor_hugo)
