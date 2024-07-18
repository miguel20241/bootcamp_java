# Practicas de MySQL

Solución a los ejercicios de [https://www.practice-sql.com](https://www.practice-sql.com/)

# Northwind database
# EASY LEVEL 
## 1. Show the category_name and description from the categories table sorted by category_name.
~~~sql
SELECT category_name, description FROM categories;
~~~
## 2. Show all the contact_name, address, city of all customers which are not from 'Germany', 'Mexico', 'Spain'
~~~sql
SELECT contact_name, address, city 
FROM customers 
WHERE country NOT IN ('Germany', 'Mexico', 'Spain');
~~~
## 3. Show order_date, shipped_date, customer_id, Freight of all orders placed on 2018 Feb 26
~~~sql
SELECT order_date, shipped_date, customer_id, freight 
FROM orders
WHERE order_date = '2018-02-26';
~~~
## 4. Show the employee_id, order_id, customer_id, required_date, shipped_date from all orders shipped later than the required date
~~~sql
SELECT employee_id, order_id,customer_id, required_date,shipped_date
FROM orders
WHERE shipped_date > required_date;
~~~
## 5. Show all the even numbered Order_id from the orders table
~~~sql
SELECT order_id
FROM orders
WHERE MOD(order_id, 2) = 0;
~~~
## 6. Show the city, company_name, contact_name of all customers from cities which contains the letter 'L' in the city name, sorted by contact_name
~~~sql
SELECT city, company_name, contact_name
FROM customers
WHERE city LIKE '%L%' order by contact_name;
~~~
## 7. Show the company_name, contact_name, fax number of all customers that has a fax number. (not null)
~~~sql
SELECT company_name, contact_name, fax
FROM customers
WHERE fax Is not null;
~~~
## 8. Show the first_name, last_name. hire_date of the most recently hired employee.
~~~sql
SELECT first_name, last_name, hire_date
FROM employees
order by hire_date DESC LIMIT 1;
~~~
## 9. Show the average unit price rounded to 2 decimal places, the total units in stock, total discontinued products from the products table.
~~~sql
SELECT round(avg(Unit_Price), 2) AS average_price,
SUM(units_in_stock) AS total_stock,
SUM(discontinued) as total_discontinued
FROM products;
~~~

# MEDIUM LEVEL
## 1. Show the ProductName, CompanyName, CategoryName from the products, suppliers, and categories table
~~~sql
SELECT product_name, company_name, category_name
FROM products p
LEFT JOIN suppliers s ON p.supplier_id = s.supplier_id
LEFT JOIN categories c ON p.category_id = c.category_id;
~~~
## 2. Show the category_name and the average product unit price for each category rounded to 2 decimal places.
~~~sql
SELECT c.category_name, ROUND(avg(p.unit_price),2)
FROM products p
LEFT JOIN categories c ON p.category_id = c.category_id
GROUP BY p.category_id;
~~~
## 3. Show the city, company_name, contact_name from the customers and suppliers table merged together. Create a column which contains 'customers' or 'suppliers' depending on the table it came from.
~~~sql
SELECT c.city, c.company_name, c.contact_name, 'customers' AS relationship
FROM customers c
UNION 
SELECT s.city, s.company_name, s.contact_name, 'suppliers' AS relationship 
FROM supplier
~~~
# HARD LEVEL
## 1. Show the employee's first_name and last_name, a "num_orders" column with a count of the orders taken, and a column called "Shipped" that displays "On Time" if the order shipped_date is less or equal to the required_date, "Late" if the order shipped late. Order by employee last_name, then by first_name, and then descending by number of orders.
~~~sql
SELECT
  e.first_name,
  e.last_name,
  COUNT(o.order_id) As num_orders,
  (
    CASE
      WHEN o.shipped_date <= o.required_date THEN 'On Time'
      ELSE 'Late'
    END
  ) AS shipped
FROM orders o
  JOIN employees e ON e.employee_id = o.employee_id
GROUP BY
  e.first_name,
  e.last_name,
  shipped
ORDER BY
  e.last_name,
  e.first_name,
  num_orders DESC
~~~
## 2. Show how much money the company lost due to giving discounts each year, order the years from most recent to least recent. Round to 2 decimal places
~~~sql
SELECT
  YEAR(o.order_date) as 'order_year',
  ROUND(
    SUM(od.quantity * p.unit_price * od.discount),
    2
  ) as 'discount_amount'
FROM order_details od
  LEFT JOIN products p ON p.product_id = od.product_id
  left join orders o on o.order_id = od.order_id
GROUP BY year(o.order_date) 
ORDER BY 'order_year' DESC;
~~~
