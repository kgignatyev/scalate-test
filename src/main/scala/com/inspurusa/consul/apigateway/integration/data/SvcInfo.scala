package com.inspurusa.consul.apigateway.integration.data

import scala.collection.mutable

case class SvcEndpoint ( ip:String, port:Integer) {

  def toHttpURL:String = {
    "http://"+ip+":"+port
  }

}

case class SvcInfo(name:String, tags:Iterable[String]) {

  val parsedTags = mutable.HashMap[String,mutable.ListBuffer[String]]()
  var nodes = List[SvcEndpoint]()

  tags.foreach(t=>{
     val parts = t.split('=')
     val key = parts.head
     val v = if( parts.length>1) parts(1) else "present"
     parsedTags.getOrElseUpdate(key, mutable.ListBuffer[String]()).+=(v)

  })

}
