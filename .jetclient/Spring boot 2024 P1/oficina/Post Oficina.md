```toml
name = 'Post Oficina'
description = '/api/v0/oficinas'
method = 'POST'
url = 'http://localhost:8080/api/v0/oficinas/103/actions/entrada'
sortWeight = 2000000
id = '04cf73f6-9b39-464c-8938-4b2adc01b553'

[[headers]]
key = 'Authorization'
value = 'Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJwREI2R2UzZm1PSHBoUVdZNmVGb3ZTdHFTUkgyTk1WclNmelpOTjVKYzdJIn0.eyJleHAiOjE3MzIyMzU4MTMsImlhdCI6MTczMjIzNTc1MywiYXV0aF90aW1lIjoxNzMyMjM0MTM5LCJqdGkiOiI3NDk0MDEzZC01NWFkLTQ4NTMtYjVkMy05MGIzNDM4ZDhjNjAiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODcvcmVhbG1zL21hc3RlciIsImF1ZCI6WyJtYXN0ZXItcmVhbG0iLCJhY2NvdW50Il0sInN1YiI6ImZmZDEyYzdjLWQwNTEtNDJkZC05YWFhLTBkNGI0NmYxNDU2NSIsInR5cCI6IkJlYXJlciIsImF6cCI6ImpldGNsaWVudCIsInNlc3Npb25fc3RhdGUiOiJkNTkxNmY3ZC00MmVjLTRmODMtYWI2Zi1lNTVmNzBmNjIxMGQiLCJhY3IiOiIwIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHA6Ly9sb2NhbGhvc3Q6MjgyODIiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImNyZWF0ZS1yZWFsbSIsImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsibWFzdGVyLXJlYWxtIjp7InJvbGVzIjpbInZpZXctcmVhbG0iLCJ2aWV3LWlkZW50aXR5LXByb3ZpZGVycyIsIm1hbmFnZS1pZGVudGl0eS1wcm92aWRlcnMiLCJpbXBlcnNvbmF0aW9uIiwiY3JlYXRlLWNsaWVudCIsIm1hbmFnZS11c2VycyIsInF1ZXJ5LXJlYWxtcyIsInZpZXctYXV0aG9yaXphdGlvbiIsInF1ZXJ5LWNsaWVudHMiLCJxdWVyeS11c2VycyIsIm1hbmFnZS1ldmVudHMiLCJtYW5hZ2UtcmVhbG0iLCJ2aWV3LWV2ZW50cyIsInZpZXctdXNlcnMiLCJ2aWV3LWNsaWVudHMiLCJtYW5hZ2UtYXV0aG9yaXphdGlvbiIsIm1hbmFnZS1jbGllbnRzIiwicXVlcnktZ3JvdXBzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJzaWQiOiJkNTkxNmY3ZC00MmVjLTRmODMtYWI2Zi1lNTVmNzBmNjIxMGQiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6ImFkbWluIn0.RKqYWe4j_TOdnUA5UZOFJHPce8pqzKhOysLkNRLgpTnadwYF9e4SU0Gp9ctXK_aSZFo2xlDfgpX0VNHUqsSGEm16I2CczoO8fn4Vhd5NOieOvA77RJr6a_262iq_O1yAGUJmRr7NU0h8BvirbS_dENRcS2y3LVgBQHU2o3tO40Ktl9sYEyCS7BAVOZWwQfiVi574FVL4dIX-BqKiWlVg6gJWDXoSN5kc0dr2cPj6y9jZsbK-EWk-2FeZw64JK7KwZQ4pN7ZLp5inWYdgDaOqWGkxXGgZ6O5nMonfVJoO60CIeSdXfx1g3ekoW3cwzXBeCWijuYoJgWupctBA71T7zg'
disabled = true

[auth.oauth2]
authUrl = 'http://localhost:8087/realms/master/protocol/openid-connect/auth'
tokenUrl = 'http://localhost:8087/realms/master/protocol/openid-connect/token'
clientId = 'jetclient'

[body]
type = 'JSON'
raw = '''
{
   "nome": "Oficina nova" 
}'''
```
