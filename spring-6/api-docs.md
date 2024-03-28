```json
{
  "openapi": "3.0.1",
  "info": {
    "title": "OpenAPI definition",
    "version": "v0"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/issue/{issueId}": {
      "put": {
        "tags": [
          "issue-controller"
        ],
        "summary": "close issue by id",
        "description": "Обновляет выдачу с указанным идентификатотом, отмечая время возвврата книги",
        "operationId": "closeById",
        "parameters": [
          {
            "name": "issueId",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          }
        }
      }
    },
    "/reader": {
      "get": {
        "tags": [
          "reader-controller"
        ],
        "summary": "get all readers",
        "description": "Загружает имена всех пользователей системы",
        "operationId": "getAll",
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Читатель"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Читатель"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Читатель"
                  }
                }
              }
            }
          }
        }
      },
      "post": {
        "tags": [
          "reader-controller"
        ],
        "summary": "creates new reader",
        "description": "Создаёт в базу данных нового читателя",
        "operationId": "createReader",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Читатель"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "201": {
            "description": "Created",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          }
        }
      }
    },
    "/issue": {
      "post": {
        "tags": [
          "issue-controller"
        ],
        "summary": "creates new issue",
        "description": "Создаёт новый запрос на выдачу книги читателю",
        "operationId": "issueBook",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Запрос на выдачу"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "201": {
            "description": "Created",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "409": {
            "description": "Conflict",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          }
        }
      }
    },
    "/book": {
      "get": {
        "tags": [
          "book-controller"
        ],
        "summary": "get all books",
        "description": "Загружает все книги из базы данных",
        "operationId": "getAllBooks",
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Книга"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Книга"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Книга"
                  }
                }
              }
            }
          }
        }
      },
      "post": {
        "tags": [
          "book-controller"
        ],
        "summary": "creates new book",
        "description": "Создаёт в базе данных запись с новой книгой",
        "operationId": "createBook",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/Книга"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "201": {
            "description": "Created",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          }
        }
      }
    },
    "/reader/{readerId}/issue": {
      "get": {
        "tags": [
          "reader-controller"
        ],
        "summary": "gets all reader issues ",
        "description": "Загражает список незакрытых выдач читателя с указанным идентификатором ",
        "operationId": "getIssuesByReaderId",
        "parameters": [
          {
            "name": "readerId",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Запрос на выдачу"
                  }
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Запрос на выдачу"
                  }
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/Запрос на выдачу"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/reader/{id}": {
      "get": {
        "tags": [
          "reader-controller"
        ],
        "summary": "get reader by id",
        "description": "Загружает имя пользователя по идентификатору",
        "operationId": "getById",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          }
        }
      },
      "delete": {
        "tags": [
          "reader-controller"
        ],
        "summary": "removes reader by id",
        "description": "Удаляет читателя с указанным идентификатором из базы данных",
        "operationId": "removeReaderById",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Читатель"
                }
              }
            }
          }
        }
      }
    },
    "/issue/{id}": {
      "get": {
        "tags": [
          "issue-controller"
        ],
        "summary": "get issue by id",
        "description": "Загружает выдачу по идентификатору",
        "operationId": "getById_1",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Запрос на выдачу"
                }
              }
            }
          }
        }
      }
    },
    "/book/{id}": {
      "get": {
        "tags": [
          "book-controller"
        ],
        "summary": "get book by id",
        "description": "Загружает книгу по идентификатору",
        "operationId": "getById_2",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          }
        }
      },
      "delete": {
        "tags": [
          "book-controller"
        ],
        "summary": "removes book by id",
        "description": "Удаляет книгу с указанным идентификатором из базы данных",
        "operationId": "removeBookById",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "404": {
            "description": "Not found",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          },
          "500": {
            "description": "Internal server error",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Книга"
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "Запрос на выдачу": {
        "required": [
          "UID Книги",
          "UID читателя"
        ],
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int64"
          },
          "UID читателя": {
            "type": "integer",
            "format": "int64"
          },
          "UID Книги": {
            "type": "integer",
            "format": "int64"
          }
        }
      },
      "Читатель": {
        "required": [
          "Имя читателя"
        ],
        "type": "object",
        "properties": {
          "Имя читателя": {
            "type": "string"
          }
        }
      },
      "Книга": {
        "required": [
          "Название книги"
        ],
        "type": "object",
        "properties": {
          "Название книги": {
            "type": "string"
          }
        }
      }
    }
  }
}
```
