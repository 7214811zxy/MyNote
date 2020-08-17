# Computer Networks 1

---

`LAN: Local Area Networks` 计算机近距离构成的小型网络 即局域网; 其中最著名的就是1970年在Xerox PARC研究成功的`ethernet`

以太网的最简单形式是 以一条以太电线( 没错，就是一条电线而已 ) 连接数台计算机。信息以电线号在以太网之间传输，但是这些信息是所有以太网上的电脑所共享的，如下图所示，蓝色电线上的数据被A，B，C，D，E，F这6台电脑共享。那么此时，如果A只想向F发消息，B, C, D, E他们不想接受，要怎么做到呢？为了让这些电脑知道哪些信息是发给他的，以太网需要每台计算机有唯一的`Media Access Control Address`媒体访问控制地址即`MAC` `MAC`将被放在数据的`prefixes`，以太网上的计算机只监听与自己的` MAC`一致的信息。

![image-20200814185905787](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814185905787.png)

此处再引出一个概念，`CSMA`。`LAN`本质上是属于`CSMA`技术的范畴。以下是`CSMA`的定义

![image-20200814190426124](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814190426124.png)

什么是`CSMA`? 多台电脑共享一个传输媒介，这种方法叫"Carrier Sense Multiple Accss - CSMA" 例如以太网的"Carrier"是铜线，Wifi的 “ Carrier ” 是传播无线电波的空气。因为很多计算机可以同时侦听载体，所以取名为“CSMA”。其中"Carrier"中传输数据的速度，我们称为带宽 —— `Bandwidth`

`CSMA`有个很大的缺陷。因为所有计算机共享一条网线，那么当计算机数量增多，两个计算机同时想向网络中写入数据的概率就会大大增加，那就会发生`collision`，数据就乱套了。大概就像下面这样，A和F同时分别想向C和D发送消息，那消息就撞车了！

![image-20200814190603752](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814190603752.png)

此后的20年，大部分的研究都是在解决网络的`Collision`问题

**解决方案1**：所有计算机一起等待网络空闲，然后再发送数据，先到先得！

**解决方案2**：当计算机发现网络被占用后，会等待若干秒再重新发送。每个计算机的唤醒时间是随机的( 假设两个计算机唤醒时间相同，那他们就永远会是冲突的了 )。类似于这种解决方案有一个专有的名称 `Exponential Backoff —— 指数退避` 现在以太网和Wifi的处理方案，大部分都是基于这个方法的。

**解决方案3**：尽管有上述解决方案，但是想做到一条网线覆盖整个学校还是不可能的。解决`CSMA`的关键在于减少同一载体中设备的数量。我们把载体和其中的设备一起称呼为`Collision Domain —— 冲突域` 

那么我们要做的事情就变成了如何把大的`Collision Domain`变成一个个小的`Collision Domain`。这时候`Switch —— 交换机`就登场了。

![image-20200814191405326](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814191405326.png)

交换机会记录一个列表 写着哪个MAC在哪边的网络。同侧计算机之间的数据交互不需要经过交换机。如果两侧的计算机需要交换数据，就必须使用交换机，此时两侧的网络会同时被占用。`Internet`就是基于这个技术的。

在一些大型网络中可能就变成了这样 :crying_cat_face:

![image-20200814191451574](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814191451574.png)

一个明显的图结构。那么对于这种图结构，从A点到B点往往有多条路线可以选择。这个问题就引出了一个我们熟悉的东西 `routing —— 路由` 为什么要叫路由？？从一个简单的事情说起。

如果要连接两个很远很远的计算机。最简单有效的方法是让中国电信给你搭一条专用的线路。早期的电话就是这么干的！但是这种方式显然很昂贵，当然现在还有人这么干！比如银行和军队。

![image-20200814191622548](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814191622548.png)

另一种方法叫做`Message Switching —— 报文交换`他于之前的专线不同，他类似于邮件系统。一个Message要经过多个站点的转发才能到达最终的目的地，虽然比专线效率低，但是路由有他自己的有点。路由往往有多个路径可以跳转，假设某个线路出了问题，他可以切换一条路线。如下所示

![image-20200814191706805](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814191706805.png)

![image-20200813231020078](C:\Users\NING MEI\AppData\Roaming\Typora\typora-user-images\image-20200813231020078.png)

消息沿着路由跳转的次数我们称之为`hop count —— 跳数`跳数非常有用，这可以让我们判断路由是否出现了问题。报文模式有一个缺点，就是会堵塞网络。因为一个站点要把整个报文从一站传递到下一战后才能继续传递其他报文。例如有一个超大的包正在一个站点被转发，那后面那些小数据量的包都得等这个大家伙被传输完毕，或者使用其他低效的站点。如何解决这个问题？？

使用`packets —— 数据包`！和报文交换一样，每个`packet`包含了目标地址，因为路由器知道要把他们发送到哪里。报文的具体格式由`互联网协议定义 —— Internet Protocol`！ 每个计算机都有一个独立的`IP` 比如 `172.217.7.238`。

这还有个问题。当一条信息被拆成多个包之后，这些包可能通过不同的`route`到达目的地，但是这就可能导致，`packet`到达的顺序和`packet`发出时的顺序是不同的，这就导致了消息的乱序问题。如下图所示，假设消息要从右边的绿点传送到左边的绿点。消息被拆分成1 2 3 4四个包。他们各自的传输路线受由发送时的网络环境决定，所以1 2 3 4四个包很可能通过不同的路径传输，导致他们到达的顺序也是不同的。而`TCP/IP`就是用来解决这个问题的。

![image-20200814192309672](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814192309672.png)

> Chopping up data into small packets, and passing these along flexible routes with spare capacity, is so efficient and fault-tolerant, it's what the whole internet runs on today. This routing approach is called Packet Switching —— 分组交换

上述这种将一条消息拆分再发送的方法叫做`Packet Switching —— 分组交换`。它的的好处是，实现了去中心化。如今全球的路由器在一些特等的协议下协同工作，比如`Internet Control Message Protocol(ICMP) —— 因特网控制消息协议`和`Border Gateway Protocol(BGP)——边界网关协议`



油管链接

https://www.youtube.com/watch?v=3QhU9jd03a0&list=PL8dPuuaLjXtNlUrzyH5r6jN9ulIgZBpdo&t=28s

# Computer Networks 2

接上一个post所述。现在的计算机首先连接到本地的局域网，即LAN。也就是你家的路由器！LAN再连接到一个小广域网WAN (Wide Area Network)，比如一个小区，然后再连到一个大的广域网，比如杭州，再连到一个更大的广域网，比如中国，然后再连....连不出去了，有墙 :neutral_face: ....互联网上的信息就是像跳棋一样的传播。

如果你想看你的跳数 你可以使用`traceroute`来查看



上节说过，信息要在互联网中传播，要遵循一个协议 —— `IP`。为什么要遵守协议？你在淘宝上买东西收件地址能瞎填吗？ :upside_down_face:但是`IP`是个很底层的协议，他的格式大概长这样。包含一个`HEADER`和`DATA PAYLOAD`。`HEADER`存放的是`metadata`，他就是一个地址，就是说这条消息要送到哪台计算机！( *there isn't much more than a destination address in a packet's header* )。`Data Payload`就是实际的数据。

![image-20200814195912962](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814195912962.png)

那么问题来了！你的电脑要怎么知道这个数据是给腾讯QQ的还是魔兽世界的呢？解决方案很简单，规则不够，就再加一个规则。这就引出了`User Datagram Protocol —— UDP`

![image-20200814200520115](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814200520115.png)

UDP在`IP Header`和`Data`之间又插了一腿。里面包含了一些额外的信息。其中一个就是大名顶顶的端口号`port number`当一个数据包到达时，接受的操作系统首先会读取端口号，然后再把他们丢给相应的软件。总结一下

*IP负责把数据包送到正确的计算机； UDP负责把数据包送到正确的计算机*

![image-20200814193748997](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814193748997.png)

UDP里还有一个东西叫做`checksum`用于检查数据是否正确。但这个东西是一种间接的测量手段。举例来说，要发送89, 111, 33, 32, 58, 41这一组数据。那在发送时计算机会对数据求个sum，把这个sum写到`UDP Header`里。然后收到信息的计算机，会对接受到的信息也求个sum，如果两个sum是一样的。那应该...数据就没啥问题 (这显然不是特别靠谱 :slightly_frowning_face: ，但好像比较省事~ 我总不能把所有的数据都重新在`UDP Header`里再写一边吧）

那如果数据太大，那求和不是得求很久~没错！Good Boy！所以我们的`UDP`最多求和求到16位的二进制

![image-20200814201118677](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814201118677.png)

如果数据丢了或者错了怎么办？`UDP`没辙~ 不仅如此，你甚至没法知道你发出去的信息对方收到没有，因为这玩意儿没有反馈~ 所以就会出现 `网卡了`这种现象。既然这玩意儿这么蠢，那为啥还要用呢？因为，快！！尤其像第一人称射击游戏这样的东西。

![image-20200814202020104](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814202020104.png)

如果你想要保证所有数据都能到达，那你可以选择`Transmission Control Protocol —— TCP`

![image-20200814202542927](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814202542927.png)

这玩意儿就高级的多了。他和`UDP`一样，也有端口号和校验和，但除此之外还有一些更牛逼的东西来控制数据的准确送达。此处介绍几个主要的

1.  TCP数据包有序号。这样所有的包就可以在就受访重组，就解决了包乱序的问题。

2.  TCP要求接收方的电脑收到数据包并且`checksum`无误后给发送方发送一个`acknowledgement —— 确认码ACK`发送方收到ACK后才会发送下一个包。如果一直没收到确认码，那一定有些奇怪的事情发送了。那么就会把这个包再发一遍。那么如果包收到了，但是确认码在发送的过程中莫名其妙的消失了，那不是重复了吗？不会~因为包有序号，如果接收方收到两个一样序号的包，那丢掉就行了...那这样一个一个的发包不是很慢吗？不！没错！`TCP`可以一次发多个包，大概就这样

   ![image-20200814203315729](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814203315729.png)

   那为什么一定要有个ACK呢？问的好！有了这个东西，TCP可以靠这个来判断当前的网络拥堵情况，以此来调整发包的数量（传说中的网速波动？？？）

   总结一下：TCP可以处理乱序和丢失数据包，丢了就重发。还可以根据拥挤情况自动调整传输速率。

   那么既然TCP这么牛逼！那还用个毛的UDP！有！因为TCP把一个相同的数据相当于翻了一倍
   
   

最后是关于层的！

物理层 Physical Layer : 我们谈了传递信息的电信号和无线网络里的无线信号。这叫做 `Physical Layer —— 物理层`

数据层 Data Link Layer: 媒体访问控制地址，碰撞检测，指数退避和其他一些底层协议

网络层  Network Layer: 负责各种报文交换和路由

传输层 Transport Layer: 就是这次的UDP和TCP的一些东西。负责计算机之间进行一些点到点的传输，还会检测和修复一些错苏

会话层 Session Layer: 使用TCP和UDP来创建连接，传递信息，然后关闭连接

上述这一整套流程叫做 会话`session`

![image-20200814211123496](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200814211123496.png)

这是Open System Interconnection (OSI) model的底下5层，再往上是表示层和应用程序层，就是浏览器，Skype和HTML存在地方。下次再讲，翻译不动了.... :dizzy_face:

# Computer Networks 3

这个post我们来聊聊 World Wide Web —— 万维网。首先这个东西不等于互联网！不等于互联网！不等于互联网！重要的事情说3遍！它位于互联网的上一层。他们的关系是这样的：

> The Internet is the underlying plumbing that conveys the data for all these different applications. And the World Wide Web is the biggest of them all. We use web browser access World Wide Web. 

万维网的最基本单位，是单个页面。没错！就是你印象里的那些页面，这些页面有一些超链接，指向其他页面。在互联网中使用IP来确定电脑的位置；在万维网中使用URL来确定位置。

超链接还有个称呼，也许你听说过，`Hypertext —— 超文本`。为了使网页能相互连接，每个网页需要一个唯一的地址，这就引出了`Uniform Resource Locator —— 统一资源定位器 URL`



这里我们来简单聊一聊一个完成的网络请求的流程

首先你输入一个网址比如是www.thecrashcourse.com，这个网址会通过Internet传递给DNS服务器，进行域名的解析

![image-20200815093836470](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200815093836470.png)

然后dns从服务器中查找出域名所对应的ip后，返回给你的计算机

![image-20200815093942790](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200815093942790.png)

浏览器拿到这个IP后会打开一个TCP请求连接到这个IP，也就是传说中的Web Server

![image-20200815094041918](C:\Users\Jupyter\AppData\Roaming\Typora\typora-user-images\image-20200815094041918.png)

那么现在你已经连接到了www.thecrashcourse.com这个webServer上了，那么你要怎么告诉web Server你要干嘛呢？这里就要引出我们的`Http`了，即`Hypertext Transfer Protocol —— 超文本传输协议` 我们上面在讲超链接的时候说过它的还有个名字就是超文本，希望你没有忘  :crying_cat_face:

Http最开始的时候，只有一个指令，就是 Get！比如我们连接了webserver后，我们想要获取courese界面，我们可以发送`GET /courses`这个指令以ASCII编码发送到服务器(什么是ASCII编码？？右转Google)。服务器返回一个地址，浏览器渲染页面。之后Http还添加了状态吗，它放在请求前面，例如200就表示页面找到了！400~499表示客户端出错。常见的404表示页面找不到



下面我们来聊一聊超文本的传输。超文本，本质上还是一种文本，在传输的时候就是一种字符串，那我们要怎么区分哪些是超文本，哪些是普通文本呢？这就出现了下一位兄弟 `Hypertext Markup Language —— 超文本标记语言 HTML`

至于怎么写`HTML`,想学吗？我教你啊 :full_moon_with_face: 现在的`html5`就是`html`的最新版，它有100多种标签，而最开始的时候，`html`只有18种标签。当然现在还加入了Javascript和css，这个就不谈了。有兴趣的可以去学习 前端从入门到外卖



下面来聊聊浏览器

浏览器主要的工作是和网页服务器沟通，并负责显示一些东西。第一个浏览器和网页服务器是Tim Berners-Lee在1990年花了2个月时间完成的。为了做这个玩意儿，它还同时定了几个标准 URL HTML和HTTP :dizzy_face: 巨佬！然后他和同事使用了一段时间后，就把这个玩意儿在1991年发布了出去，没错！万维网就此诞生了。



因为Lee定义的万维网开放协议，浏览器犹如雨后春笋般的出现了。那么这就又带来一个问题，我要怎么在万维网上找我想要的信息呢？哈! 问的好~那就出现了搜索引擎，这个故事就比较大了，有机会我们下次再聊 bye bye~



