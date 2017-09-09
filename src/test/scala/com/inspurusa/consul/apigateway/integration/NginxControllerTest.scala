package com.inspurusa.consul.apigateway.integration

import javax.inject.Inject

import org.junit.runner.RunWith
import org.junit.{Before, Test}
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
  *
  */
@SpringBootTest
@RunWith(classOf[SpringRunner])
class NginxControllerTest {

  @Inject
  var nginxCtrl:NginxController = _



   @Before
   def init(): Unit ={
  
   }

   @Test
   def generateConfigFiles(): Unit ={
      println(nginxCtrl.generateConfigFile())
   }

}
