```toml
name = 'Deletar Oficina Em Batch'
description = '/api/v0/oficinas'
method = 'DELETE'
url = 'http://localhost:8080/api/v0/oficinas'
sortWeight = 5000000
id = '6c290af7-ebbb-42d0-9205-f053726f3cfd'

[body]
type = 'JSON'
raw = '''
{
    "ids": [1,3,4,44]
}'''
```
