package com.zeroanjqhk.camppingbackend;

import com.zeroanjqhk.camppingbackend.external.gocampping.client.GoCampingClient;
import com.zeroanjqhk.camppingbackend.external.gocampping.request.BasedListRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@ConfigurationPropertiesScan
public class CamppingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamppingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner testGoCamping(GoCampingClient client) {
        return args -> {
            var req = new BasedListRequest(1, 10);

            // 1) response DTO 없으면 raw로 먼저
            String raw = client.fetchBasedListRaw(req);
            System.out.println(raw);

            // 2) response DTO 만들었으면 이걸로
            // var res = client.fetchBasedList(req);
            // System.out.println("totalCount=" + res.response().body().totalCount());
        };
    }
}