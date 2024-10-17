```toml
name = 'Listar carros no banco'
description = '/api/v0/carros'
method = 'GET'
url = 'http://localhost:8080/api/v0/carros'
sortWeight = 1000000
id = '0585461c-415a-4fb6-941c-cd52b94aeb76'

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
