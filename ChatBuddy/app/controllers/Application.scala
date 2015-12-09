package controllers

import play.api.libs.EventSource
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.iteratee.{Enumerator, Concurrent, Enumeratee}
import play.api.libs.json.{Json, JsValue}
import play.api.mvc._

object Application extends Controller {

  /** Central hub for distributing chat messages */
  val (chatOut, chatChannel) = Concurrent.broadcast[JsValue]

  def index = Action { implicit req =>
    Ok(views.html.index(routes.Application.msgFeed, routes.Application.postMessage))
  }

  /** Enumeratee for detecting disconnect of SSE stream */
  def connDeathWatch(addr: String): Enumeratee[JsValue, JsValue] =
    Enumeratee.onIterateeDone{ () => println(addr + " - SSE disconnected") }

  def welcome = Enumerator.apply[JsValue](Json.obj(
    "user" -> "Chat-Buddy",
    "message" -> "Welcome to Chat-Buddy!!! Write your message and press ENTER."
  ))


  /** Controller action serving activity */
  def msgFeed = Action { req =>
    println(req.remoteAddress + " - connected")
    Ok.chunked(welcome >>> chatOut
      &> connDeathWatch(req.remoteAddress)
      &> EventSource()
    ).as("text/event-stream")
  }

  /** Controller action for POSTing chat messages */
  def postMessage = Action(parse.json) { req => chatChannel.push(req.body); Ok }

  def upload = Action(parse.multipartFormData) { request =>
    println(request.body)
    request.body.file("file").map { request =>
      import java.io.File
      val filename = request.filename
      val contentType = request.contentType
      request.ref.moveTo(new File(s"$filename"))
      Ok("File uploaded")
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
  }

  def download = Action(parse.multipartFormData) { request =>
    //var m=request.body.dataParts
    //var n=m.get("filename")
    //var l=n.get
    println(request.body.asFormUrlEncoded.get("filename").head(0))
    val f =request.body.asFormUrlEncoded.get("filename").head(0)
    Ok.sendFile(
      content = new java.io.File(f),
      fileName = _ => f
    )

  }

}