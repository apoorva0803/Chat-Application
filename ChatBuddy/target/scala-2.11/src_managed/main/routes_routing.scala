// @SOURCE:C:/Users/Sairam/OneDrive/SPL/Scala/activator-dist-1.3.6/ChatBuddy/ChatBuddy/conf/routes
// @HASH:c8d463267aff02fe8b42b64f7ad58e6ec16bf8cd
// @DATE:Tue Dec 01 22:52:52 EST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:8
private[this] lazy val controllers_Application_postMessage1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post"))))
private[this] lazy val controllers_Application_postMessage1_invoker = createInvoker(
controllers.Application.postMessage,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "postMessage", Nil,"POST", """""", Routes.prefix + """post"""))
        

// @LINE:9
private[this] lazy val controllers_Application_msgFeed2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("stream"))))
private[this] lazy val controllers_Application_msgFeed2_invoker = createInvoker(
controllers.Application.msgFeed,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "msgFeed", Nil,"GET", """""", Routes.prefix + """stream"""))
        

// @LINE:10
private[this] lazy val controllers_Application_upload3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("upload"))))
private[this] lazy val controllers_Application_upload3_invoker = createInvoker(
controllers.Application.upload,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "upload", Nil,"POST", """""", Routes.prefix + """upload"""))
        

// @LINE:11
private[this] lazy val controllers_Application_download4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("download"))))
private[this] lazy val controllers_Application_download4_invoker = createInvoker(
controllers.Application.download,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "download", Nil,"POST", """""", Routes.prefix + """download"""))
        

// @LINE:13
private[this] lazy val controllers_Assets_at5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post""","""controllers.Application.postMessage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """stream""","""controllers.Application.msgFeed"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """upload""","""controllers.Application.upload"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """download""","""controllers.Application.download"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:8
case controllers_Application_postMessage1_route(params) => {
   call { 
        controllers_Application_postMessage1_invoker.call(controllers.Application.postMessage)
   }
}
        

// @LINE:9
case controllers_Application_msgFeed2_route(params) => {
   call { 
        controllers_Application_msgFeed2_invoker.call(controllers.Application.msgFeed)
   }
}
        

// @LINE:10
case controllers_Application_upload3_route(params) => {
   call { 
        controllers_Application_upload3_invoker.call(controllers.Application.upload)
   }
}
        

// @LINE:11
case controllers_Application_download4_route(params) => {
   call { 
        controllers_Application_download4_invoker.call(controllers.Application.download)
   }
}
        

// @LINE:13
case controllers_Assets_at5_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at5_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     