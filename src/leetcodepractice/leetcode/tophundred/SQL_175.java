package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class SQL_175 {
    //select p.firstName, p.lastName, a.city, a.state from Person p left join Address a on p.PersonId = a.PersonId

    /**
     * Employee 表：
     * +-------------+------+
     * | Column Name | Type |
     * +-------------+------+
     * | id          | int  |
     * | salary      | int  |
     * +-------------+------+
     * 在 SQL 中，id 是这个表的主键。
     * 表的每一行包含员工的工资信息。
     *
     *
     * 查询并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null(Pandas 则返回 None) 。
     *
     * 查询结果如下例所示。
     *
     * select IFNULL(t.salary, NULL) as SecondHighestSalary from (select salary from Employee order by salary desc) t limit 1, 1
     * SELECT
     *     IFNULL(
     *       (SELECT DISTINCT Salary
     *        FROM Employee
     *        ORDER BY Salary DESC
     *         LIMIT 1,1),
     *     NULL) AS SecondHighestSalary
     *
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */

    /**
     * 查询 Employee 表中第 n 高的工资。如果没有第 n 个最高工资，查询结果应该为 null 。
     *
     * 查询结果格式如下所示。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * Employee table:
     * +----+--------+
     * | id | salary |
     * +----+--------+
     * | 1  | 100    |
     * | 2  | 200    |
     * | 3  | 300    |
     * +----+--------+
     * n = 2
     * 输出:
     * +------------------------+
     * | getNthHighestSalary(2) |
     * +------------------------+
     * | 200                    |
     * +------------------------+
     * 示例 2:
     *
     * 输入:
     * Employee 表:
     * +----+--------+
     * | id | salary |
     * +----+--------+
     * | 1  | 100    |
     * +----+--------+
     * n = 2
     * 输出:
     * +------------------------+
     * | getNthHighestSalary(2) |
     * +------------------------+
     * | null                   |
     * +------------------------+
     *
     * CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
     * BEGIN
     * DECLARE M INT;
     *     SET M = N-1;
     *   RETURN (
     *       SELECT DISTINCT salary
     *       FROM Employee
     *       ORDER BY salary DESC
     *       LIMIT M, 1
     *   );
     * END
     *
     * 作者：力扣官方题解
     */

    /**
     * 查询并对分数进行排序。排名按以下规则计算:
     *
     * 分数应按从高到低排列。
     * 如果两个分数相等，那么两个分数的排名应该相同。
     * 在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字。
     * 按 score 降序返回结果表。
     *
     * 查询结果格式如下所示。
     * 输入:
     * Scores 表:
     * +----+-------+
     * | id | score |
     * +----+-------+
     * | 1  | 3.50  |
     * | 2  | 3.65  |
     * | 3  | 4.00  |
     * | 4  | 3.85  |
     * | 5  | 4.00  |
     * | 6  | 3.65  |
     * +----+-------+
     * 输出:
     * +-------+------+
     * | score | rank |
     * +-------+------+
     * | 4.00  | 1    |
     * | 4.00  | 1    |
     * | 3.85  | 2    |
     * | 3.65  | 3    |
     * | 3.65  | 3    |
     * | 3.50  | 4    |
     * +-------+------+
     *
     * SELECT
     *   S.score,
     *   DENSE_RANK() OVER (
     *     ORDER BY
     *       S.score DESC
     *   ) AS 'rank'
     * FROM
     *   Scores S;
     *
     */

    /**
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | num         | varchar |
     * +-------------+---------+
     * 在 SQL 中，id 是该表的主键。
     * id 是一个自增列。
     *
     *
     * 找出所有至少连续出现三次的数字。
     *
     * 返回的结果表中的数据可以按 任意顺序 排列。
     *
     * 结果格式如下面的例子所示：
     *  select count(1) c, num from Logs group by num
     *  select a.num as ConsecutiveNums from (select count(num) as c, num from Logs l group by l.num) a
     *  SELECT DISTINCT
     *     l1.Num AS ConsecutiveNums
     * FROM
     *     Logs l1,
     *     Logs l2,
     *     Logs l3
     * WHERE
     *     l1.Id = l2.Id - 1
     *     AND l2.Id = l3.Id - 1
     *     AND l1.Num = l2.Num
     *     AND l2.Num = l3.Num
     *
     *
     *
     */

    /**
     * ：Employee
     *
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | name        | varchar |
     * | salary      | int     |
     * | managerId   | int     |
     * +-------------+---------+
     * id 是该表的主键（具有唯一值的列）。
     * 该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
     *
     *
     * 编写解决方案，找出收入比经理高的员工。
     *
     * 以 任意顺序 返回结果表。
     *
     * 结果格式如下所示。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * Employee 表:
     * +----+-------+--------+-----------+
     * | id | name  | salary | managerId |
     * +----+-------+--------+-----------+
     * | 1  | Joe   | 70000  | 3         |
     * | 2  | Henry | 80000  | 4         |
     * | 3  | Sam   | 60000  | Null      |
     * | 4  | Max   | 90000  | Null      |
     * +----+-------+--------+-----------+
     * 输出:
     * +----------+
     * | Employee |
     * +----------+
     * | Joe      |
     * +----------+
     * 解释: Joe 是唯一挣得比经理多的雇员。
     * 通过次数
     * 304.1K
     * 提交次数
     * 443.3K
     * 通过率
     * 68.6%
     *
     * select e.name as Employee from Employee e left join Employee m on e.managerId = m.id where e.salary > m.salary
     */

    /**
     *
     * 表: Person
     *
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | email       | varchar |
     * +-------------+---------+
     * id 是该表的主键（具有唯一值的列）。
     * 此表的每一行都包含一封电子邮件。电子邮件不包含大写字母。
     *
     *
     * 编写解决方案来报告所有重复的电子邮件。 请注意，可以保证电子邮件字段不为 NULL。
     *
     * 以 任意顺序 返回结果表。
     *
     * 结果格式如下例。
     *
     * select email from ( select count(1) as c, email from Person group by email) a where a.c >=2
     * select Email, count(Email) as num
     * from Person
     * group by Email;
     *
     * select Email
     * from Person
     * group by Email
     * having count(Email) > 1;
     *
     */

    /**
     * Customers 表：
     *
     * +-------------+---------+
     * | Column Name | Type    |
     * +-------------+---------+
     * | id          | int     |
     * | name        | varchar |
     * +-------------+---------+
     * 在 SQL 中，id 是该表的主键。
     * 该表的每一行都表示客户的 ID 和名称。
     * Orders 表：
     *
     * +-------------+------+
     * | Column Name | Type |
     * +-------------+------+
     * | id          | int  |
     * | customerId  | int  |
     * +-------------+------+
     * 在 SQL 中，id 是该表的主键。
     * customerId 是 Customers 表中 ID 的外键( Pandas 中的连接键)。
     * 该表的每一行都表示订单的 ID 和订购该订单的客户的 ID。
     *
     * 找出所有从不点任何东西的顾客。
     *
     * 以 任意顺序 返回结果表。
     *
     * 结果格式如下所示。Customers
     * select name as Customers from Customers where id not in (select distinct(customerId) from Orders)
     *
     */

    /**
     * 表： Employee
     *
     * +--------------+---------+
     * | 列名          | 类型    |
     * +--------------+---------+
     * | id           | int     |
     * | name         | varchar |
     * | salary       | int     |
     * | departmentId | int     |
     * +--------------+---------+
     * 在 SQL 中，id是此表的主键。
     * departmentId 是 Department 表中 id 的外键（在 Pandas 中称为 join key）。
     * 此表的每一行都表示员工的 id、姓名和工资。它还包含他们所在部门的 id。
     *
     *
     * 表： Department
     *
     * +-------------+---------+
     * | 列名         | 类型    |
     * +-------------+---------+
     * | id          | int     |
     * | name        | varchar |
     * +-------------+---------+
     * 在 SQL 中，id 是此表的主键列。
     * 此表的每一行都表示一个部门的 id 及其名称。
     *
     *
     * 查找出每个部门中薪资最高的员工。
     * 按 任意顺序 返回结果表。
     * 查询结果格式如下例所示。
     *Department | Employee | Salary |
     *  select d.name as Department, e.name as Employee, e.salary as Salary  from Employee e
     *  left join Department d on e.departmentId = d.id
     *  where (e.salary, e.departmentId) in
     *  (
     *  select  MAX(salary), departmentId from Employee group by departmentId
     *  )
     *
     * SELECT
     *     Department.name AS 'Department',
     *     Employee.name AS '
     *
     * Employee',
     *     Salary
     * FROM
     *     Employee
     *         JOIN
     *     Department ON Employee.DepartmentId = Department.Id
     * WHERE
     *     (Employee.DepartmentId , Salary) IN
     *     (   SELECT
     *             DepartmentId, MAX(Salary)
     *         FROM
     *             Employee
     *         GROUP BY DepartmentId
     *     )
     * ;
     *
     * select d.Name as Department, e.Name as Employee, e.Salary from Employee e
     * left join Department d on e.DepartmentId = d.id
     * where (
     * select count(DISTINCT e2.Salary) from Employee e2 where e2.Salary > e.Salary and e2.DepartmentId = e.DepartmentId
     * ) < 3
     *
     *
     *SELECT
     *     d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
     * FROM
     *     Employee e1
     *         JOIN
     *     Department d ON e1.DepartmentId = d.Id
     * WHERE
     *     3 > (SELECT
     *             COUNT(DISTINCT e2.Salary)
     *         FROM
     *             Employee e2
     *         WHERE
     *             e2.Salary > e1.Salary
     *                 AND e1.DepartmentId = e2.DepartmentId
     *         )
     * ;
     *
     * 示例 1:
     */
}
