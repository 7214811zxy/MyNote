# Microservices — a definition of this new architectural term

> 本文于2014 年由Martin Fowler发表，给出了一种全新架构的定义 —— 微服务架构。本文是微服务架构奠基性的论文。Martin Fowler是ThoughtWorks的首席科学家，是当今世界软件开发领域最具影响力的五位大师。是第一个提出“依赖注入模式”的人。

## Abstract

> The term “Microservice Architecture” has sprung up over the last few years to describe a particular way of designing software applications as suites of independently deployable services. While there is no precise definition of this architectural style, there are certain common characteristics around organization around business capability, automated deployment, intelligence in the endpoints, and decentralized control of languages and data.

 “Microservice Architecture” 即微服务架构这个术语之前常用来描述基于如下设计模式开发的应用程序和软件，这些应用程序和软件由一系列服务组成，这些服务可以独立部署和开发。虽然目前业界还没有对于微服务架构提出一个精确定义，但是围绕业务能力(business capability)、自动化部署(automated deployment)、结点智能(intelligence in the endpoints)、语言和数据的去中心化(decentralized control of languages and data)，本文概括出了微服务架构所应该具有的共同特征

## Introduction

> "Microservices" - yet another new term on the crowded streets of software architecture. Although our natural inclination is to pass such things by with a contemptuous glance, this bit of terminology describes a style of software systems that we are finding more and more appealing. We've seen many projects use this style in the last few years, and results so far have been positive, so much so that for many of our colleagues this is becoming the default style for building enterprise applications. Sadly, however, there's not much information that outlines what the microservice style is and how to do it.

在已经拥挤不堪的软件架构大街上又多了"Microservices"这个新的小老弟。忽略一些不起眼的新东西是人的本能，但是这个新出现的小家伙("Microservices")正在越来越受人们的欢迎。在过去几年，我们已经看到许多项目使用了这种新的架构，而且取得了很好的效果。以至于现在业内很多同行甚至已经把微服务作为默认的企业级应用的架构了。但是令人遗憾的是，目前位置，还没有最够的信息去阐述究竟什么是微服务，以及如何去实现。

### 微服务架构的宏观定义

> In short, the microservice architectural style [[1\]](https://martinfowler.com/articles/microservices.html#footnote-etymology) is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery. There is a bare minimum of centralized management of these services, which may be written in different programming languages and use different data storage technologies.

简而言之，微服务架构是这样一种开发方式：将单个应用程序的开发分解为开发一群小型服务，每个小服务都运行在独立的进程上，他们之间具有轻量级的通信机制，通常通过HTTP resource API来进行通信。这些服务围绕业务功能进行构建，并且可以全自动独立部署。 这些服务之间几乎不存在任何的集中式管理(centralized management)，这些服务理论上可以基于不同的编程语言进行编写，甚至使用不同的数据储存技术。

### 微服务架构与一体化架构的比较

> To start explaining the microservice style it's useful to compare it to the monolithic style: a monolithic application built as a single unit. Enterprise Applications are often built in three main parts: a client-side user interface (consisting of HTML pages and javascript running in a browser on the user's machine) a database (consisting of many tables inserted into a common, and usually relational, database management system), and a server-side application. The server-side application will handle HTTP requests, execute domain logic, retrieve and update data from the database, and select and populate HTML views to be sent to the browser. This server-side application is a *monolith* - a single logical executable[[2\]](https://martinfowler.com/articles/microservices.html#footnote-monolith). Any changes to the system involve building and deploying a new version of the server-side application.

在开始解释微服务之前，我们先来和“Monolithic Style”一体化架构进行一个比较。一个一体化应用通常由一个单元构建而成。企业级应用通常由三个主要的部分组成，客户端用户界面(通常是包含HTML界面、js脚本，运行在浏览器或者用户的手机上)，数据库和一个服务端应用。服务端应用将处理HTTP请求，执行逻辑处理，对数据库增删查改，选择要发送到浏览器的HTML视图等。这里的服务端应用通常就是"monolith(一体化的)" — 即一个单独的可执行逻辑文件。对这个系统的任何改变都涉及到在服务端重新部署和构建应用

> Such a monolithic server is a natural way to approach building such a system. All your logic for handling a request runs in a single process, allowing you to use the basic features of your language to divide up the application into classes, functions, and namespaces. With some care, you can run and test the application on a developer's laptop, and use a deployment pipeline to ensure that changes are properly tested and deployed into production. You can horizontally scale the monolith by running many instances behind a load-balancer.

对于这种一体化系统而言，一体化服务器自然是最好的选择。处理一个请求的所有逻辑都在一个进程中，当然你可以使用编程语言的基本功能将应用程序划分为不同的类、函数和命名空间。开发人员在自己的笔记本上进行测试和开发后，要小心的按照部署管线(deployment  pipeline)实施部署，从而保证应用的改动被成功的部署到生产环境。你还可以在load-balancer后运行多个实例来对这个一体化应用做负载均衡。(我也不知道他说这段话是为了啥 - - ! )

> Monolithic applications can be successful, but increasingly people are feeling frustrations with them - especially as more applications are being deployed to the cloud . Change cycles are tied together - a change made to a small part of the application, requires the entire monolith to be rebuilt and deployed. Over time it's often hard to keep a good modular structure, making it harder to keep changes that ought to only affect one module within that module. Scaling requires scaling of the entire application rather than parts of it that require greater resource.

一体化应用也许是成功的！但是越来越多的人对他感到沮丧，尤其是当越来越多的应用被部署到云端之后。因为对于一体化应用而言，Change和Cycles被绑定在了一起，当一体化应用有一些小改动时，整个一体化应用需要重新构建和部署。随着项目的发展，要一直维护整个项目具有一个良好的模块结构是十分困难的(因为总有些家伙会写些十分奇怪但是却能正常工作的代码.....)，因此很难保留只影响某模块中一个模块的改动（就是很容易写出耦合的一塌糊涂的代码）。可扩展性方面，一体化应用需要对整个应用进行扩展，而不是针对某个需要更大资源的特定部分进行扩展，如图所示。

![img](https://martinfowler.com/articles/microservices/images/sketch.png)

图1. Monoliths and Microservices. 

图注译：一体化架构的应用通常把所有的函数放在一个进程中。通过在多个服务器中复制整个一体化应用来实现扩展。

微服务架构把特定功能的元素放到各个分离的服务中。通过在分布式服务器中按需复制多个需要的服务来实现扩展。

> These frustrations have led to the microservice architectural style: building applications as suites of services. As well as the fact that services are independently deployable and scalable, each service also provides a firm module boundary, even allowing for different services to be written in different programming languages. They can also be managed by different teams .
>
> We do not claim that the microservice style is novel or innovative, its roots go back at least to the design principles of Unix. But we do think that not enough people consider a microservice architecture and that many software developments would be better off if they used it.

一体化应用的这些缺点催生了微服务架构的具有如下风格：基于服务来构建应用。 除了服务可独立部署和可扩展之外，每个服务还提供了牢固的模块边界，甚至允许允许使用不同的编程语言来编写不同的服务。当然他们也可以由不同的团队来管理。

我们并没有说微服务风格是新颖的或创新的，事实上它的起源至少可以追溯到Unix的设计原理。但是我们认为目前还没有足够的人考虑微服务架构，而且如果使用了微服务架构，目前许多的软件开发的会更好，所以我们才撰写了这篇文章。

## **Characteristics of a Microservice Architecture**

> We cannot say there is a formal definition of the microservices architectural style, but we can attempt to describe what we see as common characteristics for architectures that fit the label. As with any definition that outlines common characteristics, not all microservice architectures have all the characteristics, but we do expect that most microservice architectures exhibit most characteristics. While we authors have been active members of this rather loose community, our intention is to attempt a description of what we see in our own work and in similar efforts by teams we know of. In particular we are not laying down some definition to conform to.

首先，我们并没有说这是一个对于微服务架构的正式定义，我们只是在尝试描述适合微服务架构这个名词的架构所应该具有的公共特征。并非所有微服务架构都应该具有这些特征，但是我们希望大多数的微服务架构都能具有下文描述的大多数特征。虽然本人一直是这个养老社区的活跃分子，但我的初衷只是想对在那些工作中所到的问题以及周围团队正努力解决的问题进行阐述。再次强调！我们没有规定任何微服务架构一定要符合的条条框框！！！

### Componentization via Services

#### 什么是components

> For as long as we've been involved in the software industry, there's been a desire to build systems by plugging together components, much in the way we see things are made in the physical world. During the last couple of decades we've seen considerable progress with large compendiums of common libraries that are part of most language platforms.
>
> When talking about components we run into the difficult definition of what makes a component. Our definition is that a **component** is a unit of software that is independently replaceable and upgradeable.

软件行业诞生以来，人们就一直希望通过组件来构建系统，就像现实世界中那样。在过去的几十年里，组件化已经取得了巨大的进步。大多数语言都具有一个大型的公共库（比如python的pip, java的maven, js的npm等）。

当谈到组件时，通常会难以给出一个组件的明确定义。我们的定义是，组件是可以独立替换和升级的一个软件单元。

#### libraries和services的区别

> Microservice architectures will use libraries, but their primary way of componentizing their own software is by breaking down into services. We define **libraries** as components that are linked into a program and called using in-memory function calls, while **services** are out-of-process components who communicate with a mechanism such as a web service request, or remote procedure call. (This is a different concept to that of a service object in many OO programs [[3\]](https://martinfowler.com/articles/microservices.html#footnote-service-object).)

微服务体系结构也会用到各类库，但是它们实现组件化的主要方式是将软件基于服务进行分解。我们将各类库（libraries）也定义程序内组件，这种组件直接与程序内部进行相连，通过内存中的函数去进行调用他们。服务（services）是一种进程外组件，他们通过web请求进行通信，或者通过远程调用来使用他们。(这与许多OO程序[3]中的服务对象是不同的)

#### 为什么基于服务来实现组件化

> One main reason for using services as components (rather than libraries) is that services are independently deployable. If you have an application [[4\]](https://martinfowler.com/articles/microservices.html#footnote-application) that consists of a multiple libraries in a single process, a change to any single component results in having to redeploy the entire application. But if that application is decomposed into multiple services, you can expect many single service changes to only require that service to be redeployed. That's not an absolute, some changes will change service interfaces resulting in some coordination, but the aim of a good microservice architecture is to minimize these through cohesive service boundaries and evolution mechanisms in the service contracts.

使用服务（services）作为组件而不是库（libraries）的主要理由是因为服务可以被独立部署。如果一个应用是由多个库构成的一个单进程，这个应用中任何组件的改变都会导致整个应用的重新部署。但是如果应用被分解为多个服务，那么当某个服务有变化时，只需要重新部署变化的服务即可。这并不是绝对的，有些改动可能改变某些服务的接口，从而导致一些联动，但是一个好的微服务架构的目标就是通过服务契约中的内聚服务边界和演化机制把这种耦合降到最低。

> *之所以在组件化的软件里用服务，而不是库，一个主要原因就是各个服务是可以独立部署的。比如说，如果在同一个软件里用了多个库，那么就算只是修改了其中一个，都会导致整个软件要被重新部署；相反，如果用的是服务，那只需要重新部署修改过的服务就可以了。然而，有个问题是，当修改某个服务时，可能会把这个服务中的一些接口也修改了，这样一来，服务的调用者和开发者就得自己私下协调了。好的微服务架构，就应该尽量避免这种问题；非要修改服务契约（就是服务之间的调用和通信协议？）的话，也得循序渐进，让调用者有迹可循，不用私下协调。*
>
> *https://www.oschina.net/translate/microservices-a-definition-of-this-new-architectural-term?cmp*

> Another consequence of using services as components is a more explicit component interface. Most languages do not have a good mechanism for defining an explicit [Published Interface](https://martinfowler.com/bliki/PublishedInterface.html). Often it's only documentation and discipline that prevents clients breaking a component's encapsulation, leading to overly-tight coupling between components. Services make it easier to avoid this by using explicit remote call mechanisms.
>
> Using services like this does have downsides. Remote calls are more expensive than in-process calls, and thus remote APIs need to be coarser-grained, which is often more awkward to use. If you need to change the allocation of responsibilities between components, such movements of behavior are harder to do when you're crossing process boundaries.
>
> At a first approximation, we can observe that services map to runtime processes, but that is only a first approximation. A service may consist of multiple processes that will always be developed and deployed together, such as an application process and a database that's only used by that service.

使用服务作为组件的另一个结论是可以得到更加显示的组件接口。大多数语言都没有很好的机制来定义显式发布的接口。通常只有文档和规范来防止客户破坏组件的封装，这导致了组件之间的紧密耦合。因为使用服务作为组件，通过显式的远程调用机制，更容易地避免耦合的发生。

使用这样的服务确实有缺点。远程调用比进程内调用更昂贵，因此远程api需要粗粒度，这通常更难以使用。如果您需要更改组件之间的职责分配，那么当您需要跨越进程边界时就会比较困难。

初步估计，我们可以观察到映射到进程的服务，但这只是一次近似。服务可能包括多个进程，这些进程将始终会一起开发和部署，例如应用进程和只有该服务才用到的数据库。

### Organized around Business Capabilities

> When looking to split a large application into parts, often management focuses on the technology layer, leading to UI teams, server-side logic teams, and database teams. When teams are separated along these lines, even simple changes can lead to a cross-team project taking time and budgetary approval. A smart team will optimise around this and plump for the lesser of two evils - just force the logic into whichever application they have access to. Logic everywhere in other words. This is an example of Conway's Law[[5\]](https://martinfowler.com/articles/microservices.html#footnote-conwayslaw) in action.
>
> Any organization that designs a system (defined broadly) will produce a design whose structure is a copy of the organization's communication structure.
>
> -- Melvin Conway, 1968
>
> ![img](https://martinfowler.com/articles/microservices/images/conways-law.png)

当将大型应用程序拆分为不同组件时，通常的管理侧重于技术层，由技术层引领UI团队、服务器端逻辑团队和数据库团队的工作。当团队的这种生产线被隔离时，即使是简单的改变也会引起跨团队的项目耗时耗力。聪明的团队将围绕这一点进行优化——仅把逻辑强加到他们所能触及的任何应用中（啥意思？？？）。换句话说，逻辑无处不在。这是Conway定律[[5\]](https://martinfowler.com/articles/microservices.html#footnote-conwayslaw)的一个例子。

任何组织设计的系统（广泛定义的系统，不特指os），该系统的结构一定与该组织的通信结构相似

### Products not Projects

### Smart endpoints and dumb pipes

### Decentralized Governance

### Decentralized Data Management

### Infrastructure Automation

### Design for failure

### Evolutionary Design

## Are Microservices the Future?