package com.kafka.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //milliseconds
    @Scheduled(fixedRate = 4 * 60 * 1000)
    public void checkKafkaLag() {
        Process process = null;
        try {
            process = new ProcessBuilder()
                    .command("/Users/iGD-Dev1/Downloads/kafka_2.12-3.3.1/bin/kafka-consumer-groups.sh", "--bootstrap-server", "localhost:9092",
                            "--describe", "--group", "tweet-group")
                    .start();


            InputStream inputStream = process.getInputStream();
            try {
                process.waitFor(60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileCopyUtils.copy(inputStream, baos);
            System.out.println("LAG: " + new String(baos.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
