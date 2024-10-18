```toml
name = 'Filtrar Carros'
description = '/api/v0/carros'
method = 'GET'
url = 'http://localhost:8080/api/v0/carros?marca=Fiat'
sortWeight = 6000000
id = '06630ff7-e9bf-4c6a-adcc-8ec010f2c7cd'

[[queryParams]]
key = 'marca'
value = 'Fiat'

[[queryParams]]
key = 'modelo'
value = 'Ford Ka'
disabled = true

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
