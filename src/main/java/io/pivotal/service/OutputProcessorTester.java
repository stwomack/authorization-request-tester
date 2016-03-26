package io.pivotal.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import io.pivotal.domain.AuthorizationRequest;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

@EnableBinding(Source.class)
public class OutputProcessorTester {
    private static final int MESSAGE_COUNT = 1;
    ObjectMapper mapper = new ObjectMapper();

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "${fixedDelay}", maxMessagesPerPoll = "1"))
    public MessageSource<String> go() throws IOException {
        return () -> new GenericMessage<>(createTestPayload().toString());
    }

    public AuthorizationRequest createTestPayload() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest(
                randLong(), randLong(), randLong(), randLong(),
                Math.abs(new Random().nextDouble()), RandomStringUtils.randomAlphabetic(8), new Date());
        return authorizationRequest;
    }

    private long randLong() {
        Long min = new Long(10000000);
        Long max = new Long(99999999);

        return Math.abs(randomLong(min, max));
    }

    private long randomLong(long min, long max) {
        return (new Random().nextLong() % (max - min)) + min;
    }
}