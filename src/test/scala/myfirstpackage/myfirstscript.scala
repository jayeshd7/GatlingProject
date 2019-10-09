//1
package myfirstpackage

//2
import io.gatling.core.Predef._     // required for Gatling core structure DSL
import io.gatling.http.Predef._     // required for Gatling HTTP DSL
import scala.concurrent.duration._  // used for specifying duration unit, eg "5 second"

//3 declare class name with extended Gatling class simulation
class myfirstscript extends Simulation{

  //HTTP Protocol Configuration
  val httpProtocol = http.baseUrl("http://newtours.demoaut.com/").header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")

  //header definition
val header_1 =Map(
  "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
  "accept-encoding" -> "gzip, deflate, br",
  "accept-language" -> "en-US,en;q=0.9"
                  )

//Scenario definition

  val scn =scenario("viewCruise").exec(http("req_1").get("/mercurycruise.php").headers(header_1)).pause(10)

//simulation definition

setUp(scn.inject(atOnceUsers(2))).protocols(httpProtocol)

}
