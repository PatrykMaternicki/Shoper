# Shoper
Rest Service for EComerce

#By uruchomić prawidłowo REST API skopiuj tą zawartość:
```
[
{	"prize" : 700,
	"description":"jakis produkt",
	"name" : "Chipset NVIDA Double SX600",
	"productCategory" : "Pamiec RAM"


},
{
	"prize" : 100,
	"description":"jakis produkt",
	"name" : "Chungaho RAM",
	"productCategory" : "Pamiec RAM"


},

{
	"prize" : 320,
	"description":"jakis produkt",
	"name" : "DDR7 System",
	"productCategory" : "Pamiec RAM"


},
{
	"prize" : 120,
	"description":"jakis produkt",
	"name" : "SATA HDD1",
	"productCategory" : "Dysk twardy"


},
{
	"prize" : 220,
	"description":"jakis produkt",
	"name" : "SATA HDD2",
	"productCategory" : "Dysk twardy"


},

{
  "description": "jakis produkt",
  "name": "SATA HDD3",
  "prize": 320,
  "productCategory": "Dysk twardy",
  "productId": 14
},
{
	"prize" : 1320,
	"description":"jakis produkt",
	"name" : "Jakaś płyta1",
	"productCategory" : "Plyty glowne"


},

{
	"prize" : 2220,
	"description":"jakis produkt",
	"name" : "Jakaś płyta2",
	"productCategory" : "Plyty glowne"


},
{
	"prize" : 12220,
	"description":"jakis produkt",
	"name" : "Jakaś karta31",
	"productCategory" : "Karty glowne"


},


{
	"prize" : 2220,
	"description":"jakis produkt",
	"name" : "Jakaś karta313",
	"productCategory" : "Karty glowne"


}
]
```
I wykonaj request post dla adresu URL 
## Przykładowe testy:

### GET:
Wyświetl listę wszystkich produktów.
-http://domain:8080/samplerestapp/rest/shop/

Wyświetl produkt o id.
http://domain:8080/samplerestapp/rest/shop/update/product/4

Wyświetl produkty, które mieszczą się w cenie:
http://domain:8080/samplerestapp/rest/shop/filter/prize/product/300/100

Wyświetl produkt,który posiada nazwę:
http://domain:8080/samplerestapp/rest/shop/filter/name/product/DDR7 System

Wyświetl produkt, które znajdują się w kategori
http://domain:8080/samplerestapp/rest/shop/filter/category/product/Dysk twardy

Wyświetl komentarze dla produktu o id:
http://domain:8080/samplerestapp/rest/shop/get/comment/on/1

### POST:
Dodaj listę produktów do bazy.
http://domain:8080/samplerestapp/rest/shop/add/base

Dodaj pojedynczy produkt.
http://domain:8080/samplerestapp/rest/shop/

Dodaj pojedynczy komentarz
http://domain:8080/samplerestapp/rest/shop/add/comment/1

### PUT:
Zaktualizuj produkt o id. 
http://domain:8080/samplerestapp/rest/shop/update/product/4

Usuń komentarz
http://domain:8080/samplerestapp/rest/shop/remove/comment/1/on/1




