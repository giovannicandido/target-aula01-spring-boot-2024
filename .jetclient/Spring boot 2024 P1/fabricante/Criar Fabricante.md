```toml
name = 'Criar Fabricante'
method = 'POST'
url = 'http://localhost:8080/api/v0/fabricantes'
sortWeight = 2000000
id = '71b5f665-fcdf-42ac-9289-ac2aa9491c26'

[body]
type = 'JSON'
raw = '''
{
  "id": 52,
  "nome": "Ford Atualizado Novamente",
  "endereco": {
    "logradouro": "Rua teste",
    "numero": 5000,
    "bairro": "Fazenda Severina"
  },
  "carros": [
    {
      "marca": "teste"
    }
  ]
}'''
```
