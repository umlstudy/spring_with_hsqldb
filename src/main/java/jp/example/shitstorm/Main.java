package jp.example.shitstorm;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
    	AnnotationConfigApplicationContext ctx = null;
    	try {
    		ctx = new AnnotationConfigApplicationContext();
    		ctx.register(AppConfig.class);
    		ctx.refresh();
    		JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
    		List<Momoclo> query = template.query("SELECT * FROM momoclo", new BeanPropertyRowMapper<Momoclo>(Momoclo.class));
    		for ( Momoclo ele : query ) {
    			System.out.println(ele);
    		}
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	} finally {
    		if ( ctx != null ) {
    			ctx.close();
    		}
    	}
    }
}