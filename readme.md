# 简易聊天室构建笔记

#  Maven

## Maven的作用

* 项目构建
* 管理依赖
* 不需要将jar包拷贝到项目中
* jar包之间可能存在依赖关系，maven帮我们管理依赖关系

## Maven的配置

### 环境变量的配置

* 创建新的环境变量MAVEN_HOME
* 在path路径下添加%MAVEN_HOME%\bin
* 打开dos窗口输入mvn -version检查是否配置成功

### 仓库的配置

在Maven下conf文件settings.xml配置文件

* 修改默认本地仓库

默认本地仓库在用户的目录下

1. 创建本地资源仓库（创建文件夹，最好在Maven路径下创建，方便管理）

2. 找到localRepository标签，修改默认的本地仓库成刚刚创建的仓库的路径

![](https://i.postimg.cc/BZzXkLGT/2022-10-11-212407.png)

* 配置资源镜像仓库

默认的下载仓库在国外，为了提高下载速度，要配置国内的镜像网站

* 找到mirrors标签加上以下代码

```xml
<mirror>
    <id>alimaven</id>
    <mirrorOf>central</mirrorOf>
    <name>aliyun maven </name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>
```

* 在dos窗口输入`mvn help:system`下载资源jar包

### Maven在IDEA的配置

* 打开IDEA 的上侧菜单的File,选择Setting选项

* 在Maven中配置

  ![](https://i.postimg.cc/VkB1KJBF/2022-10-12-102431.png)

### 创建Maven的web项目

* 其web项目的结构如下

  /src/main/java/            java源码

  /src/main/resource     java各种配置文件，资源文件

  /src/main/webapp      web各种源文件，格式文件如css，js，html，jsp等

  /src/test/java               java测试代码

  /target                        文件编译过程中生成的.class文件，jar，war等

### pom.xml文件

pom是Maven工程的基本工作单元，是一个XML文件，包含了项目的基本信息，用于描述项目如何构建，声明项目依赖等等

* 新建maven工程，初始的pom.xml 文件

  ![](https://i.postimg.cc/TYdJXXjJ/2022-10-12-132909.png)

  <modeVersion>:声明项目描述遵循哪一个模型版本
  
  <groupID>:公司或者组织的唯一ID，并且配置时生成的路径也是由此生成
  
  <artifactID>：项目的唯一ID
  
* 添加依赖

  把项目所需要的jar包都添加依赖到pom.xml文件内，maven会从资源库自动将jar包加载到项目中

#  Mysql数据库

* 开启mysql服务 

  `net mysql start`

* 登陆 

  `mysql -uroot -p密码`

* 创建数据库,并进入

  `create database chatroom`

  `ues chatroom`

* 创建一个表

  ```mysql
  create table charcontent(
  id int primary key auto_increment,
  content varchar(50),
  flag int,
  time timestamp default current_timestamp
  );
  ```

  id为一条消息记录的唯一标识，

  content是消息的内容，

  time是用来记录发送消息时的时间，

  flag是来判断消息的状态用于逻辑删除

# WEB服务器

## JDK环境变量的配置

**配置JDK的目的：是为了在任意目录下可以使用到javac.exe和java.exe**

* 找到系统的环境变量设置，到系统变量

* 创建一个新的系统变量，名字叫做JAVA_HOME，将JDK的目录放到其变量中

  ![](https://i.postimg.cc/RFVtphsH/2022-10-12-140637.png)

* 将JAVA_HOME配置到path中，%JAVA_HOME%\bin

  ![](https://i.postimg.cc/FKPb40JZ/2022-10-12-140805.png)

## 在IDEA上部署tomcat

* 在项目右上角的找到Current File窗口，打开edit configuration

  ![](https://i.postimg.cc/WpB0d7yX/2022-10-12-181701.png)

* add New添加tomcat本地服务器，Server的Application设置tomcat的目录

  ![](https://i.postimg.cc/KYT28x39/2022-10-12-181759.png)

  ![](https://i.postimg.cc/C1Mm640j/2022-10-12-182219.png)

* 在Deployment下把项目添加进服务器

  ![](https://i.postimg.cc/XqbFzjdt/2022-10-12-182332.png)

  

# 前端

## html

* html是超文本标记语言（Hypertext Markup Language）

* html中的代码标签格式：
  1. `<html></html>`
  2. `<hr/>`自闭和标签
  3. 不分大小写
  4. html是一个不严谨的语言，不会报错
  
* 常见的标签
  1. `<html></html>`是html文件结构体的根标签
  
  2. `<head></head>`头标签，里面一般写都是针对页面的属性的设置
  
  3. `<meta/>`设置页面属性
  
  4. `<title>`设置页面标题
  
  5. `<div</div>`块级标签
  
  6. `<form</form>>`表单标签
  
     可以用来采集用户输入信息，用于和服务器进行数据的交互
  
     表单属性：
  
     action：设置表单所要提交的路径
  
     method：提交方式，有get和post方法。get方法为默认的值，会将表单项的数据会显示在地址上
  
     常见的表单项：
  
     `<input/>`，其属性type可以设置类型
  
     `<select></select>`，下拉选择表单
  
     表单通用的属性：
  
     id:代表唯一标识
  
     name：后台服务器会根据name属性来获取数据
  
     value：表示文本框的值，后台服务器所获取到的数据
  
* 有关CSS中的选择器

  1. 元素（标签）选择器： 标签名 { }

  2. id选择器：#id{}
  3. 类选择器：.class {}

     优先级：id选择器 > 类选择器  > 元素选择器

  4. *{}：通配符选择器
  5. 组合选择器：选择器1，选择器2{}
  6. 后类选择器：父类标签  子类标签{}
  7. 子类选择器：父类标签 > 子类标签{}

## JS

* **JS的基本概念**

  js，即javascript = ECMAScript（js的基础语法） + BOM（浏览器对象模型） + DOM （文档对象模型）

* **JS的引入方法**

  * 方法一：在html的头标签加`<script>js代码<script/>`
  * 方式二：在html中的头标签加入`<script src = "js文件名"></script>`

  **注意：script标签可以写多个并且写在任意位置，浏览器会自上而下解析html**

* **ECMAScript**

  1. js中的`if(条件表达式)`，条件表达式只有值为false，0，NaN，“”，null，undefin为false之外，其余都为true

  2. js中的方法：

     * 格式一：`function 方法名(形参) {方法体内容}`
     * 格式二：`var 变量名 function(形参) {方法体内容}`

  3. js的遍历：

     * 方式一：`for(var i =0; i < arr.length ; i++)`

     * 方式二：`for(i in arr) {}`

       方式二只会遍历出有效数据

* **BOM**

  **把浏览器中的各个组件拆分出来，都封装成了一个对象**

  * Navigator：浏览器对象
  * *Window：浏览器窗口对象
  * Location:浏览器地址栏对象
  * History:浏览器历史栏对象
  * Screen:浏览器参数对象
  * *Document:浏览器文档对象，即DOM对象

  1. Window对象

     里面的方法（可以不写对象名调用）：

     ```js
     alert()     //显示带一段消息和确认按钮的警告框
     confirm()   //确认和取消按钮
     prompt()	//显示可提示用户输入的对话框
     onload()	//当页面加载后执行的语句
     ```

* **DOM**

  把文档中的各个部分拆分出来，都封装成了一个对象；

  有Document，Element，Attribute，Text，Comment，Node对象

  * Document对象

    * 获取标签对象：`var 变量名 = docume.getElementById("id属性值")`

      操作标签中的文本数据：

      1. 获取标签文本数据：标签对象.innerHTML

      2. 修改标签文本数据：标签对象.innerHTML = "数据"；

      3. 追加标签文本数据：标签对象.innerHTML += "数据"；

    * Attribute对象：

      ```js
      setAttribute():数值属性
      getAttribute():获取属性
      removeAttribute():删除属性
      ```

## XML

* **xml的基本概念**

  xml是可扩展标记语言（Extensive Mark Language），相比于html，他没有提前预定好的标签，在xml中的标签是可以随便写的，是可以自定义的

* **xml的作用**

  可用于配置文件。那么xml作为配置文件和properties配置文件有什么区别。

  properties主要用于单项配置，而xml主要用于多项配置

* **xml的格式**

  1. xml文件的文档声明

     `<?xml version = "1.0" encoding = "utf-8"?>`

  2. xml文件有缺只能有一个根标签

  3. xml文件的属性要由引号或者双引号括起来

  4. xml文件是严格区分大小写的

* **xml约束**

  dtd约束：

  * 方式一：`<!DOCTYPE >根标签 [约束文档的内容]`将约束内容写入配置文件内
  * 方式二：`<!DOCTYPE> 根标签 "约束文档的文件名"`在本地获取约束文档
  * 方式三：`<!DOCTYPE> 根标签 PUBLIC "约束文档的文件名" "约束文档的URL"`通过公共资源获取

  用方式三来配置mybatis和其映射文件

  ![](https://i.postimg.cc/L4vQ9dK1/2022-10-13-133404.png)

  schema约束：schema约束文档自身也是一个xml文件。



# Servlet 

## servlet基础

> 是运行在Web服务器和服务器上的小程序，可以实现收集网页用户表单的输入内容、将数据库的内容信息输出到Web服务器上

* servlet是实现有三种方法

  * 实现Servlet接口，要重写五大方法
  * 继承GenericServlet类
  * 继承HttpServlet类

  对于这三种方法，我们日常最常用的方法是继承自 HttpServlet 类，提供了 Http 相关的方法，HttpServlet 扩展了 GenericServlet 类，而 GenericServlet 类又实现了 Servlet 类和 ServletConfig 类。

* servlet的参数配置

  在项目的web.xml文件中配置

  ```xml
  <servlet>
      <servlet-name>自定义名字</servlet-name>
      <servlet-class>servlet类的全路径名</servlet-class>
  </servlet>
  <servlet-mapping>
      <servlet-name>自定义名字（要和上面的一致）</servlet-name>
      <url-pattern>servlet的虚拟路径</url-pattern>
  </servlet-mapping>
  ```

* servlet的注解配置

  在servlet类上写

  `@WebServlet(“/servlet的虚拟路径”)`

## Http协议

http协议，即超文本传输协议（Hypertext Transfer Protocol）

* **特点**

  1. 是建立在tcp/ip协议基础之上的高级协议
  2. 默认端口是80
  3. 一次请求一次响应
  4. 是一种无状态协议，两次请求和响应互不干涉

* **浏览器发送请求消息的格式**

  ![](https://i.postimg.cc/kXdyqywL/2022-09-29-191707.png)

  * 请求行：

    请求方法 + 请求的URI +协议版本

  * 请求头

    格式：请求头的名称：请求头的值，请求头的值

    常见的请求头：

    * Accept：浏览器可接受的MIME类型

      MIME类型的格式：大的类型/小的类型，例如image/jpg

    * Cookie:

    * Referer:包含一个URL，用户从该URL代表的页面发出请求，可用于统计和防盗链

    * User-Agent：浏览器类型

* **http响应消息格式**

  格式：

  * 响应行：协议/版本  状态码

    状态码代表了此处请求和响应的状态信息

    常见的状态码：

    1. 消息：1xx，代表请求已接收，需要继续处理。

    2. 成功：2xx，响应成功

    3. 重定向：3xx，这类状态码表示需要客户端采取进一步操作才能完成请求

       302：重定向

       304：缓冲，当我们第二次之后在访问一个资源时，状态码就是304

    4. 请求错误：4xx，代表客户端发生错误，妨碍了服务器的处理

       404：资源找不到

       405：没有重写doGet（）或者doPost（）方法

    5. 服务器错误：5xx

  * 响应头：key：value

## Request对象

request对象是服务器帮助我们创建的一个对象，里面封装了所有请求消息格式中的数据，request被各种对象传递，最后传递到`doGet()`和`doPost()`方法中

* **获取请求消息的方法**

  ```java
  //获取请求行的方法
  String getMethod():获取请求的方式
  String getContextPath():获取项目的虚拟路径
  String getServletPath():获取访问的servlet的虚拟路径
  String getRequsetURI():获取请求URI
  StringBuffer getRequestURL():获取请求的URI
  String getQueryString();获取请求参数（只有get方法能用）
  String getProtocol()：获取协议版本号
  String getRemoteAddr()：获取IP地址
  //获取请求头的方法
  String getHeader(String name):根据请求头获取对应的值
  Enumeration<String> getHeaderNames():获取所有请求头
  Enumeration<String> getHeaders(String name):根据请求头获取对应的所有值
  //其它通用方法
  String getParameter(String name):根据表单项的name属性获取value的值
  Enumeration<String> getParameterNames():获取所有表单的name属性值
  String[] getParameterValues(String name):根据表单项的name属性值获取所有values值
  Map<String,String> getParameterMap():将所有的表单项的name属性值，values值封装到Map中
  request.setCharacterEncoding("utf-8")//设置服务器默认编码
  ```

* **请求转发的相关方法**

  ```java
  //Request对象获取RequestDispatcher对象
  public RequestDispatchar getRequestDispatcher(String path)
  //进行转发
  public void forward(ServletRequest request，ServletResponse reponse)
  ```

  转发的特点：

  1. 只能进行内部的跳转
  2. 地址值不会发生改变
  3. 只包含一次请求和一次响应

* **request的数据共享**

  request不是一般的对象，是javaWeb的四大域对象之一，它所管辖的范围是异常请求和一次响应之间的范围,因此只能用转发来实现资源的共享

  域对象通用的方法：

  ```java
  setAttribute(String key, Object value)
  getAttribute(String key)
  removeAttribute(String key)
  ```

## response对象

* **response基本方法**

```java
void setStatus(int sc);设置响应状态码
void setHeader(String name, String value);设置响应头和值
```

* **重定向的实现**

  方法一：

  ```java
  response.setStatus(302);//设置响应状态码
  response.setHeader("location", "URL");//设置响应头location
  ```

  方法二：

  ```java
  response.sendRedirect("URL");
  ```

  

## ServletContext对象

* 什么是ServletContext？

  代表当前的项目，每一个项目有且只有一个ServletContext对象，只有被服务器部署的时候，才有ServletContext

* Servlet的生命周期

  当服务器开启的时候，ServletContext被创建；当服务器关闭时，ServletContext就被销毁

* ServletContext对象的获取

  ```java
  ServletContext servletContext = request.getServletContext();
  
  ServletContext servletContext = this.getgetServletContext();
  ```

  不管获取多少次，ServletContext对象都是同一个

* ServletContext常见的方法

  ```java
  String getMimeType(String file):获取指定文件的MIME类型
  ```

* 获取项目下的资源的真实路径

  ```java
  String getRealPath(String path)
  ```

* 获取web.xml核心配置文件的参数

  ```xml
  <context-param>
      <param-name>键名</param-name>
      <param-value>键值</param-value>
  </context-param>
  ```

  ```java
  ServletContext servletContext = request.getServletCOntext();
  
  String value = servletContext.getInitParameter("键名");
  ```

# JSP

jsp，即Java Server Page，jsp就是一个能够写java代码的html页面；是一个动态资源 

* jsp的脚本

  ```jsp
  <% java代码 %>	存在于servlet中的service()方法中
  <%! java代码 %>	存在于servlet中的成员位置，类中的方法外
  <%= java代码 %>	会打印到浏览器上
  ```

* jsp的指令

  格式：

  ```jsp
  <%@ 指令名称 属性=属性值 属性名=属性值 ... %>
  ```

  指令：

  1. page

     主要用来对jsp页面进行各种配置的

     ```jsp
     <%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
     ```

     contentType属性：设置jsp翻译成servlet响应给浏览器的时候，服务器告诉浏览器响应数据的MIME类型和解析使用的编码方式

     pageEncoding属性：设置jsp翻译成servlet的时候使用什么编码

     isErrorPage属性：true值，就可以在jsp翻译成servlet中使用exception对象

     errorPage属性：设置错误界面，如果jsp中有错误的地方，就会跳转到错误页面

     isELIgnored属性：设置EL表达式是否可用

  2. include

     主要是用来包含其他的页面

     ```jsp
     <%@include file=".jsp"%>
     <jsp:include page=".jsp"/>
     ```

* jsp中九大内置对象

  | 对象的名称  | 对象的真实类型      | 对象的作用                              |
  | ----------- | ------------------- | --------------------------------------- |
  | pageContext | PageContext         | 四大域对象之一，域范围代表当前的jsp页面 |
  | session     | HttpSession         | 四大域对象之一，域范围是一次会话的范围  |
  | request     | HttpServletRequest  | 四大域对象之一，域范围是一次请求的范围  |
  | application | ServletContext      | 四大域对象之一，域范围是整个项目的范围  |
  | response    | HttpServletResponse | 响应对象，可以设置响应的消息            |
  | config      | ServletConfig       | 用来配置servlet的参数，获取参数等       |
  | out         | JspWrite            | 向页面写内容                            |
  | page        | Object              | jsp页面翻译成servlet的对象              |
  | exception   | Throwable           | 异常对象                                |

## EL表达式

* 什么是EL表达式

  Expression Language，目的是使JSP写起来更简单。

* EL表达式的格式：`${表达式}`

* 获取值（如果想要EL表达式来获取数据，必须将数据存储到域中，）

  ${域名.键名}

  ${键名}这种写法hi自动从域中查询键名，有就获取

  pageContext < request < session < application

  * 获取对象中的数据

    `${类名.属性名}`

  * 获取集合中的数据

    `${集合[索引]}`

  * 获取双列集合中的数据

    ${Map.键名}

# MyBatis

> MyBatis是基于ORM（对象关系映射）思想的一个框架，用java代码操作数据库的框架

* MyBatis的特点

  1. 灵活：mybatis不会对应用程序或者数据库的现有设计强加任何影响。sql写在xml文件中，便于统一的管理和优化
  2. ，解除了sql与程序代码的耦合，通过提供的DAO层，将业务逻辑和数据访问分离，使系统的设计更清晰，易维护

* 实现步骤

  1. 导入jar包

  2. 创建dao包下的接口

  3. 创建MyBatis核心配置文件（xml）

     ````xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!--约束文档-->
     <!DOCTYPE configuration
             PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
             "http://mybatis.org/dtd/mybatis-3-config.dtd">
     <configuration>
     <!--    <environments>可以配置多个环境，default属性使用指定的一个环境-->
         <environments default="mysql">
     <!--        环境的详细配置-->
             <environment id="mysql">
     <!--            配置事务管理器，type属性的JDBC，说明事务的管理底层使用的是JDBC的事务-->
                 <transactionManager type="JDBC"></transactionManager>
     <!--            配置数据源-->
     <!--            type属性值有个：-->
     <!--                POOLED:说明使用了数据库连接池，数据库连接池是MyBatis框架自己实现的连接池-->
     <!--                UNPOOLED:说明没有使用数据库连接池-->
     <!--                JNDI：JavaEE技术之一-->
                 <dataSource type="POOLED">
                     <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                     <property name="url" value="jdbc:mysql://localhost:3306/charroom"/>
                     <property name="username" value="root"/>
                     <property name="password" value="qddsfg123."/>
                 </dataSource>
             </environment>
         </environments>
         <mappers>
     <!--        配置具体的某一个映射文件，resource属性是关联映射文件的路径-->
             <mapper resource="com/dao/CharContentDao.xml"/>
         </mappers>
     </configuration>

  4. 创建Mybatis映射文件（xml）

     ```xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!--约束文档-->
     <!DOCTYPE mapper
             PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <!--配置映射文件的详细信息，namespace属性是配置这个映射里面操作的针对具体Dao的各种方法-->
     <mapper namespace="com.dao.CharContentDao">
     <!--    id属性是指定Dao中的哪一个具体的方法-->
     <!--    resultType属性是指定返回值类型-->
     <!--    parameterType属性指定的参数类型-->
         <insert id="addNewcontent" parameterType="com.pojo.CharContent">
             insert into charcontent (content,user,flag) values(#{content},#{username},1)
         </insert>
         <select id="findNewcontent" resultType="com.pojo.CharContent">
             select * from charcontent where flag = 1 order by id desc limit 10
         </select>
         <select id="findAllContent" resultType="com.pojo.CharContent">
             select * from charcontent where flag = 1
         </select>
         <delete id="deleteContent" parameterType="com.pojo.CharContent">
             delete from charcontent where id = #{id}
         </delete>
         <update id="logicDelete" parameterType="com.pojo.CharContent">
             update charcontent set flag = 0 where id = #{id}
         </update>
         <update id="recoverContent" parameterType="com.pojo.CharContent">
             update  charcontent set flag = 1 where  id =#{id}
         </update>
         <select id="findAllLogicDelete" resultType="com.pojo.CharContent">
             select * from charcontent where flag = 0
         </select>
     </mapper>
     ```

     

  5. 进行测试

     ```java
     //获取流对象，读取核心配置文件
     InputStream is = Resources.getResourAsStream("sqlMapConfig.xml");
     //创建SqlSession工厂的构建者对象
     SqlSessionFactoryBuilder sqlSessionFactory = new SqlSessionFactoryBuilder();
     //获取SqlSession工厂对象
     SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
     //获取SqlSession对象
     SqlSession sqlSession = sqlSessionFactory.openSession();
     //获取UserDao代理对象
     代理类名 对象名 = sqlSession.getMapper(User.class); 
     //执行方法
     对象名.方法名
     //提交事务，释放资源
     sqlSeesion.commit();
     sqlSession.close();
     ```

# jquery，Ajax和Json

## Jquery

> Jquery是一个快速、简洁的JavaScript框架，它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优化HTML文档操作、事件处理和Ajax交互

* 关于Jquery的引入方式：

  ```jsp
  <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
  ```

  **注意：`<script>`不能写成自闭标签的形式**

* js对象和jquery对象的相互转换

  js对象转换成jquery对象

  ```jsp
  var div = docume.getElementById("id的值");
  
  var jdiv = $(div);
  ```

  jquery对象转换成js对象

  ```jsp
  var jdiv = $("div");
  
  var div = jdiv.get(0);
  var div = jdiv[0];
  ```

  **注意：可以把jquery对象当成一个js中的数组容器来使用，里面的元素就是js的原生对象**

* jquery的入口函数

  js的写法：

  ```jsp
  window.onload = function() {} //如果写多个入口函数，下面的会把上面的覆盖掉
  ```

  jquery的写法：

  ```jsp
  $(function() {
  
  })//如果写多个入口函数，它们不会被覆盖，都会执行
  ```

  

* jquery事件处理

  ```jsp
  $(function() {
  	var jinput = $("input");
  	jinput.click(function() {
  		方法体;
  	})
  })
  ```

* **jquery的选择器**

  id选择器：$("#id值")

  类选择器：$(".class属性值")

  元素（标签）选择器：$("标签名")

  组合选择器：$("选择器1，选择器2，...")

  **基本过滤选择器：**

  $("标签名:first"):找到第一个

  $("标签名:last"):找到最后一个

  $("标签名:even"):从零开始偶数个

  $("标签名:odd"):从零开始奇数个

  ​	**表单选择器：**

  $("标签名:checked")：找到被选中的标签（复选框，单选框）

  $("标签名:selected")：找到被选中的标签（下拉框）

* jquery对dom进行操作

  ```jsp
  html() //html()是用来读取元素的html内容（包括html标签）
  text() //text()用来读取元素的纯文本内容，包括其后代元素
  val()  //val()是用来读取表单元素的"value"值
  ```

  **注意：**html()和.text()方法不能使用在表单元素上,而.val()只能使用在表单元素上；另外html()方法使用在多个元素上时，只读取第一个元素；val()方法和.html()相同，如果其应用在多个元素上时，只能读取第一个表单元素的"value"值，但是.text()和他们不一样，如果text()应用在多个元素上时，将会读取所有选中元素的文本内容。

* 关于节点的操作

  ```jsp
  对象A.append(对象B)：对象B添加到对象A中的后面
  
  对象A.appendTo(对象B)：对象A添加到对象B中的后面
  
  对象A.prepend(对象B)：对象B添加到对象A中的前面
  
  对象A.prependTo(对象B)：对象A添加到对象B中的前面
  
  对象A.after(对象B)：对象B添加到对象A外的后面
  
  对象A.insertAfter(对象B)：对象A添加到对象B外的后面
  
  对象A.before(对象B)：对象B添加到对象A外的前面
  
  对象A.insertBefore(对象B)：对象A添加到对象B外的前面
  ```

  

* jquery的遍历

  * `for(var i = 0 ; i < divs.length ; i++)`

  * `query对象.each(function(index,obj) {})`

    this代表遍历出来的元素；index代表索引；obj代表遍历出来的元素

  * `$.each(jquery对象, function(index,obj) {})`

  * `for(var i of divs)`

## Ajax

> Ajax即Asynchronous Javascript And XML,使用Ajax技术网页应用能够快速地将增量更新呈现在
>
> 用户界面上，而不需要重载（刷新）整个页面

* 什么是异步和同步

  在同一时刻，双方能够同时执行，即为异步

  在同一时刻，其中一方在执行，另一方只能等待

* 格式

  ```
  $.ajax({
      //请求的url地址
      url:"URL",
      //返回格式为json
      dataType:”json”,
      //请求是否为异步默认为异步
      async:true,
      //参数值
      data:{“属性”:”属性值”,”属性n”:”属性值n”}，
      //请求方式
      type:”Get”
      //请求前的处理
      beforeSend:function(){
      },
      //请求成功时处理
      sunccess:function(reg){
      }，
      //请求完成的处理
      complete:function(){
      }，
      //请求出错处理
      error:function(){
      }
  })
  ```

## JSON

> JSON(JavaScript Object Notation，JS 对象简谱) 是一种轻量级的数据交换格式，
>
> JSON就是一个js中的对象

* json的定义格式

  `var json = {key:value,key:value,...};`

  key的类型是：字符串，

  value类型：number，boolean，object，function...

* json的数据的获取

  ```json
  json对象名.键名
  json对象名[键名的字符串]
  ```

* json的遍历

  ```json
  for(var i in data) {
                         //i --> 索引
                         //data[i] --> json对象
                         //data[i].属性
                         var str = "";
                         str += '<div>' + data[i].up_time + '<br/>' + data[i].content + '</br></div>';
                         content.prepend(str);
                     }
  ```

* json格式的字符串和对象的相互转换

  json的转换器：*jackson，fastjson...

  * json格式字符串 - > 对象

    ```java
    String json = "{\"name\":\"tom\", \"age\":18}";
    
    ObjectMapper om = new ObjectMapper();
    类名 类对象名 = om.readValue(json, 用户名.class);
    String json = om.writeValueAsString(user);
    ```

  * 对象 - > json格式的字符串

    ```java
    User user = new User("tom", 18);
    
    ObjectMapper om = new ObjectMapper();
    
    String json = om.writeValueAsString(user);
    ```



* Ajax的json

   ```java
   response.setContentType("text/html;charset=utf-8");
   
   ObjectMapper om = new ObjectMapper();
   
   String json = om.writeValueAsString(user);
   response.getWriter().write(json);
   
   om.writeValue(response.getWriter(), list);//上面的两条代码可以简写成
   ```

  




