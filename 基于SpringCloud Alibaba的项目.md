# 基于SpringCloud Alibaba的项目

## 1. 父工程

#### 1.1 创建新项目，父工程 

-  **开发环境版本要求：**

​	SpringCloud Alibaba : 2021.0

​	SpringCloud : 2021.0

​	SpringBoot : 2.7.0以上

​    JDK 1.8 及以上



- **命名**：eshop_springcloud

#### 1.2 导入项目依赖

​	SpringCloud Alibaba、SpringCloud





## 2.子工程 用户服务 

​	**（1）服务名称** ： eshop-customer-server

​    **（2）业务中实现** controller, service ： 根据主键查询用户

​     **（3）给用户服务创建一个端口**4001

   **（4）测试**根据主键查询用户 http://localhost:4001/customer/101



## 2.子工程 商品服务 

​	**（1）服务名称** ： eshop-product-server

   **（2）给商品服务创建三个端口**  5001，5002，5003 

​    **（3）业务中实现** controller, service ： 根据主键查询商品 , 查询所有商品     

   **（4）测试**以上三个端口的两个方法调用 



## 3. 子工程 订单服务

​	**（1）服务名称** ： eshop-order-server

​    **（2）给订单服务创建两个端口**6001，6002

​    **（3）业务中实现** controller, service ： 添加订单，根据主键查询订单

​	  <3.3.1> 添加订单 : 其中调用用户服务与商品服务，实现添加订单的订单中有详细用户与商品的信息

​			请求类型： post

​			请求参数：custId ,  proId 

​		    请求URL : http://localhost:6001/order

​		    返回类型：JSON (提示 添加订单成功) 		



 <3.3.2>根据主键查询订单: 其中调用用户服务与商品服务，实现订单信息中既有用户信息，又有商品详细的信息		     请求类型：get

​			请求参数：orderId

​		    请求URL : http://localhost:6001/order/301

​		    返回类型：JSON ( OrderDetailVO 订单对象 ( 订单信息+用户信息+ 商品信息 )  ） 	

   

   **（4）测试**以上两个端口的两个方法调用

  **（5）sentinel 设置流控规则**，

​			（5.1）添加订单的请求QPS 上限为2， 若超过该阈值，则设置blockHandler 兜底方法，该方法中提示"目前订单请求过多，请稍后访问"。

​	        测试 5.4  流控规则, 订单模块根据主键查询请求 /order/{orderId} ，QPS >2 ,验证商品服务 /product/{proId}是否可访问



## 4. 配置网关

​	**（1）服务名称** ：eshop-gateway-server

​    **（2）设置网关服务端口**：9090

   **（3）通过网关访问以上所有请求**

  <3.1>  用户模块 ： 根据主键查询用户 GET

​				http://localhost:9090/eshop-customer-server/customer/101

 <3.2>  商品模块   GET

​		根据主键查询商品：http://localhost:9090/eshop-product-server/product/201    

​	    查询所有商品：        http://localhost:9090/eshop-product-server/product/

 <3.3>  订单模块

​		添加订单记录： POST	http://localhost:9090/eshop-order-server/order

​	  根据主键查询订单： GET	http://localhost:9090/eshop-order-server/order/888



## 5. sentinel 设置流控规则

​			（5.1）**查询所有商品**的请求QPS 上限为10 ， 若超过该阈值，则设置blockHandler 兜底方法，该方法中提示"目前用户请求所有商品访问量过大，请稍后访问"。	        

​			（5.2）设置流控规则，**根据主键查询商品**请求 QPS 达到5时，则设置blockHandler 兜底方法，提示"目前用户访问商品详情流量过大，请稍后访问"。

​			（5.3）设置流控**关联**规则，若后期订单服务中请求/order/{orderId}， QPS 达到5时，则设置blockHandler 兜底方法，则该方法中提示"目前用户访问商品详情流量过大，请稍后访问"。

​           （5.4）根据主键查询商品的请求若业务中有异常，则设置fallback兜底方法，该方法中返回Product对象，只有proId属性。 

   测试以上流控规则

 

​      





​						





