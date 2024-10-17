```toml
name = 'Entrada de Veiculo'
description = '/api/v0/oficinas/{{oficinaId}}/actions/entrada'
method = 'POST'
url = 'http://localhost:8080/api/v0/oficinas/{{oficinaId}}/actions/entrada'
sortWeight = 1000000
id = '19b73a34-8f2c-448e-a898-0cbf77905f5b'

[body]
type = 'JSON'
raw = '''
{
    "carro": {
        "placaCarro": "hdd-0000",
        "marca": "",
        "modelo": "",
        "ano": 2023 
    },
    "idMecanico": 1,
    "cpfResponsavel": "111111",
    "cpfDono": "111111"
}'''
```
