## Guestbook API

### Specification

| URI                      | HTTP Method | HTTP Status | Description                               |
|--------------------------|-------------|-------------|-------------------------------------------|
| guestbook.com/api/guests | POST        | 200 OK      | Saves guest entry with name and comment   |
| guestbook.com/api/guests | GET         | 200 OK      | Returns list of guest with their comments |


--- 

**POST https://ms-guestbook.herokuapp.com/api/guests**

RequestBody

```json
{
    "guestName" : "string",
    "comment" : "string"
}
```


---
**GET https://ms-guestbook.herokuapp.com/api/guests**

Response 

```json
    [
            {
                "guestName":"string",
                "comment" : "string"
            },
            {
                "guestName":"string",
                "comment" : "string"
            }
     ]

```