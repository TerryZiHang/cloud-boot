package org.szh.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = {StreamClient.class})
public class StreamConfig {

}
