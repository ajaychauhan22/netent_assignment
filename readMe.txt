1. Environment and software dependencies 
	A. java 8+
	B. Maven
	C. Eclipse
	
2. Instructions to launch/run the application
	A. Import application in eclipse as a Existing maven project.
	B. Application uses in memory h2 data base to make that persistence change the value of property from (spring.datasource.url=jdbc:h2:mem:testdb)
	to (spring.datasource.url=jdbc:h2:file:D:/data/demo) in application.properties file. Note that 'jdbc:h2:file:D:/data/demo' is a location of folder
	 on application running computer/machine.
	C. Right click on com.netent.bookstore.Application.java and run as Java program. 

3. After stating the application as per above steps(#2), Connect to DB with url-  http://localhost:8080/h2-console 
	A. Enter the required details :
			JDBC URL: jdbc:h2:file:D:/data/demo   (It is the value of spring.datasource.url property in application.properties file)
			User Name: sa
			Password: password
			
	Note All the values are available in application.properties.
		
4. API endpoint documentations are available on url-  http://localhost:8080/swagger-ui.html

5. For testing purpose, please execute following sql script after connecting to DB.

INSERT INTO Book (isbn, title, author, price, quantity) VALUES
('ISBN-1', 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit', '', 88, 9),
('ISBN-2', 'qui est esse', '', 22, 53),
('ISBN-3', 'ea molestias quasi exercitationem repellat qui ipsa sit aut', '', 69, 42),
('ISBN-4', 'eum et est occaecati', '', 1, 14),
('ISBN-5', 'nesciunt quas odio', '', 81, 81),
('ISBN-6', 'dolorem eum magni eos aperiam quia', '', 61, 3),
('ISBN-7', 'magnam facilis autem', '', 80, 4),
('ISBN-8', 'dolorem dolore est ipsam', '', 13, 12),
('ISBN-9', 'nesciunt iure omnis dolorem tempora et accusantium', '', 19, 5),
('ISBN-10', 'optio molestias id quia eum', '', 52, 25),
('ISBN-11', 'et ea vero quia laudantium autem', '', 36, 0),
('ISBN-12', 'in quibusdam tempore odit est dolorem', '', 75, 14),
('ISBN-13', 'dolorum ut in voluptas mollitia et saepe quo animi', '', 4, 94),
('ISBN-14', 'voluptatem eligendi optio', '', 59, 68),
('ISBN-15', 'eveniet quod temporibus', '', 65, 17),
('ISBN-16', 'sint suscipit perspiciatis velit dolorum rerum ipsa laboriosam odio', '', 52, 23),
('ISBN-17', 'fugit voluptas sed molestias voluptatem provident', '', 16, 0),
('ISBN-18', 'voluptate et itaque vero tempora molestiae', '', 46, 53),
('ISBN-19', 'adipisci placeat illum aut reiciendis qui', '', 97, 61),
('ISBN-20', 'doloribus ad provident suscipit at', '', 13, 36),
('ISBN-21', 'asperiores ea ipsam voluptatibus modi minima quia sint', '', 22, 2),
('ISBN-22', 'dolor sint quo a velit explicabo quia nam', '', 72, 64),
('ISBN-23', 'maxime id vitae nihil numquam', '', 83, 30),
('ISBN-24', 'autem hic labore sunt dolores incidunt', '', 36, 44),
('ISBN-25', 'rem alias distinctio quo quis', '', 67, 78),
('ISBN-26', 'est et quae odit qui non', '', 68, 27),
('ISBN-27', 'quasi id et eos tenetur aut quo autem', '', 36, 61),
('ISBN-28', 'delectus ullam et corporis nulla voluptas sequi', '', 9, 87),
('ISBN-29', 'iusto eius quod necessitatibus culpa ea', '', 61, 80),
('ISBN-30', 'a quo magni similique perferendis', '', 50, 34),
('ISBN-31', 'ullam ut quidem id aut vel consequuntur', '', 41, 14),
('ISBN-32', 'doloremque illum aliquid sunt', '', 25, 21),
('ISBN-33', 'qui explicabo molestiae dolorem', '', 16, 68),
('ISBN-34', 'magnam ut rerum iure', '', 73, 26),
('ISBN-35', 'id nihil consequatur molestias animi provident', '', 30, 77),
('ISBN-36', 'fuga nam accusamus voluptas reiciendis itaque', '', 1, 69),
('ISBN-37', 'provident vel ut sit ratione est', '', 0, 90),
('ISBN-38', 'explicabo et eos deleniti nostrum ab id repellendus', '', 8, 71),
('ISBN-39', 'eos dolorem iste accusantium est eaque quam', '', 16, 61),
('ISBN-40', 'enim quo cumque', '', 40, 60),
('ISBN-41', 'non est facere', '', 57, 67),
('ISBN-42', 'commodi ullam sint et excepturi error explicabo praesentium voluptas', '', 52, 3),
('ISBN-43', 'eligendi iste nostrum consequuntur adipisci praesentium sit beatae perferendis', '', 59, 32),
('ISBN-44', 'optio dolor molestias sit', '', 52, 16),
('ISBN-45', 'ut numquam possimus omnis eius suscipit laudantium iure', '', 45, 51),
('ISBN-46', 'aut quo modi neque nostrum ducimus', '', 64, 43),
('ISBN-47', 'quibusdam cumque rem aut deserunt', '', 88, 23),
('ISBN-48', 'ut voluptatem illum ea doloribus itaque eos', '', 69, 87),
('ISBN-49', 'laborum non sunt aut ut assumenda perspiciatis voluptas', '', 29, 15),
('ISBN-50', 'repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem', '', 29, 39),
('ISBN-51', 'soluta aliquam aperiam consequatur illo quis voluptas', '', 20, 89),
('ISBN-52', 'qui enim et consequuntur quia animi quis voluptate quibusdam', '', 90, 24),
('ISBN-53', 'ut quo aut ducimus alias', '', 96, 65),
('ISBN-54', 'sit asperiores ipsam eveniet odio non quia', '', 1, 11),
('ISBN-55', 'sit vel voluptatem et non libero', '', 82, 89),
('ISBN-56', 'qui et at rerum necessitatibus', '', 57, 27),
('ISBN-57', 'sed ab est est', '', 89, 40),
('ISBN-58', 'voluptatum itaque dolores nisi et quasi', '', 43, 90),
('ISBN-59', 'qui commodi dolor at maiores et quis id accusantium', '', 69, 86),
('ISBN-60', 'consequatur placeat omnis quisquam quia reprehenderit fugit veritatis facere', '', 3, 71),
('ISBN-61', 'voluptatem doloribus consectetur est ut ducimus', '', 45, 63),
('ISBN-62', 'beatae enim quia vel', '', 20, 19),
('ISBN-63', 'voluptas blanditiis repellendus animi ducimus error sapiente et suscipit', '', 19, 80),
('ISBN-64', 'et fugit quas eum in in aperiam quod', '', 80, 4),
('ISBN-65', 'consequatur id enim sunt et et', '', 78, 39),
('ISBN-66', 'repudiandae ea animi iusto', '', 52, 79),
('ISBN-67', 'aliquid eos sed fuga est maxime repellendus', '', 27, 69),
('ISBN-68', 'odio quis facere architecto reiciendis optio', '', 11, 6),
('ISBN-69', 'fugiat quod pariatur odit minima', '', 5, 59),
('ISBN-70', 'voluptatem laborum magni', '', 15, 0),
('ISBN-71', 'et iusto veniam et illum aut fuga', '', 79, 71),
('ISBN-72', 'sint hic doloribus consequatur eos non id', '', 72, 2),
('ISBN-73', 'consequuntur deleniti eos quia temporibus ab aliquid at', '', 81, 97),
('ISBN-74', 'enim unde ratione doloribus quas enim ut sit sapiente', '', 56, 26),
('ISBN-75', 'dignissimos eum dolor ut enim et delectus in', '', 94, 10),
('ISBN-76', 'doloremque officiis ad et non perferendis', '', 19, 53),
('ISBN-77', 'necessitatibus quasi exercitationem odio', '', 56, 48),
('ISBN-78', 'quam voluptatibus rerum veritatis', '', 20, 58),
('ISBN-79', 'pariatur consequatur quia magnam autem omnis non amet', '', 31, 48),
('ISBN-80', 'labore in ex et explicabo corporis aut quas', '', 71, 90),
('ISBN-81', 'tempora rem veritatis voluptas quo dolores vero', '', 84, 85),
('ISBN-82', 'laudantium voluptate suscipit sunt enim enim', '', 91, 29),
('ISBN-83', 'odit et voluptates doloribus alias odio et', '', 39, 94),
('ISBN-84', 'optio ipsam molestias necessitatibus occaecati facilis veritatis dolores aut', '', 24, 27),
('ISBN-85', 'dolore veritatis porro provident adipisci blanditiis et sunt', '', 68, 20),
('ISBN-86', 'placeat quia et porro iste', '', 45, 14),
('ISBN-87', 'nostrum quis quasi placeat', '', 86, 22),
('ISBN-88', 'sapiente omnis fugit eos', '', 19, 96),
('ISBN-89', 'sint soluta et vel magnam aut ut sed qui', '', 22, 78),
('ISBN-90', 'ad iusto omnis odit dolor voluptatibus', '', 74, 93),
('ISBN-91', 'aut amet sed', '', 34, 9),
('ISBN-92', 'ratione ex tenetur perferendis', '', 34, 89),
('ISBN-93', 'beatae soluta recusandae', '', 91, 62),
('ISBN-94', 'qui qui voluptates illo iste minima', '', 38, 80),
('ISBN-95', 'id minus libero illum nam ad officiis', '', 70, 47),
('ISBN-96', 'quaerat velit veniam amet cupiditate aut numquam ut sequi', '', 77, 10),
('ISBN-97', 'quas fugiat ut perspiciatis vero provident', '', 95, 13),
('ISBN-98', 'laboriosam dolor voluptates', '', 93, 34),
('ISBN-99', 'temporibus sit alias delectus eligendi possimus magni', '', 96, 68),
('ISBN-100', 'at nam consequatur ea labore ea harum', '', 53, 82),
('ISBN-101', 'est', '', 53, 82);