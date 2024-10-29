```toml
name = 'Listar Carros na oficina'
description = '/api/v0/carros'
method = 'GET'
url = 'http://localhost:8080/api/v0/oficinas/1/entradas'
sortWeight = 6000000
id = 'eb1a1051-04f0-41f3-8d64-47e76b191571'

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
