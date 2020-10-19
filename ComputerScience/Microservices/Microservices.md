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

## Componentization via Services

## Organized around Business Capabilities

## Products not Projects

## Smart endpoints and dumb pipes

## Decentralized Governance

## Decentralized Data Management

## Infrastructure Automation

## Design for failure

## Evolutionary Design

## Are Microservices the Future?