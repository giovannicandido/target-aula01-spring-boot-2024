```toml
name = 'Listar carros no banco Teste de escopo'
description = '/api/v0/carros'
method = 'GET'
url = 'http://localhost:8080/api/v0/carros'
sortWeight = 3000000
id = '0c6395bc-3851-4225-b9a5-1e26f9ced011'

[[headers]]
key = 'accept'
value = '*/*'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "nome": "teste do swagger"
}'''
```
