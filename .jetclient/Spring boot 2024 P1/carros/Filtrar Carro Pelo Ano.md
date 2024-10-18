```toml
name = 'Filtrar Carro Pelo Ano'
description = '/api/v0/carros'
method = 'GET'
url = 'http://localhost:8080/api/v0/carros/por-ano?ano=2002'
sortWeight = 7000000
id = '7961ea3a-7997-4133-8669-d48c453133dc'

[[queryParams]]
key = 'ano'
value = '2002'

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
