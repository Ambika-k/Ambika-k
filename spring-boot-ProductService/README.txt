This application demonstrates the Product service.

REST call details:

POST:

TO INSERT THE RECORD INTO PRODUCT ENTITY
https:localhost:4444/product-api/products
<ProductDto>
    <productId>1</productId>
    <productName>Laptop</productName>
    <productPrice>50000</productPrice>
    <productQuantity>2</productQuantity>
</ProductDto>

GET :

1)TO GET THE PRODUCT DETAILS BASED ON ID
https://localhost:4444/product-api/products/{productId}

2)TO GET ALL THE PRODUCT DETAILS
https://localhost:4444/product-api/products
As Paging and sorting concepts were added we can get the records based on the pagenumber, pagesize,sorting property (asc& desc).
https://localhost:4444/product-api/products/?pageNumber:=0&pageSize:=3&sortBy=productPrice&dir=DESC
{Here we get records sorted based on productPrice}
If we didnt mention those values then based on default values the records will be retrieved.

3)TO GET THE PRODUCT DETAILS BASED ON productName
https://localhost:4444/product-api/products/name/{productName}

4)TO GET THE PRODUCT DETAILS WHICH SATISFIES  BOTH PRODUCTNAME AND PRODUCTPRICE
https://localhost:4444/product-api/products/{productName}/{productPrice}

5)TO GET THE PRODUCT DETAILS WHICH SATISFIES  ONE OF BOTH i.e., PRODUCTNAME AND PRODUCTPRICE
https://localhost:4444/product-api/products/or/{productName}/{productPrice}

6)TO GET THE THE PRODUCT DETAILS HAVING THE PRODUCTNAME ORDERED BY PRODUCTQUANTITY
https://localhost:4444/product-api/products/order/{productName}

PUT:
TO UPDATE THE PRODUCT DETAILS
https://localhost:4444/product-api/products/{productId}


DELETE:
TO DELETE THE RECORD FROM PRODUCT
https://localhost:4444/product-api/products/{productId}

