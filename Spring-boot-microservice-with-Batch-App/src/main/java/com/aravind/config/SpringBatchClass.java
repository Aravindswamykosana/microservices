package com.aravind.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.aravind.entity.Customer;
import com.aravind.repo.CustomerRepo;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchClass {
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<Customer> itemReader(){
		FlatFileItemReader<Customer> file=new FlatFileItemReader<Customer>();
		file.setResource(new ClassPathResource("customers.csv"));
		file.setLinesToSkip(1);
		file.setLineMapper(lineMapper());
		return file;
	}

	private LineMapper<Customer> lineMapper() {
		DefaultLineMapper<Customer> mapper=new DefaultLineMapper<>();
		DelimitedLineTokenizer token=new DelimitedLineTokenizer();
		token.setDelimiter(",");
		token.setStrict(false);
		token.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");
		BeanWrapperFieldSetMapper<Customer> setMapper=new BeanWrapperFieldSetMapper<>();
		setMapper.setTargetType(Customer.class);
		mapper.setLineTokenizer(token);
		mapper.setFieldSetMapper(setMapper);
		return mapper;
	}
	
	@Bean
	public CustomerProcessor itemProcessor() {
		return new CustomerProcessor();
	}
	
	@Bean
	public RepositoryItemWriter<Customer> itemWriter(){
		RepositoryItemWriter<Customer> writer=new RepositoryItemWriter<>();
		writer.setRepository(repo);
		writer.setMethodName("save");
		return writer;
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Customer, Customer>chunk(10)
				.reader(itemReader())
				.processor(itemProcessor())
				.writer(itemWriter())
				.build();
	}
	
	@Bean
    public Job job() {
        return jobBuilderFactory.get("customer-import").flow(step1()).end().build();
    }
}
