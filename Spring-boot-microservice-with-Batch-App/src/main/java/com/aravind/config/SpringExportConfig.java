package com.aravind.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.aravind.entity.Customer;

@Configuration
public class SpringExportConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaPagingItemReader<Customer> exportReader() {
        JpaPagingItemReader<Customer> reader = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT c FROM Customer c");
        reader.setPageSize(10);
        return reader;
    }

    @Bean
    public FlatFileItemWriter<Customer> exportWriter() {
        FlatFileItemWriter<Customer> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("output/customers_output.csv"));
        writer.setLineAggregator(new DelimitedLineAggregator<Customer>() {{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<Customer>() {{
                setNames(new String[]{"id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob"});
            }});
        }});
        writer.setHeaderCallback(writer1 -> writer1.write("ID,FirstName,LastName,Email,Gender,ContactNo,Country,DOB"));
        return writer;
    }

    @Bean
    public Step exportStep() {
        return stepBuilderFactory.get("export-step")
                .<Customer, Customer>chunk(10)
                .reader(exportReader())
                .processor(new CustomerProcessor())
                .writer(exportWriter())
                .build();
    }

    @Bean(name = "exportJob")
    public Job exportJob() {
        return jobBuilderFactory.get("export-customer-job")
                .start(exportStep())
                .build();
    }
}
