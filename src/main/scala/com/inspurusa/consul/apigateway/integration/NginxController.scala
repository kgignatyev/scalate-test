package com.inspurusa.consul.apigateway.integration


import com.inspurusa.consul.apigateway.integration.data.SvcInfo
import org.fusesource.scalate.TemplateEngine

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  *
  */
class NginxController( templateEngine: TemplateEngine) extends LogSupport {


  def mapServicesToDomains(serviceInfos: Iterable[SvcInfo]): mutable.HashMap[String, ListBuffer[SvcInfo]] = {
    val res = mutable.HashMap[String, ListBuffer[SvcInfo]]()
    serviceInfos.foreach(si => {
      val domainNames = si.parsedTags.getOrElse("domain", ListBuffer[String]("root"))
      domainNames.foreach(dn => {
        res.getOrElseUpdate(dn, ListBuffer[SvcInfo]()).+=(si)
      })
    })
    res
  }



  def createNginxConfig(domainsMap: collection.Map[String,collection.Iterable[SvcInfo]], services: collection.Iterable[SvcInfo], templateUri:String = "templates/text/nginx.cfg.ssp"): String = {

    println( templateEngine.generateScala(templateUri).source )

    templateEngine.layout(templateUri, Map("domainsMap"->domainsMap, "services"->services))

  }

  def generateConfigFile( templateUri:String = "templates/text/nginx.cfg.ssp"): String = {

    val serviceInfosToPublish = List( SvcInfo("service1",List("domain=abc.some,publish=yes")),
      SvcInfo("service-zz",List("domain=zz.some,publish=yes")))


    val domainsToServices = mapServicesToDomains(serviceInfosToPublish)


      createNginxConfig(domainsToServices, serviceInfosToPublish, templateUri)
  }

}
