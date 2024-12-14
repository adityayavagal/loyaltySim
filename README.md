
# Loyalty Simulator

This simulation demonstrates how a loyalty program applies discounts to users at checkout. Specifically, every Nth user (e.g., every 5th user) receives a 10% discount on their total purchase.


## Documentation

- The application is built on spring boot and follows standard MVC pattern.
- It uses singleton classes as Database Objects(it doesn't use any backend DB).



## Project structure

The project consists of following packages.

- **com.aditya.loyaltysim** - consists of springboot runner file.
- **com.aditya.loyaltysim.config** - consists of springboot configurations such as CORS enabling.
- **com.aditya.loyaltysim.controller** - consists of all the REST API controllers
- **com.aditya.loyaltysim.services** - consists of business layer logic
- **com.aditya.loyaltysim.model** - consists of classes which represent the structure of the data in DB.
- **com.aditya.loyaltysim.persistence** - consists of classes which are use to simulate Data tables.
- The Nth order and discount value is set using application.yml file which is nothing but a properties file in springboot.
- **coupon.config.target** defines the N value(application.yml).
- **coupon.config.discount** defines the discount value in percent(application.yml).
## Running and building the application

- Running the application, from the root folder of the project run following command
```
./mvnw spring-boot:run
```

- Building the application, from the root folder of the project run the following command
```
mvn clean install
```
## REST API's (localhost:8080)

- **GET** /api/products (gets the list of products)
Response Body:
```
[{
        "id": "m1",
        "name": "Mac & Cheese",
        "description": "Creamy cheddar cheese mixed with perfectly cooked macaroni, topped with crispy breadcrumbs. A classic comfort food.",
        "image": "images/mac-and-cheese.jpg",
        "price": 8.99
}]
```

- **POST** /api/order (post an order)
Request Body:
```
{
    "items": [
      {
        "id": "m2",
        "name": "Margherita Pizza",
        "price": "12.99",
        "description": "A classic pizza with fresh mozzarella, tomatoes, and basil on a thin and crispy crust.",
        "image": "images/margherita-pizza.jpg",
        "quantity": 3
      },
      {
        "id": "m1",
        "name": "Mac & Cheese",
        "description": "Creamy cheddar cheese mixed with perfectly cooked macaroni, topped with crispy breadcrumbs. A classic comfort food.",
        "image": "images/mac-and-cheese.jpg",
        "price": 8.99,
        "quantity": 2
        }
    ],
    "coupon": "6MX901XK",
    "customer": {
      "name": "aditya",
      "email": "xyx@fmali.com",
      "street": "sdsd",
      "postalCode": "787856",
      "city": "sdsrwefsd"
    }
}
```
Response: 200 OK
- **GET** /api/order (Gets the list of orders)
Response Body:
```
[
    {
        "items": [
            {
                "id": "m2",
                "name": "Margherita Pizza",
                "description": "A classic pizza with fresh mozzarella, tomatoes, and basil on a thin and crispy crust.",
                "image": "images/margherita-pizza.jpg",
                "quantity": 3,
                "price": 12.99
            }
        ],
        "customer": {
            "name": "aditya",
            "email": "xyx@fmali.com",
            "street": "sdsd",
            "postalCode": 787856,
            "city": "sdsrwefsd"
        },
        "totalPrice": 38.97,
        "coupon": null
    }
]
```
- **POST** /api/admin/generateCoupon (Generate Coupon code as Admin)
- **Desc**: The admin will be able to create coupon code only N-1 th order so that it can be applied in Nth order.
Response Body:
```
{
    "id": 1,
    "couponCode": "NVBYWNK8",
    "createdAt": "2024-12-14T18:45:16.906+00:00",
    "reedemedAt": null,
    "discount": 10.0,
    "reedemed": false
}
```
- **GET** /api/admin/getInsights (Gets Analytical data for admin)
```
{
    "totalSales": 69.94,
    "coupons": [
        {
            "id": 1,
            "couponCode": "NVBYWNK8",
            "createdAt": "2024-12-14T18:45:16.906+00:00",
            "reedemedAt": null,
            "discount": 10.0,
            "reedemed": false
        }
    ],
    "totalDiscounts": 0.0,
    "productSales": [
        {
            "id": "m1",
            "name": "Mac & Cheese",
            "unitPrice": 8.99,
            "totalSaleQuantity": 2,
            "totalSaleValue": 17.98
        },
        {
            "id": "m2",
            "name": "Margherita Pizza",
            "unitPrice": 12.99,
            "totalSaleQuantity": 4,
            "totalSaleValue": 51.96
        }
    ]
}
```


## 🔗 Links
[Frontend App](https://github.com/adityayavagal/checkoutUI.git)

