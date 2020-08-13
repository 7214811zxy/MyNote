`Latency: the time it takes for a message to transfer`

时延: 传播一条信息所需要的时间

---

`Sneakernet` 球鞋网路 指早期应用在实验室内部的一些网络

---

`LAN: Local Area Networks` 计算机近距离构成的小型网络 即局域网; 其中最著名的就是1970年在Xerox PARC研究成功的`ethernet`

以太网的最简单形式是 以一条以太电线连接数台计算机，信号以电线号在以太网之间传输，但是这些信息是所有以太网上的电脑所共享的。为了让这些电脑知道哪些信息是发给他的，以太网需要每台计算机有唯一的`Media Access Control Address`媒体访问控制地址即`MAC` `MAC`将被放在数据的`prefixes`，计算机只监听与自己的` MAC`一致的信息

`LAN`本质上是属于`CSMA`技术的范畴

什么是`CSMA`? 多台电脑共享一个传输媒介，这种方法叫"Carrier Sense Multiple Accss - CSMA" 例如以太网的"Carrier"是铜线，Wifi的 “ Carrier ” 是传播无线电波的空气。因为很多计算机可以同时侦听载体，所以取名为“CSMA”。其中"Carrier"中传输数据的速度，我们称为带宽 —— `Bandwidth`

`CSMA`有个很大的缺陷。因为所有计算机共享一条网线，那么当计算机数量增多，两个计算机同时想向网络中写入数据的概率就会大大增加，那就会发生`collision`，数据就乱套了。

**解决方案1**：所有计算机一起等待网络空闲，然后再发送数据，先到先得！

**解决方案2**：当计算机发现网络被占用后，会等待若干秒再重新发送。每个计算机的唤醒时间是随机的( 假设两个计算机唤醒时间相同，那他们就永远会是冲突的了 )。类似于这种解决方案有一个专有的名称 `Exponential Backoff —— 指数退避` 以太网和Wifi都有使用这种方法。

**解决方案3**：尽管有上述解决方案，但是想做到一条网线覆盖整个学校还是不可能的。解决`CSMA`的关键在于减少同一载体中设备的数量。我们把载体和其中的设备一起称呼为`Collision Domain —— 冲突域` 

那么我们要做的事情就变成了如何把大的`Collision Domain`变成一个个小的`Collision Domain`。这时候`Switch —— 交换机`就登场了。

![image-20200813225828579](C:\Users\NING MEI\AppData\Roaming\Typora\typora-user-images\image-20200813225828579.png)

交换机会记录一个列表 写着哪个MAC在哪边的网络。同侧计算机之间的数据交互不需要经过交换机。如果两侧的计算机需要交换数据，就必须使用交换机，此时两侧的网络会同时被占用。`Internet`就是基于这个技术的。

在一些大型网络中可能就变成了这样 :crying_cat_face:

![image-20200813230253294](C:\Users\NING MEI\AppData\Roaming\Typora\typora-user-images\image-20200813230253294.png)

一个明显的图结构。那么对于这种图结构，从A点到B点往往有多条路线可以选择。这个问题就引出了一个我们熟悉的东西 `routing —— 路由`



如果要连接两个很远很远的计算机。最简单有效的方法是让中国电信给你搭一条专用的线路。早期的电话就是这么干的！但是这种方式显然很昂贵，当然现在还有人这么干！比如银行和军队。



另一种方法叫做`Message Switching —— 报文交换`他于之前的专线不同，他类似于邮件系统。一个Message要经过多个站点的转发才能到达最终的目的地。路由的好处是，他有多个路径可以跳转，假设某个线路出了问题，他可以切换一条路线。如下所示

![image-20200813231020078](C:\Users\NING MEI\AppData\Roaming\Typora\typora-user-images\image-20200813231020078.png)

消息沿着路由跳转的次数我们称之为`hop count —— 跳数`跳数非常有用，这可以让我们判断路由是否出现了问题。报文模式有一个缺点，就是会堵塞网络。因为一个站点要把整个报文从一站传递到下一战后才能继续传递其他报文。例如有一个超大的包正在一个站点被转发，那后面那些小数据量的包都得等这个大家伙被传输完毕，或者使用其他低效的站点。如何解决这个问题？？

使用`packets —— 数据包`！和报文交换一样，每个packet包含了目标地址，因为路由器知道要把他们发送到哪里。报文的具体格式由`互联网协议定义 —— Internet Protocol`！ 每个计算机都有一个独立的`IP` 比如 `172.217.7.238`。

这还有个问题。当一条信息被拆成多个包之后，这些包可能通过不同的`route`到达目的地，但是这就可能导致，`packet`到达的顺序和`packet`发出时的顺序是不同的，这就导致了消息的乱序问题。而`TCP/IP`就是用来解决这个问题的。

> Chopping up data into small packets, and passing these along flexible routes with spare capacity, is so efficient and fault-tolerant, it's what the whole internet runs on today. This routing approach is called Packet Switching —— 分组交换

分组交换的好处是，他实现了去中心化。如今全球的路由器在一些特等的协议下协同工作，比如`Internet Control Message Protocol(ICMP) —— 因特网控制消息协议`和`Border Gateway Protocol(BGP)——边界网关协议`

