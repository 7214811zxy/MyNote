# INTRODUCTION

所有代码和解释都来源于MySQL官方教程。

## SELECT

`select`语句允许你从一张或多张tables中读取数据，你可以按照如下语法规范在MySQL中使用他

> The `SELECT` statement allows you to read data from one or more tables. To write a `SELECT` statement in MySQL, you follow this syntax:
>
> **SELECT** 
>
> ​	select_list 
>
> **FROM** 
>
> ​	table_name;

## WHERE

#### 执行顺序

![image-20200818094332803](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200818094332803.png)

![image-20200818152703230](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200818152703230.png)

#### =

```sql
# 从表employees中，
# 找出那些jobtitle = 'Sales Rep'的项
# 选出那些项的lastname, firstname 和 jobtitle字段的信息
# 并基于officeCode排序
SELECT 
    lastname, 
    firstname, 
    jobtitle,
    officeCode
FROM
    employees
WHERE
    jobtitle = 'Sales Rep';
ORDER BY
	officeCode
	
```

#### AND

```sql
SELECT 
    lastname, 
    firstname, 
    jobtitle,
    officeCode
FROM
    employees
WHERE
    jobtitle = 'Sales Rep' AND 
    officeCode = 1;
```

#### OR

```sql
SELECT 
    lastName, 
    firstName, 
    jobTitle, 
    officeCode
FROM
    employees
WHERE
    jobtitle = 'Sales Rep' OR 
    officeCode = 1
ORDER BY 
    officeCode , 
    jobTitle;
```

#### BETWEEN

```sql
SELECT 
    firstName, 
    lastName, 
    officeCode
FROM
    employees
WHERE
    officeCode BETWEEN 1 AND 3
ORDER BY officeCode;
```

#### LIKE

'%son'可以匹配到"yson、myson、myyyson、myyyyyyson..."

'_son'可以匹配到"ason、bson、6son"但是不能匹配到"aason、bbson等"

> The `%` wildcard matches any string of zero or more characters while the `_` wildcard matches any single character.

```sql
SELECT 
    firstName, 
    lastName
FROM
    employees
WHERE
    lastName LIKE '%son'
ORDER BY firstName;
```

#### IN

```sql
SELECT 
    firstName, 
    lastName, 
    officeCode
FROM
    employees
WHERE
    officeCode IN (1 , 2, 3)
ORDER BY 
    officeCode;
```

#### IS NULL

在数据库的世界中，`null`是一种标记，用于表示信息的缺失或者未知。`null`并不等于数字0或者空字符串

> In the database world, `NULL` is a marker that indicates a piece of information is missing or unknown. It is not equivalent to the number 0 or an empty string.

```sql
SELECT 
    lastName, 
    firstName, 
    reportsTo
FROM
    employees
WHERE
    reportsTo IS NULL;
```

| **Operator** |                       **Description**                        |
| :----------- | :----------------------------------------------------------: |
| =            |     Equal to. You can use it with almost any data types.     |
| <> or !=     |                        Not equal to.                         |
| <            | Less than. You typically use it with numeric and date/time data types. |
| \>           |                        Greater than.                         |
| <=           |                    Less than or equal to.                    |
| \>=          |                   Greater than or equal to                   |

## DISTINCT

一张table中往往包含重复的值。如果在想要获得去重后的结果，可以在`SELECT`语句中使用`DISTINCT`指令

> When querying data from a table, you may get duplicate rows. In order to remove these duplicate rows, you use the `DISTINCT` clause in the `SELECT` statement.

```sql
SELECT DISTINCT
	lastname
FROM
    employees
ORDER BY 
    lastname;
```

#### 关于DISTINCT和NULL

如果某一列数据包含了`NULL`,而且你对该列使用了`DISTINCT`指令。在最后的查询结果中只会出现一个`NULL`。换句话说，`DISTINCT`并没有区别对待`NULL`和其他数据类型。

> If a column has `NULL` values and you use the `DISTINCT` clause for that column, MySQL keeps only one `NULL` value because `DISTINCT` treats all `NULL` values as the same value.

#### 关于多列数据的DISTINCT

`DISTINCT`可以同时应用于多列。在这种情况下，最后的结果将显示的是所选列的唯一组合

> You can use the `DISTINCT` clause with more than one column. In this case, MySQL uses the combination of values in these columns to determine the uniqueness of the row in the result set.

举个例子 有`DISTINCT`

```sql
SELECT DISTINCT
    state, city
FROM
    customers
WHERE
    state IS NOT NULL
ORDER BY 
    state, 
    city;
```

![image-20200818110921988](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200818110921988.png)

没有 `DISTINCT`

```SQL
SELECT 
    state, city
FROM
    customers
WHERE
    state IS NOT NULL
ORDER BY 
    state , 
    city;
```

![image-20200818111003898](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200818111003898.png)

#### 关于DISTINCT和GROUP BY

如果在`SELECT`语句中使用`GROUP BY`但不使用内置函数，`GROUP BY`和`DISTINCT`在行为上看起来是一样的。

> If you use the `GROUP BY` clause in the `SELECT` statement without using [aggregate functions](https://www.mysqltutorial.org/mysql-aggregate-functions.aspx), the `GROUP BY` clause behaves like the `DISTINCT` clause.

通常来说，`DISTINCT`是`GROUP BY`的一个特例。他们两个之间的主要区别是，`GROUP BY`会将查询结果进行排序，但是`DISTINCT`不会。但是但是！MySQL8.0之后，`GROUP BY`的隐式排序被移除了！:crying_cat_face: ~所以他们两个基本没啥区别咯？？？

#### 关于DISTINCT和aggregate function

当`DISTINCT`和内置函数组合使用时。会先执行去重，再执行函数。

> You can use the `DISTINCT` clause with an [aggregate function](https://www.mysqltutorial.org/mysql-aggregate-functions.aspx) e.g., [SUM](https://www.mysqltutorial.org/mysql-sum/), [AVG](https://www.mysqltutorial.org/mysql-avg/), and [COUNT](https://www.mysqltutorial.org/mysql-count/), to remove duplicate rows before the aggregate functions are applied to the result set.

#### 关于DISTINCT和LIMIT

当`DISTINCT`和`LIMIT`组合使用时，先去重再检查`LIMIT` 而且这玩意儿似乎时动态的。就是说，当数量达到设定值后，会直接结束搜索。并不是把所有的值取出，去重之后再进行`LIMIT`操作。

> In case you use the `DISTINCT` clause with the `LIMIT` clause, MySQL immediately stops searching when it finds the number of unique rows specified in the `LIMIT` clause.

## OR

#### 关于逻辑运算的顺序

当组合使用一个以上的逻辑运算符，而且没有使用' ( ) '提升特定操作的优先级的话，MySQL总是先计算`AND`运算再执行`OR`运算

> When you use more than one logical operator in an expression, MySQL always evaluates the `OR` operators after the `AND` operators. 

举例来说

```sql
# 返回表customer中那些locate = usa或者france，同时creditLimit>100000的人
SELECT   
	customername, 
	country, 
	creditLimit
FROM   
	customers
WHERE(country = 'USA'
		OR country = 'France')
	  AND creditlimit > 100000;
```

```sql
# 返回表customer中那些locate = usa的人，或者locate = france，同时creditLimit > 100000的人
SELECT    
	customername, 
	country, 
	creditLimit
FROM    
	customers
WHERE country = 'USA'
		OR country = 'France'
		AND creditlimit > 10000;
```

## IN

#### 关于IN和subquery

`IN`通常和`subquery`组合使用。首先使用subquery获取一个数组，然后把这个数组再作为`IN`的输入

> The `IN` operator is often used with a [subquery](https://www.mysqltutorial.org/mysql-subquery/). Instead of providing a list of literal values, the subquery gets a list of values from one or more tables and uses them as the input values of the `IN` operator.

例如下面的语句实现了如下功能：

**subquery**: 从表orderDetails计算orderNumber对应的总价，返回总价 > 60000的orderNumber组成的数组，这里成为sublist。

**parentQuery**: 从表orders中返回那些orderNumber在sublist中的项的orderNumber、customerNumber、status和shippedDate。

```sql
SELECT    
	orderNumber, 
	customerNumber, 
	status, 
	shippedDate
FROM    
	orders
WHERE orderNumber IN
(
	 SELECT 
		 orderNumber
	 FROM 
		 orderDetails
	 GROUP BY 
		 orderNumber
	 HAVING SUM(quantityOrdered * priceEach) > 60000
);
```

## BETWEEN

#### 关于BETWEEN在日期上的使用

```sql
SELECT 
   orderNumber,
   requiredDate,
   status
FROM 
   orders
WHERE 
   requireddate BETWEEN 
     CAST('2003-01-01' AS DATE) AND 
     CAST('2003-01-31' AS DATE);
```

## LIKE

#### 关于模板字符串中的转义符

> Sometimes the pattern, which you want to match, contains wildcard character e.g., 10%, _20, etc. In this case, you can use the `ESCAPE` clause to specify the escape character so that MySQL will interpret the wildcard character as a literal character. If you don’t specify the escape character explicitly, the backslash character `\` is the default escape character.

```sql
# 匹配包含“_20”的字符串，比如可以匹配到"S24_2022"
SELECT 
    productCode, 
    productName
FROM
    products
WHERE
    productCode LIKE '%\_20%';
```

```sql
# 自定义转义符，可以匹配到"S24%2026"
SELECT 
    productCode, 
    productName
FROM
    products
WHERE
    productCode LIKE '%$%20%' ESCAPE '$';
```

## LIMIT

#### 关于LIMIT和ORDER BY

不使用`ORDER BY`时，使用`SELECT`查询后返回的行数据的排序是不确定的。对未排序的查询结果，使用`LIMIT`，得到的结果自然是不唯一的。所以，使用`LIMIT`搭配着`ORDER BY`是一个好习惯！:full_moon_with_face:

> The `SELECT` statement without an `ORDER BY` clause returns rows in an unspecified order. It means that rows can be in any order. When you apply the `LIMIT` clause to this unordered result set, you will not know which rows the query will return.
>
> Therefore, it is a good practice to always use the `LIMIT` clause with the `ORDER BY` clause to constraint the result rows in unique order.

#### 使用LIMIT实现分页

第一页

```sql
SELECT 
    customerNumber, 
    customerName
FROM
    customers
ORDER BY customerName    
LIMIT 10; // 显示前10个（包含10）
```

第二页

```sql
SELECT 
    customerNumber, 
    customerName
FROM
    customers
ORDER BY customerName    
LIMIT 10, 10; // 显示第11个到到第20个(包含20)
```

#### 使用LIMIT获取第n个highest或者lowest 

获取查询排序后正数第2个值

```sql
SELECT 
    customerName, 
    creditLimit
FROM
    customers
ORDER BY 
    creditLimit DESC    
LIMIT 1,1; #offset1，取1个; 即正序第2个
```

## 使用Aliases / 别名

连接lastName和firstName，查询结果重命名为"Full name"

```sql
SELECT
   CONCAT_WS(', ', lastName, firstname) AS `Full name`
FROM
   employees;
```

## JOIN

#### INNER JOIN

`inner join`指令会将第一张表和第二张表的每一行进行比较。如果两张表中的值，导致join条件为真，那么`inner join`指令就会创建一个新行，这个新行中会包含之前两张表的每一列。换句话说，`inner join`指令只返回那些值相互匹配的行。

> The inner join clause compares each row from the first table with every row from the second table. If values in both rows cause the join condition evaluates to true, the inner join clause creates a new row whose column contains all columns of the two rows from both tables and include this new row in the final result set. In other words, the inner join clause includes only rows whose values match.

```sql
SELECT 
    m.member_id, # 选出m中member_id的列
    m.name member_name, # 选出m.name重命名为member_name
    c.committee_id, # 选出c.committee_id
    c.name committee_name # 选出c.name重命名为committee_name
FROM
    members m # 选择members这张表，重命名为m
INNER JOIN committees c # 和重命名为c的表committees构成INNER JOIN 
	ON c.name = m.name; # 根据条件c.name = m.name进行evaluate
```

#### LEFT JOIN

和`inner join`类似，`left join`也需要`join`作为谓语动词。当使用`left join`对两张表进行joining进行操作时，就需要引入左右表的概念了。

`left join`从左表开始选择数据。左表中的每一行会和右表进行比较。如果被比较的两行中的值evaluate为真，`left join`就会创建一个新行，新行中将包含两种表中所有的列。

与`inner join`不同的是。如果有一些值没有被匹配，`left join`指令任然会创建一个新行，这个新行也包含了左表中所有的列和右表中所有的列，但是右表中缺失的值会用null来表示。

换句话说，左表还是那个左表，多加了一个右表，右表中缺失的就是null

> Similar to an inner join, a [left join](https://www.mysqltutorial.org/mysql-left-join.aspx) also requires a join-predicate. When joining two tables using a left join, the concepts of left and right tables are introduced.
>
> The left join selects data starting from the left table. For each row in the left table, the left join compares with every row in the right table. If the values in the two rows cause the join condition evaluates to true, the left join creates a new row whose columns contain all columns of the rows in both tables and includes this row in the result set.
>
> If the values in the two rows are not matched, the left join clause still creates a new row whose columns contain columns of the row in the left table and `NULL` for columns of the row in the right table.
>
> In other words, the left join selects all data from the left table whether there are matching rows exist in the right table or not. In case there is no matching rows from the right table found, NULLs are used for columns of the row from the right table in the final result set.

```sql
SELECT 
    m.member_id, 
    m.name member, 
    c.committee_id, 
    c.name committee
FROM
    members m
LEFT JOIN committees c USING(name);
```

#### CROSS JOIN

正交键。简单来说就是正交实验当中的表设计

> Unlike the inner join, left join, and right join, the [cross join](https://www.mysqltutorial.org/mysql-cross-join/) clause does not have a join condition. The right join makes a Cartesian product of rows from the joined tables. The cross join combines each row from the first table with every row from the right table to make the result set.
>
> Suppose the first table has `n` rows and the second table has `m` rows. The cross join that joins the first with the second table will return `nxm` rows.
>
> The following show the basic syntax of the cross join clause:

## SUBQUERY

