package testingil.unittesting.examples.demos.d05.spring.d04.mockbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class ItemRepository {
	
	@Autowired 
	protected JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}
	
	public void addItem(Item item) {
		String name = item.getName();
		int value = item.getValue();
		jdbcTemplate.update(
		"INSERT INTO items(name, value) VALUES(?,?)"
		, name, value);
	}

	public Item findByName(String name) {
		Item item = (Item) jdbcTemplate.query(
				"select * from items where name=?", 
				new BeanPropertyRowMapper<Item>(Item.class),
				name);
		return item;

	}
	
	public int findTotal() {
		int total = jdbcTemplate.
				queryForObject("select count(*) from items", Integer.class);
		return total;
	}
}
