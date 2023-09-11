package com.asp.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="classpath:featureFiles", 
					glue="com/asp/stepDefinitions",
					monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}