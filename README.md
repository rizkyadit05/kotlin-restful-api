# API Spec

## Authentication

All API must use this authentication

Request:
  - Header:
    - X-Api-Key: "your api key"

## Create Product
- Method: POST
- Endpoint: /api/product
- Header:
  - Content-Type: application/json
  - Accept: application/json

Body:
```json
{
  "productId": "string, unique",
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "productId": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Product
- Method: GET
- Endpoint: /api/product/{id_product}
- Header:
    - Accept: application/json

Response:
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "productId": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Update Product
- Method: PUT
- Endpoint: /api/product/{id_product}
- Header:
    - Content-Type: application/json
    - Accept: application/json

Body:
```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "productId": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Product
- Method: GET
- Endpoint: /api/product
- Header:
    - Accept: application/json
- Query Param:
  - size: 10
  - page: 1

Response:
```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "productId": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "productId": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "productId": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}
```

## Delete Product
- Method: DELETE
- Endpoint: /api/product/{id_product}
- Header:
    - Accept: application/json

Response:
```json
{
  "code": "number",
  "status": "string"
}
```


