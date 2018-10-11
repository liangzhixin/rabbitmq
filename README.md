# rabbitmq

rabbitmq概念详见https://blog.csdn.net/u013256816/article/details/59117354

注意: 一个消息只能被消费一次


同时起多个一模一样的消费者，以并行的方式来拉取消息队列中的消息。这样的好处有多个:
    1.加快处理消息队列中的消息.
    2.增强稳定性，如果一个消费者出现问题，不会影响对消息队列中消息的处理.


Default Exchange,是特殊的Direct Exchange,是rabbitmq内部默认的一个交换机.
    该交换机的name是空字符串,所有queue都默认binding 到该交换机上.
    该交换机和queue绑定的routing-key(理解为binding-key)和queue的name一样.



# 更多属性配置请见springboot官网https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/


