package cct.sporlanc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cct.sporlanc.dao.*;


@Configuration
@ComponentScan(basePackages="cct.sporlanc.*")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //To avoid warning:
        //jdbc:mysql://localhost:8080/sport_center?verifyServerCertificate=false&useSSL=true
        dataSource.setUrl("jdbc:mysql://aausxw6fggekyp.ct1zo6hzbpis.eu-west-1.rds.amazonaws.com:3306/sport_center?verifyServerCertificate=false&useSSL=true");
        dataSource.setUsername("admin");
        dataSource.setPassword("manoel1412");
        
        //IF the database is not working, deploy in the local machine and use the credentials as follow: 
        //dataSource.setUrl("jdbc:mysql://localhost:8889/sport_center");
        //dataSource.setUsername("root");
        //dataSource.setPassword("root");
         
        return dataSource;
    }
	
	@Bean
	public ItemDAO getItemDAO() {
		return new ItemDAOImpl(getDataSource());
	}
	
	@Bean 
	public AddItemDAO getAddItemDAO() {
		return new AddItemDAOImpl(getDataSource());
	}
	
	@Bean 
	public BookingDAO bookingDAO() {
		return new BookingDAOImpl(getDataSource());
	}
	
	@Bean 
	public ClassDAO classDAO() {
		return new ClassDAOImpl (getDataSource());
	}
	
	@Bean
	public EircodeDAO eircodeDAO() {
		return new EircodeDAOImpl (getDataSource());
	}
	
	@Bean 
	public EmployeeDAO employeeDAO() {
		return new EmployeeDAOImpl (getDataSource());
	}
	
	@Bean 
	public ParentDAO parentDAO() {
		return new ParentDAOImpl (getDataSource());
	}
	
	@Bean 
	public StudentDAO studentDAO() {
		return new StudentDAOImpl (getDataSource());
	}
	
}
