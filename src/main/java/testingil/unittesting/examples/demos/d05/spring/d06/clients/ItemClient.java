package testingil.unittesting.examples.demos.d05.spring.d06.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class ItemClient {
	
	@Autowired RestTemplate template;
	
	public String getAllItems() {
		try {
			ResponseEntity<String> result =  
				template.getForEntity("/items/" , String.class);
			return result.getBody();
		}
		catch (HttpClientErrorException e) {
			if (e.getStatusCode()== HttpStatus.BAD_REQUEST)
				throw new ItemNotFoundException();
		}
		return "";
		
	}

}	
	
