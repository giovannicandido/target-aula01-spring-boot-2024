```toml
name = 'Criar carro no banco'
description = '/api/v0/carros'
method = 'POST'
url = 'http://localhost:8080/api/v0/carros'
sortWeight = 4000000
id = '2d22688a-1a1e-4b91-adbb-3191e0cf4037'

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
  "marca": "Fiat",
  "ano": 2002,
  "modelo": "Uno"
}'''
```
