# Thrift 学习 Demo 仓库

## 基本信息

- **仓库名称**: thrift-demo
- **作者**: rickey
- **目的**: 用于学习和研究 Apache Thrift
- **Thrift 版本**: 0.12.0

## 项目结构

```
thrift-demo/
|-- thrift/          # Thrift IDL 定义文件
|-- thrift-client/   # 客户端实现代码
|-- thrift-common/   # 公共代码和生成文件
|-- thrift-server/   # 服务端实现代码
```

## 快速开始

1. **克隆本项目**:
   ```
   git clone https://github.com/rickey-c/thrift-demo
   ```

2. **下载maven依赖**:
   
   ![image](https://github.com/user-attachments/assets/7db284a6-d0b3-42d7-8ec4-c3fff05939f3)


4. **启动服务端监听port**:

   ![image](https://github.com/user-attachments/assets/93627d04-f6b8-49d2-8013-177c5ab31999)

5. **启动客户端**

   ![image](https://github.com/user-attachments/assets/b7cece7a-8bae-4aee-acd0-00037eb8cc36)


## 目前支持的demo
- TSimpleServer
- TThreadPoolServer
- TNonblockingServer
- THsHaServer
- TThreadedSelectorServer

## 学习资源

1. [官方文档](https://thrift.apache.org/docs/)
2. [Thrift 知乎精选问答](https://zhuanlan.zhihu.com/p/45194187)(模型篇讲的十分清晰)
3. [美团技术文章](https://tech.meituan.com/tags/thrift.html)
4. [Thrift 笔记](https://www.notion.so/Thrift-1d0205d58c7380e5a8b2f670e069b608?pvs=4)

## 贡献指南

欢迎提交 PR 或 issue 来改进这个学习项目。
