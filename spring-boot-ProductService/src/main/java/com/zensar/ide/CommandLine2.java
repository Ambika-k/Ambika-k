package com.zensar.ide;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
public class CommandLine2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Command Line Runner2"+Arrays.toString(args));
		
	}

}
