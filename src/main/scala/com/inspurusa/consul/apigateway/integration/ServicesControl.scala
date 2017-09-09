package com.inspurusa.consul.apigateway.integration

import org.fusesource.scalate.TemplateEngine
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.core.env.{Environment, SimpleCommandLinePropertySource}


/**
  *
  */

@Configuration
@ComponentScan
@SpringBootApplication
class ServicesControl {

  @Bean def props() = new ServicesControlProperties

  



  @Bean def nginxController = new NginxController( templateEngine)


  @Bean def templateEngine: TemplateEngine = {
    val templateEngine = new TemplateEngine
    // Resolver for TEXT
    templateEngine.allowCaching = false

    templateEngine
  }


}


object ServicesControl extends App {


//  val s = new Settings
//  s processArgumentString "-usejavacp"
//  val g = new Global(s)
//  val r = new g.Run

  val log: Logger = LoggerFactory.getLogger(classOf[ServicesControl])

  val app: SpringApplication = new SpringApplication(classOf[ServicesControl])
  val source: SimpleCommandLinePropertySource = new SimpleCommandLinePropertySource(args: _*)
  val context = app.run(args: _*)
  val env: Environment = context.getEnvironment
  val props = context.getBean(classOf[ServicesControlProperties])


  println( context.getBean(classOf[NginxController]).generateConfigFile() )



  System.exit(0)

}
