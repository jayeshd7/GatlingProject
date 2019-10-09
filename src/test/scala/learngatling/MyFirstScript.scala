//package to hold scala class
package learngatling

import io.gatling.core.Predef._     // required for Gatling core structure DSL
import io.gatling.http.Predef._     // required for Gatling HTTP DSL

import scala.concurrent.duration._  // used for specifying duration unit, eg "5 second"

class MyFirstScript extends Simulation{

   val httpProtocol = http.baseUrl("http://newtours.demoaut.com")

   val scn =scenario("View Cruise")
     .exec(http("req_1").get("/mercurycruise.php"))

    setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)


}
