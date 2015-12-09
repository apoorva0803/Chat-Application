
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Call,Call,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(stream: Call, post: Call)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.61*/("""

"""),_display_(/*3.2*/main("Chat Server")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    """),format.raw/*4.5*/("""<h1 style=" text-align:center; " >Welcome to chat application based in Play Framework for Scala</h1>
    <div class="container">

    </div>
    <div class="container1">

        <input id="msg" type="text" name="message" placeholder="Enter Your message and hit enter" />
    </div>

    """),_display_(/*13.6*/helper/*13.12*/.form(action = routes.Application.upload, 'enctype -> "multipart/form-data")/*13.88*/ {_display_(Seq[Any](format.raw/*13.90*/("""

        """),format.raw/*15.9*/("""<div class="container1">
            <h1> Upload a File</h1>
            <input type="file" name="file">

            <p>
                <input type="submit">
            </p>
        </div>
    """)))}),format.raw/*23.6*/("""
    """),_display_(/*24.6*/helper/*24.12*/.form(action = routes.Application.download, 'enctype -> "multipart/form-data")/*24.90*/ {_display_(Seq[Any](format.raw/*24.92*/("""
        """),format.raw/*25.9*/("""<div class="container1">
            <h1>Download a File</h1>
            <p>
                <input type="text" name="filename" placeholder="Filename with extension" />
                <input type="submit" value="Download">
            </p>
        </div>
    """)))}),format.raw/*32.6*/("""


    """),format.raw/*35.5*/("""<script>
            do"""),format.raw/*36.15*/("""{"""),format.raw/*36.16*/("""
                """),format.raw/*37.17*/("""var selection = parseInt(window.prompt("Please enter 1 for Public chat room and 2 for private chat!", ""), 10);
            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/("""while(isNaN(selection) &&( selection != 1 || selection !=2));

            var user = $.cookie("user");
            if(user == ""|| user==null)
            """),format.raw/*42.13*/("""{"""),format.raw/*42.14*/("""
                """),format.raw/*43.17*/("""while(user=="" || user==null)"""),format.raw/*43.46*/("""{"""),format.raw/*43.47*/("""
                    """),format.raw/*44.21*/("""user = prompt("What should be your username?");
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/("""

            """),format.raw/*47.13*/("""}"""),format.raw/*47.14*/("""
            """),format.raw/*48.13*/("""if(selection==1)"""),format.raw/*48.29*/("""{"""),format.raw/*48.30*/("""
                """),format.raw/*49.17*/("""var topic=$.cookie("topic");

                if(topic=="" || topic==null || topic== undefined)
                """),format.raw/*52.17*/("""{"""),format.raw/*52.18*/("""
                    """),format.raw/*53.21*/("""while(topic=="" || topic==null || topic < 1 || topic >3 || isNaN(topic))"""),format.raw/*53.93*/("""{"""),format.raw/*53.94*/("""
                        """),format.raw/*54.25*/("""topic=prompt("Select one of the following topics: \n1. US Politics \n2. Sports \n3.Technology\n(Enter the number)");
                        if(topic==1) topicName="US Politics";
                        else if(topic==2) topicName="Sports";
                        else if(topic==3) topicName="Technology"
                    """),format.raw/*58.21*/("""}"""),format.raw/*58.22*/("""
                """),format.raw/*59.17*/("""}"""),format.raw/*59.18*/("""
                """),format.raw/*60.17*/("""$.cookie("topic", topic);
            """),format.raw/*61.13*/("""}"""),format.raw/*61.14*/("""
            """),format.raw/*62.13*/("""if(selection==2)"""),format.raw/*62.29*/("""{"""),format.raw/*62.30*/("""
                """),format.raw/*63.17*/("""var user2 =$.cookie("user2", user2);//accessing cookies
                if(user2 == ""||user2==null)
                """),format.raw/*65.17*/("""{"""),format.raw/*65.18*/("""
                    """),format.raw/*66.21*/("""while(user2=="" || user2==null)"""),format.raw/*66.52*/("""{"""),format.raw/*66.53*/("""
                        """),format.raw/*67.25*/("""user2 = prompt("Whom do you wish to chat with?");
                    """),format.raw/*68.21*/("""}"""),format.raw/*68.22*/("""

                """),format.raw/*70.17*/("""}"""),format.raw/*70.18*/("""
                """),format.raw/*71.17*/("""$.cookie("user2", user2);

            """),format.raw/*73.13*/("""}"""),format.raw/*73.14*/("""
            """),format.raw/*74.13*/("""$.cookie("chat", selection);
            $.cookie("user", user);//setting cookies


            $("#msg" ).on("keyup", function(e)"""),format.raw/*78.47*/("""{"""),format.raw/*78.48*/("""
                """),format.raw/*79.17*/("""if( e.keyCode != 13)
                    return;
                var m = """),format.raw/*81.25*/("""{"""),format.raw/*81.26*/(""" """),format.raw/*81.27*/("""message: this.value, user: user, user2:user2, select:selection, topic: topic """),format.raw/*81.104*/("""}"""),format.raw/*81.105*/(""";
                this.value = "";
                $.ajax("""),format.raw/*83.24*/("""{"""),format.raw/*83.25*/("""
                    """),format.raw/*84.21*/("""url: """"),_display_(/*84.28*/post/*84.32*/.toString()),format.raw/*84.43*/("""",
                    data: JSON.stringify(m),
                    method: "post",
                    contentType: "application/json"
                """),format.raw/*88.17*/("""}"""),format.raw/*88.18*/(""");
            """),format.raw/*89.13*/("""}"""),format.raw/*89.14*/(""");

            var feed = new EventSource(""""),_display_(/*91.42*/stream/*91.48*/.absoluteURL()),format.raw/*91.62*/("""");
            feed.addEventListener("message", function (msg) """),format.raw/*92.61*/("""{"""),format.raw/*92.62*/("""
                """),format.raw/*93.17*/("""var m = JSON.parse(msg.data);
                if (m.user==user)"""),format.raw/*94.34*/("""{"""),format.raw/*94.35*/("""
                    """),format.raw/*95.21*/("""$(".container" ).append("<div class='text-right'><p class='white-shadow'>" + m.user +":"+ m.message + "</p></div>");
                """),format.raw/*96.17*/("""}"""),format.raw/*96.18*/("""
                """),format.raw/*97.17*/("""else if ($.cookie("chat")==2 && m.select==2 && m.user2==user && m.user==user2 )
                    $(".container" ).append("<div class='text-left'><p class='white-shadow'>"  + m.user+":" + m.message + "</p></div>");
                else if ($.cookie("chat")==1 && m.select==1 && m.topic == topic)
                    $(".container" ).append("<div class='text-left'><p class='white-shadow'>"  + m.user+":" + m.message + "</p></div>");
                else if (m.user=="Chat-Buddy")"""),format.raw/*101.47*/("""{"""),format.raw/*101.48*/("""
                    """),format.raw/*102.21*/("""$(".container" ).append("<div class='text-left'><p class='white-shadow'>"  + m.user+":" + m.message +"</p></div>");
                    if(topicName!="") $(".container" ).append("<div class='text-left'><p class='white-shadow'>"  + "This is chat room for following topic:" + topicName+"</p></div>");
                """),format.raw/*104.17*/("""}"""),format.raw/*104.18*/("""
            """),format.raw/*105.13*/("""}"""),format.raw/*105.14*/(""", false);
    </script>
""")))}),format.raw/*107.2*/("""
"""))}
  }

  def render(stream:Call,post:Call,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(stream,post)(request)

  def f:((Call,Call) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (stream,post) => (request) => apply(stream,post)(request)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Dec 01 22:52:53 EST 2015
                  SOURCE: C:/Users/Sairam/OneDrive/SPL/Scala/activator-dist-1.3.6/ChatBuddy/ChatBuddy/app/views/index.scala.html
                  HASH: 9fab477c504dbb913cda2b976de0d492300091d9
                  MATRIX: 522->1|669->60|697->63|724->82|763->84|794->89|1109->378|1124->384|1209->460|1249->462|1286->472|1513->669|1545->675|1560->681|1647->759|1687->761|1723->770|2015->1032|2049->1039|2100->1062|2129->1063|2174->1080|2326->1204|2355->1205|2539->1361|2568->1362|2613->1379|2670->1408|2699->1409|2748->1430|2840->1494|2869->1495|2911->1509|2940->1510|2981->1523|3025->1539|3054->1540|3099->1557|3239->1669|3268->1670|3317->1691|3417->1763|3446->1764|3499->1789|3853->2115|3882->2116|3927->2133|3956->2134|4001->2151|4067->2189|4096->2190|4137->2203|4181->2219|4210->2220|4255->2237|4400->2354|4429->2355|4478->2376|4537->2407|4566->2408|4619->2433|4717->2503|4746->2504|4792->2522|4821->2523|4866->2540|4933->2579|4962->2580|5003->2593|5161->2723|5190->2724|5235->2741|5336->2814|5365->2815|5394->2816|5500->2893|5530->2894|5616->2952|5645->2953|5694->2974|5728->2981|5741->2985|5773->2996|5953->3148|5982->3149|6025->3164|6054->3165|6126->3210|6141->3216|6176->3230|6268->3294|6297->3295|6342->3312|6433->3375|6462->3376|6511->3397|6672->3530|6701->3531|6746->3548|7256->4029|7286->4030|7336->4051|7680->4366|7710->4367|7752->4380|7782->4381|7838->4406
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|34->13|34->13|34->13|34->13|36->15|44->23|45->24|45->24|45->24|45->24|46->25|53->32|56->35|57->36|57->36|58->37|59->38|59->38|63->42|63->42|64->43|64->43|64->43|65->44|66->45|66->45|68->47|68->47|69->48|69->48|69->48|70->49|73->52|73->52|74->53|74->53|74->53|75->54|79->58|79->58|80->59|80->59|81->60|82->61|82->61|83->62|83->62|83->62|84->63|86->65|86->65|87->66|87->66|87->66|88->67|89->68|89->68|91->70|91->70|92->71|94->73|94->73|95->74|99->78|99->78|100->79|102->81|102->81|102->81|102->81|102->81|104->83|104->83|105->84|105->84|105->84|105->84|109->88|109->88|110->89|110->89|112->91|112->91|112->91|113->92|113->92|114->93|115->94|115->94|116->95|117->96|117->96|118->97|122->101|122->101|123->102|125->104|125->104|126->105|126->105|128->107
                  -- GENERATED --
              */
          