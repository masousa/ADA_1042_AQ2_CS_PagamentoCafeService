curl -X 'POST' \
  'http://localhost:9081/' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "tipoPagamento": "PIX",
  "nomeTitular": "Jose Joao da Silva",
  "valor": 50,
  "desconto": 50,
  "identificadorUsuario": "0a3abee5-ea4a-4306-95d2-d8aa343abd1a"
}'