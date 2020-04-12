package es.diegofpb.lametric.emtmad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmtmadApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmtmadApplication.class, args);
    }

}
