package com.asp.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:featureFiles", 
					glue="com/asp/stepDefinitions",
					monochrome = true)
public class TestRunner {

}