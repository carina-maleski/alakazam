package com.alakazam.javaconsumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class TransactionController {

	@RabbitListener(queues = "#{autoDeleteQueue.name}")
	public void receive(String in) throws InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println(" [x] Received '" + in + "'");
		watch.stop();
		System.out.println(" [x] Done in " + watch.getTotalTimeSeconds() + "s");
	}

}