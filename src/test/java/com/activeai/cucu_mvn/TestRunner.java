package com.activeai.cucu_mvn;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/AdminLogin/") 
public class TestRunner {

}	
