```toml
name = 'Editar Carro pelo id'
description = '/api/v0/carros/2'
method = 'PUT'
url = 'http://localhost:8080/api/v0/carros/2'
sortWeight = 5000000
id = 'ba11b1e0-62ba-4f00-997b-cadcdbf6e0f1'

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
