package io.flowing.retail.commands;

import io.flowing.retail.commands.channel.ChannelConsumer;
import io.flowing.retail.commands.channel.ChannelSender;
import io.flowing.retail.commands.channel.kafka.KafkaChannelConsumer;
import io.flowing.retail.commands.channel.kafka.KafkaSender;
import io.flowing.retail.commands.orchestration.businessmodel.OrderServiceBusinessModelOrchestration;

public class ApplicationOrder {

  public static void main(String[] args) throws Exception {
    System.out.println("STARTING ORDER SERVICE");

    // Select channel and type of orchestration
    OrderService.instance = new OrderServiceBusinessModelOrchestration();

    ChannelConsumer.startup(new KafkaChannelConsumer());
    // ChannelConsumer.startup(new RabbitMqConsumer());
    ChannelSender.startup(new KafkaSender());
    // ChannelSender.startup(new RabbitMqSender());

  }

}
