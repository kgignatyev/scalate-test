package com.inspurusa.consul.apigateway.integration

import org.slf4j.{Logger, LoggerFactory}

/**
  *
  */
trait LogSupport {

  val logger: Logger = LoggerFactory.getLogger(this.getClass)

}
