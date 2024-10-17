```toml
name = 'Movimentacao Veiculo'
description = '{{baseUrl}}/estoques/{{estoqueID}}/actions/movimentar'
method = 'POST'
url = '{{baseUrl}}/estoques/{{estoqueID}}/actions/movimentar'
sortWeight = 2000000
id = 'ec974c36-4fbf-4f70-9a29-76f7d1ce4cae'

[body]
type = 'JSON'
raw = '''
{
    "idPeca": 1,
    "idLojaDestino": 3
}'''
```
