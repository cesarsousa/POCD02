package br.com.empresa.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.gov.inpi.controller.rest", "br.gov.inpi.controller.mvc", "br.gov.inpi.repository", "br.gov.inpi.service", "br.gov.inpi.application"})
public class TestConfig {}