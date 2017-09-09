package com.inspurusa.consul.apigateway.integration

import org.springframework.boot.context.properties.ConfigurationProperties

import scala.beans.BeanProperty

@ConfigurationProperties
class ServicesControlProperties {

  @BeanProperty var kongAdminUrl:String = ""
  @BeanProperty var consulAdminUrl:String = ""
  @BeanProperty var k8SAdminUrl:String = ""
}
