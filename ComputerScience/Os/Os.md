# 概述

## 什么是操作系统

* 从控制角度考虑，操作系统是一个控制程序。限制不同的软件占用不同的资源，如何来运行。
* 操作系统可以提供各种服务，可以使软件使用各种IO服务，例如使用网卡·声卡等 
* 操作系统用来协调分配各种资源（例如协调鼠标、键盘等）
* 是一种特殊的软件，他直接对接于硬件。像上层的软件提供使用硬件的各种接口。即其位于硬件之上，应用软件之下

## 操作系统对计算机的抽象

CPU ====os抽象为====> 进程

磁盘 ====os抽象为====> 文件

内存 ====os抽象为====> 地址空间

**Shell和Kernel**

操作系统中面向应用程序的接口一般称为**shell**（*在win中就是其gui，在linux中就是敲命令行的地方）*，而面向计算机内部资源的称为**kernel**

**kernel**的主要组成部分

* CPU调度器 CPU scheduling
* 物理内存管理 page replacement
* 虚拟内存管理 virtual memory
* 文件系统管理 file system
* 中断处理与设备驱动 terminal drivers / disk and tape drivers

## Kernel的特征

并发：在**一段时间**内有多个程序可以运行

并行：在**一个时间点**上有多个程序可以运行（如果只有一个cpu是不可能实现并行的）

共享：存在“同时共享”和“互斥共享”的情况

虚拟：利用多道程序设计技术，让用户可以拥有独立的计算机服务

异步：程序的执行不是一贯到底的，而是走走停停 



> 操作系统有关的国际最新前沿知识获取方式
>
> SOSP
>
> USENIX

# 操作系统的启动 中断 异常和系统调用



## 计算机的启动

**定义**

Disk：存放os

Bios: 计算机启动之后，对计算机所有的外设的检测

Bootloader：计算机启动之后，将系统从Disk存放到内存

**计算机启动流程**

接通电源 -> Bios启动并检测外设 -> Bios将Bootloader从Disk加载到CPU中 -> Bootloader将OS从Disk加载到CPU中 -> Bootloader将CPU的控制权交接给OS

## 系统调用、异常和中断

**定义**

系统调用(来源于应用程序)：应用程序主动向操作系统发出服务请求（程序求系统办事）

异常(来源于不良的应用程序)：非法指令或者其他坏的处理状态（如内存出错）

中断(来源于外设): 来自不同的硬件设备的计时器和网络的中断

**处理时间**

系统调用：异步或同步

异常：同步 (因为来源于程序，而程序语句的执行是可预知的)

中断：异步 (因为计算机不知道什么时候会产生)

**响应状态**

系统调用：等待和持续

异常：杀死或者重新执行意想不到的应用程序指令

中断：持续，对用户应用程序时透明的



