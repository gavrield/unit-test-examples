package testingil.unittesting.examples.demos.d05.spring.d05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/items")
public class ItemController {

	@Autowired ItemRepository itemRepository;
	
	@GetMapping(value ="/")
	public ResponseEntity<String> getAllItems() {
		Integer numberOfItems = itemRepository.findTotal();
		if (numberOfItems == 0)
			return new ResponseEntity<String>("Error", HttpStatus.SERVICE_UNAVAILABLE);
		else {
			
			String result =numberOfItems.toString() + " Items"; 	
			return new ResponseEntity<String> (result , HttpStatus.OK);
		}
	}

	@PostMapping(value = "/add") 
	public ResponseEntity<?> addItem(@RequestBody String itemName) {
		Item item = new Item(itemName, 1);
		itemRepository.addItem(item);
		
		return new ResponseEntity(HttpStatus.OK);
		
	}
		
}
