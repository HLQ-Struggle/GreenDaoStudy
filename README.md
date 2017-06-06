>**<font color=#FF0000>LZ-Says：撸文不易，且行且珍惜~**
> 
每日一笑： 
> 
> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;假如生活欺骗了你，找50个程序员问问为什么编程；
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;假如生活让你想死，找50个程序员问问Bug改完了没有；
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;假如你觉得生活拮据，找50个程序员问问工资涨了没有；
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;假如你觉得活着无聊，找50个程序员问问他们一天都干了什么！ 
> 
> CSDN地址：http://blog.csdn.net/u012400885/article/details/72831012

## 前言
端午三天，去天津玩了一圈，出去走走，放松放松，感觉也不错。来点正能量，今天，让我们一块研究研究如何使用GreenDao 3.2.2，从而逐步增强我们的逼格。

来来来，一块浪起来~

Android开发过程中，有时候我们需要使用**SQLite数据库去本地存储一些临时数据**，之前，我们通过**继承SQLiteOpenHelper实现创建数据库，基本表以及迭代开发中数据库 数据 内容 字段 变更时处理**，简单了解可以查看LZ之前总结的一些对SQLite常用知识，地址如下：

> http://blog.csdn.net/u012400885/article/details/69218833

而今天为大家介绍的GreenDao 3.2.2，便是与咱上面说的数据库有关系，接着往下瞧~

## GreenDao初识

有的小伙伴可能就会问了，我用的SQLiteOpenHelper挺方便的，干嘛要用这个呢？他有什么优势或者值得让我去使用的亮点吗？

下面来聊聊有关GreenDao的独特魅力~
### 官方资料地址
首先为大家附上官方地址，方便英文水准好的直接查阅，如下：

>  GreenDao 官网：http://greenrobot.org/greendao/ 
>  
>  GreenDao 特征介绍：http://greenrobot.org/greendao/features/  
>   
>   GreenDao 学习文档：http://greenrobot.org/greendao/documentation/
>   
>   GreenDao 更新日志：http://greenrobot.org/greendao/changelog/ 
>    
>   GreenDao GitHub地址：https://github.com/greenrobot/greenDAO 

接下来为大家介绍有关GreenDao八大特性，相当666哦~

### GreenDao 八大特性
&nbsp;&nbsp;1.&nbsp;&nbsp;对象/关系映射（ORM）[Object/relation mapping]  

> **GreenDAO的本质是为存储在关系数据库SQLite中的数据提供面向对象的界面。**
> 
> <font color=#FF0000>使用过程中，我们只需定义数据模型，而GreenDAO将创建Java数据对象（实体）和DAO（数据访问对象），节省部分代码~

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;接下来给大家附上一张对象关系映射图：

<center>![这里写图片描述](http://img.blog.csdn.net/20170602135844803?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)</center>

&nbsp;&nbsp;2.&nbsp;&nbsp;性能

关于这点，引入官方的一句话：

> GreenDAO does not make any compromises regarding performance. <font color=#FF0000>（GreenDAO对性能不做任何妥协） 666~

 So 在目前所知道的ORM中，GreenDao是最快的，非常适合存储大量数据。<font color=#FF0000>举一个简单的例子，使用了GreenDao，大多数实体可以以每秒几千个实体的速率进行插入，更新和加载。 是不是很6？

鉴于咱都是用事实说话的老百姓，下面将官方测试图例附上供大家观看。

<center>![这里写图片描述](http://img.blog.csdn.net/20170602233639821?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)</center>

肿么样，是不是很666？

三个字概括，<font color=#FF0000>**高性能**~！！！

&nbsp;&nbsp;3.&nbsp;&nbsp;加密支持

GreenDao支持加密数据库来保护敏感数据，当然你也可以和SQLCipher一块配合使用。[点我查看API文档](http://greenrobot.org/greendao/documentation/database-encryption/)

&nbsp;&nbsp;4.&nbsp;&nbsp;微小的依赖库

GreenDao关键依赖库大小不超过100kb，So，也不会出现因为引入GreenDao而出现65k问题~<font color=#FF0000>（当然，如果你的app快到临界线了，这个LZ可就不敢保证了哦~</font>）

&nbsp;&nbsp;5.&nbsp;&nbsp;活动实体

如果需要，实体可以被“激活”。而活动实体可以透明地解析关系(我们要做的只是调用getter即可)，并且有更新、删除和刷新方法，以便方便地访问持久性功能

&nbsp;&nbsp;6.&nbsp;&nbsp;协议缓冲区支持

GreenDAO允许您将协议缓冲区（protobuf）对象直接保存到数据库中。如果您通过protobuf通话到您的服务器，则不需要另一个映射。常规实体的所有持久性操作都可用于protobuf对象。So，相信这是GreenDAO的独特之处。<font color=#FF0000>虽然LZ也不是很懂，相信玩转之后，也会有自己的理解~

&nbsp;&nbsp;7.&nbsp;&nbsp;自动生成代码

使用GreenDao，我们无需关注实体类以及Dao，体贴的GreenDao已为我们自动生成了~是不是很赞~！！！

&nbsp;&nbsp;8.&nbsp;&nbsp;开源

开源，有兴趣的同学可以查看源码，深入了解机制，流程，当然，LZ目前只是停留在会用的层面即可。

同样在GitHub，到现在还在维护，貌似最近的一次是俩个月前了吧，关注人还不少，版本也越来越完善，感谢那些背后默默付出的人~

> PS：个人觉得开源有利有弊，就比如Android，开源使得Android越来越向成熟，完善之路走去，但是所带来的弊端同样不容忽视，各种厂商对应的各种定制化Android，让身为Android开发的不得不羡慕ios开发，哈哈，纯属LZ个人理解~

了解了以上内容，我们总结下使用GreenDao的优势，如下。

### GreenDao 优势

> 1. 目前来说性能最高，内存消耗最小，支持数据库加密；
> 2. 依赖库小于100kb，且使用人数众多，维护者也一直在更新；
> 3. 完善的api，并且对Android进行了高度优化，个人觉得很不错~

### GreenDao 对外提供核心类简介
下面为大家附上一张图，大家可以仔细查看后，在仔细往下看，有助于理解~

<center>![这里写图片描述](http://img.blog.csdn.net/20170606005640079?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

1.DaoMaster：
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用GreenDao的切入点（开始）。
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DaoMaster保存数据库对象（SQLiteDatabase）并管理特定模式的Dao类（而不是对象）。它具有静态方法来创建表或将它们删除。其内部类OpenHelper和DevOpenHelper是在SQLite数据库中创建模式的SQLiteOpenHelper实现。

2.DaoSession：
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理特定模式的所有可用Dao对象，您可以使用其中一个getter方法获取。DaoSession还为实体提供了一些通用的持久性方法，如插入，加载，更新，刷新和删除。最后，DaoSession对象也跟踪一个身份范围。有关更多详细信息，[请点击查看会话文档](http://greenrobot.org/greendao/documentation/sessions/)。

3.Dao层：

>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数据访问对象（Dao）持续存在并查询实体。对于每个实体，GreenDao生成一个Dao，它比DaoSession有更多的持久化方法，例如：count，loadAll和insertInTx。

4.实体：
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;持久对象 通常实体是使用标准Java属性（如POJO或JavaBean）来表示数据库行的对象

铺垫到这里，感觉也差不多了，开搞吧~

## Hey , GreenDao  , Let's continue our study~!!!
### 1. 配置Gradle 
1.配置<font color=#FF0000>**工程目录下build.gradle**

添加GreenDao插件支持，**要添加的内容后面都已经加上了简单注释**

```
buildscript {
    repositories {
        jcenter()
        mavenCentral() // 添加远程仓库地址
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.2'
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // 添加插件 更好支持GreenDao
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```
之后点击右上角Sync Now ，AS会自动下载插件，等待就好~！如下图所示：

![这里写图片描述](http://img.blog.csdn.net/20170603110226803?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

2.配置<font color=#FF0000>**项目下的build.gradle**

-  添加应用插件依赖；
> apply plugin: 'org.greenrobot.greendao' // 添加应用依赖插件

-  添加库文件
> compile 'org.greenrobot:greendao:3.2.2' // 添加库

-  初始化GreenDao配置
> 按照官方的说法，我们无需任何其他配置，但是，数据库版本这个你得考虑下吧，当然，如果也不想考虑，那就使用默认的（默认版本为1）。
>  
>  // 配置GreenDao基本参数
greendao {
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;schemaVersion 1 //当前数据库版本
}

下面具体为大家介绍下配置中可用参数作用<font color=#FF0000>（PS：大家可选择性添加）：
> **1. schemaVersion：**当前版本的数据库模式。这被OpenHelpers类用于在模式版本之间迁移。如果更改了实体/数据库模式，则必须增加该值。默认为1。  
>   
> **2. daoPackage：**生成的Dao，DaoMaster和DaoSession的包名称。 默认为源实体的包名称。
>  
> **3. targetGenDir：**生成源应存储在的位置。 默认为构建目录（ build / generated / source / greendao）中生成的源文件夹。
>   
> **4. generateTests：**  设置为true以自动生成单元测试。
> 
> **5. targetGenDirTests：**  应存储生成的单元测试的基本目录。默认为 src / androidTest / java。

这一步配置完结果如下，省略部分内容：

```
apply plugin: 'com.android.application'
apply plugin: 'org.greenrobot.greendao' // 添加应用依赖插件

android {
    // 省略部分内容...
}

// 配置GreenDao基本参数
greendao {
    schemaVersion 1 //当前数据库版本
}

dependencies {
    // 省略部分内容...
    compile 'org.greenrobot:greendao:3.2.2' // 添加库
}

```

到这里，GreenDao基本配置也就告一段落了`

而使用GreenDao前期准备工作也告一段落了，那么接下来让我们实际去感受下GreenDao的魅力吧~

### 2. 了解如何编写GreenDao所需要的实体类

在前面一部分我们曾经说过，我们只需要去关注实体类即可，那么这个实体类和普通实体类又有什么区别？我们该怎么去实现我们的实体类呢？别急，继续往下瞅~

我们先看一下官方为我们提供的小例子，通过讲解这个小例子，让我们充分了解关于使用GreenDao一些方式方法，从而更好的去get这一技能~

```
@Entity
public class User {
    @Id
    private Long id;
 
    private String name;
 
    @Transient
    private int tempUsageCount; // not persisted
 
   // getters and setters for id and user ...
}
```

首先定义了一个User对象，这个对象包含三个属性，分别为id，name以及tempUsageCount。乍眼一看，没啥区别嘛，可大家注意到了**@Entity**，**@Id**以及**@Transient**这俩个东西了吗？这是啥？我们一块具体瞅瞅

-   <font color=#FF0000>**@Entity注解**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@Entity注解标记了一个Java类作为greenDAO一个presistable实体。简单理解为，他告诉GreenDao，要根据这个实体类去生成相应的Dao，方便我们去操作，同样也相当于将我们的实体类和表做了关联，当然这些东西是人GreenDao去搞定的，了解了解总是有好处的嘛`

同样我们也可以使用@Entity配置一些详细信息，如下：

```
@Entity(
        // 如果你有一个以上的模式，你可以告诉greendao实体属于哪个模式（选择任何字符串作为名称）。
        schema = "myschema",
        
        // 标志允许实体类可有更新，删除，刷新方法
        active = true,
        
        // 指定数据库中表的名称。默认情况下，该名称基于实体类名。
        nameInDb = "AWESOME_USERS",
        
        // 在这里定义多个列的索引
        indexes = {
                @Index(value = "name DESC", unique = true)
        },
        
        // 如果DAO创建数据库表(默认为true)，则设置标记去标识。如果有多个实体映射到一个表，或者在greenDAO之外创建表创建，将此设置为false。
        createInDb = false,
 
        // 是否应该生成所有的属性构造函数。一个无args构造函数总是需要的
        generateConstructors = true,
 
        // 是否生成属性的getter和setter
        generateGettersSetters = true
)
```

-  <font color=#FF0000>**@Id注解**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择long / Long属性作为实体ID。在数据库方面，它是主要的关键参数autoincrement  是使ID值不断增加的标志（不重复使用旧值），也就是咱常说的**自增长**。

-  <font color=#FF0000>**@Property**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;允许您定义属性映射到的非默认列名称。如果缺少，greenDAO将以SQL-ish方式使用字段名称（大写字母，下划线而不是驼峰命名法，例如 customName将成为 CUSTOM_NAME）。注意：当前只能使用内联常量来指定列名。

-   <font color=#FF0000>**@NotNull**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该属性在数据库端成为“NOT NULL”列。通常使用@NotNull标记原始类型（long，int，short，byte）是有意义的，而具有包装类（Long，Integer，Short，Byte））的可空值。

-  <font color=#FF0000>**@Transient**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标记要从持久性排除的属性，使用这些临时状态等。或者，也可以使用来自Java 的transient关键字。

下面为大家拓展俩个注解，有用到的可以参考下：

-  <font color=#FF0000>**@Index**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为相应的数据库列创建数据库索引
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称：如果不喜欢greenDAO为索引生成的默认名称，则可以在此处指定。
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;唯一：向索引添加UNIQUE约束，强制所有值都是唯一的。

下面有个小例子，供大家查阅(官网直接拷贝，哈哈~)：
```
@Entity
public class User {
    @Id private Long id;
    @Index(unique = true)
    private String name;
}
```

-  <font color=#FF0000>**@Unique**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;向数据库列添加了一个UNIQUE约束。请注意，SQLite还会隐式地为其创建索引。例子如下：

```
@Entity
public class User {
    @Id private Long id;
    @Unique private String name;
}
```

> 大概的翻译了官方的内容，LZ英文不是很好，虽然靠着翻译后的网页进行阅读，可有些翻译的还不太通顺，所以部分按照自己的理解写了，大家谅解~

嗯，到现在，了解了一部分内容，我们开始编码Go Go Go ~！！！

## Coding~大刀阔斧的干吧~

Hello，我们的第一个实体类~

我们先设定一个简单场景，方便我们下面代码演示，如下：

> 定义一个Student类，其中分别有如下几个属性：
> 
> 1.  学员id；
> 2.  学员编号；
> 3.  学员姓名；
> 4.  学员性别；
> 5.  学员成绩。
>  
>接下来我们将要根据以上属性进行GreenDao学习~


### Hi ，GreenDao 实体类实现

```
package cn.hlq.greendaostudy.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

/**
 * Created by HLQ on 2017/6/5
 */
@Entity
public class Student {

    @Id(autoincrement = true) // id自增长
    private Long stuId; // 学院id

    @Index(unique = true) // 唯一性
    private String stuNo; // 学员编号

    private String stuName; // 学员姓名

    private String stuSex; // 学员性别

    private String stuScore; // 学员成绩

}

```

编译项目，生成Dao相关文件~

<center>![这里写图片描述](http://img.blog.csdn.net/20170605020219381?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast) 

编辑之后，我们会发现我们的实体类多了一些东西，这里贴出来大家看下：

```
package cn.hlq.greendaostudy.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by HLQ on 2017/6/5
 */
@Entity
public class Student {

    @Id(autoincrement = true) // id自增长
    private Long stuId; // 学院id

    @Index(unique = true) // 唯一性
    private String stuNo; // 学员编号

    private String stuName; // 学员姓名

    private String stuSex; // 学员性别

    private String stuScore; // 学员成绩

    @Generated(hash = 315497705)
    public Student(Long stuId, String stuNo, String stuName, String stuSex,
            String stuScore) {
        this.stuId = stuId;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuScore = stuScore;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getStuId() {
        return this.stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return this.stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return this.stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return this.stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuScore() {
        return this.stuScore;
    }

    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }

}

```

> **这里再次阐述下，如下：**
> 
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=#FF0000>1. 编译后自动生成无参，有参构造；
> 
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=#FF0000>2. 编译后自动生成getter，setter；

因为咱之前没有指定生成Dao内容存储的位置，但是GreenDao有默认地址哦~所以，我们去默认地址查看即可~

<center>![这里写图片描述](http://img.blog.csdn.net/20170605020419414?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### GreenDao中逻辑运算符

<center>![这里写图片描述](http://img.blog.csdn.net/20170606000931307?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvdTAxMjQwMDg4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这里从源码中找了一段，很清楚，大家简单看一下即可~

### 撸码实现~

#### 获取StudentDao 

也就是初始化Dao，如下：

```
    /**
     * 获取StudentDao
     */
    private void getStuDao() {
        // 创建数据
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(self, "hlq.db", null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        stuDao = daoSession.getStudentDao();
    }
```

#### 新增一条数据

```
        // 新增一条数据
        findViewById(R.id.id_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student stu = new Student(null, "001", "贺da宝", "男孩", "50");
                long end = stuDao.insert(stu);
                String msg = "";
                if (end > 0) {
                    msg = "001新增成功~";
                } else {
                    msg = "新增失败~";
                }
                stuDao.insert(new Student(null, "002", "贺er宝", "男人", "66"));
                stuDao.insert(new Student(null, "003", "贺san宝", "爷儿们", "23"));
                stuDao.insert(new Student(null, "004", "贺si宝", "男人", "65"));
                Toast.makeText(self, "001 002 003 004新增成功~", Toast.LENGTH_SHORT).show();
            }
        });
```
#### 新增List集合数据

```
        // 新增List集合数据
        findViewById(R.id.id_insert_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = new ArrayList<Student>();
                stuList.add(new Student(null, "005", "贺利权", "小爷儿们", "43"));
                stuList.add(new Student(null, "006", "贺利权", "大爷儿们", "35"));
                stuList.add(new Student(null, "007", "贺利权", "老爷儿们", "99"));
                stuList.add(new Student(null, "008", "贺利权", "老少爷儿们", "88"));
                stuDao.insertInTx(stuList);
                Toast.makeText(self, "新增成功~", Toast.LENGTH_SHORT).show();
            }
        });
```
#### 查询所有

```
        findViewById(R.id.id_search_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = stuDao.queryBuilder().list();
                if (stuList != null) {
                    String searchAllInfo = "";
                    for (int i = 0; i < stuList.size(); i++) {
                        Student stu = stuList.get(i);
                        searchAllInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                    }
                    TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_all_info);
                    tvSearchInfo.setText(searchAllInfo);
                }
            }
        });
```

#### 查询指定数据 查询姓名为"贺da宝"的信息

```
        // 查询指定数据 查询姓名为"贺da宝"的信息
        findViewById(R.id.id_search_assign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignInfo = "";
                List<Student> stuList = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺da宝")).list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                }
                TextView tvSearchAssign = (TextView) findViewById(R.id.id_search_assign_info);
                tvSearchAssign.setText(searchAssignInfo);
            }
        });
```
#### 查询指定数据 查询姓名为"贺da宝"的信息并按照成绩排序-降序

```
        // 查询指定数据 查询姓名为"贺da宝"的信息并按照成绩排序-降序
        findViewById(R.id.id_search_assign_order_desc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignOrderDesc = "";
                List<Student> stuList = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺利权")).orderDesc(StudentDao.Properties.StuScore).list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignOrderDesc += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore();
                }
                TextView tvSearchOrderDesc = (TextView) findViewById(R.id.id_search_assign_order_desc_info);
                tvSearchOrderDesc.setText(searchAssignOrderDesc);
            }
        });
```
#### 查询指定数据 查询姓名为"贺da宝"的信息并按照成绩排序-升序

```
        // 查询指定数据 查询姓名为"贺da宝"的信息并按照成绩排序-升序
        findViewById(R.id.id_search_assign_order_asc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignOrderDesc = "";
                List<Student> stuList = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺利权")).orderAsc(StudentDao.Properties.StuScore).list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignOrderDesc += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore();
                }
                TextView tvSearchOrderDesc = (TextView) findViewById(R.id.id_search_assign_order_asc_info);
                tvSearchOrderDesc.setText(searchAssignOrderDesc);
            }
        });
```

#### 组合查询数据 查询姓名为"贺利权" 并且成绩小于等于60

```
        // 组合查询数据 查询姓名为"贺利权" 并且成绩小于等于60
        findViewById(R.id.id_search_combination).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchAssignOrderDesc = "";
                QueryBuilder<Student> stuQB = stuDao.queryBuilder();
                stuQB.where(StudentDao.Properties.StuName.eq("贺利权"), StudentDao.Properties.StuScore.le("60"));
                List<Student> stuList = stuQB.list();
                for (int i = 0; i < stuList.size(); i++) {
                    Student stu = stuList.get(i);
                    searchAssignOrderDesc += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                }
                TextView tvSearchOrderDesc = (TextView) findViewById(R.id.id_search_combination_info);
                tvSearchOrderDesc.setText(searchAssignOrderDesc);
            }
        });
```

#### 查询所有返回数据 但只返回前三条数据

```
        // 查询所有返回数据 但只返回前三条数据
        findViewById(R.id.id_search_limit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = stuDao.queryBuilder().limit(3).list();
                if (stuList != null) {
                    String searchAllInfo = "";
                    for (int i = 0; i < stuList.size(); i++) {
                        Student stu = stuList.get(i);
                        searchAllInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                    }
                    TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_limit_info);
                    tvSearchInfo.setText(searchAllInfo);
                }
            }
        });
```
#### 查询所有返回数据 但只返回前三条数据 并且跳过第一条数据

```
        // 查询所有返回数据 但只返回前三条数据 并且跳过第一条数据
        findViewById(R.id.id_search_limit_offset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuList = stuDao.queryBuilder().limit(3).offset(1).list();
                if (stuList != null) {
                    String searchAllInfo = "";
                    for (int i = 0; i < stuList.size(); i++) {
                        Student stu = stuList.get(i);
                        searchAllInfo += "id：" + stu.getStuId() + "编号：" + stu.getStuNo() + "姓名：" + stu.getStuName() + "性别：" + stu.getStuSex() + "成绩：" + stu.getStuScore() + "\n";
                    }
                    TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_limit_offset_info);
                    tvSearchInfo.setText(searchAllInfo);
                }
            }
        });
```
#### 查询所有信息总条数

```
        // 查询所有信息总条数
        findViewById(R.id.id_search_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stuSumCount = stuDao.queryBuilder().list().size();
                TextView tvSearchInfo = (TextView) findViewById(R.id.id_search_count_info);
                tvSearchInfo.setText(stuSumCount);
            }
        });
```

#### 删除指定信息

```
        // 删除指定信息
        findViewById(R.id.id_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺si宝")).buildDelete().executeDeleteWithoutDetachingEntities();
                Toast.makeText(self, "删除成功~", Toast.LENGTH_SHORT).show();
//                stuDao.delete(new Student()); // 删除指定对象
//                stuDao.deleteAll(); // 删除所有
            }
        });
```
#### 更新指定信息

```
        // 更新指定信息
        findViewById(R.id.id_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = stuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("贺da宝")).build().unique();
                if (student != null) {
                    student.setStuName("I Love You");
                    stuDao.update(student);
                }
                Toast.makeText(self, "更新成功~", Toast.LENGTH_SHORT).show();
            }
        });
```

## 结束语以及源码查看地址

### GitHub地址

> https://github.com/HLQ-Struggle/GreenDaoStudy 

作为初学者，希望这边文章对大家有所帮助，欢迎大家指正~

Thanks~
