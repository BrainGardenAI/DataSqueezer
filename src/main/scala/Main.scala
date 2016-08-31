import akka.actor.ActorSystem
import akka.event.Logging
import akka.event.Logging.InfoLevel
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import service.health._

object Main extends App with HealthRoutes {
  
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher 

  val settings = Settings(system)

  val logger = Logging(system, getClass)
  
  Http().bindAndHandle(routes, settings.Http.interface, settings.Http.port) map { binding =>
    logger.info(s"Server started on port {}", binding.localAddress.getPort)
  } recoverWith { case _ => system.terminate() }
}
