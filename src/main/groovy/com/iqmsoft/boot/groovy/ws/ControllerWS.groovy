package com.iqmsoft.boot.groovy.ws

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.annotation.SendToUser
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.stereotype.Controller
import org.springframework.messaging.handler.annotation.SendTo

import com.iqmsoft.boot.groovy.model.Position;

@Controller
public class PortfolioController {
	
	
	private List<Position> messages = new ArrayList<>()
	
	@SubscribeMapping("/trade")
	public List<Position> getPositions() throws Exception {
		
		return messages
		
	}

	@MessageMapping("/trade")
	@SendTo("/topic/trade")
	public Position executeTrade(Position trade) {
		
		
		messages.add(0, trade);
		return trade
	}

	
}
