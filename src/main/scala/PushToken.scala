import java.sql.{DriverManager, ResultSet}

object PushToken {
  def main(args: Array[String]): Unit = {
    // Create new database connection object
    val db_cxn = new connectDB

    // Database credentials
    val dbURL = db_cxn.url
    val dbUser = db_cxn.user
    val dbPass = db_cxn.password

    // Load driver
    classOf[com.mysql.cj.jdbc.Driver]

    // Setup connection
    val cxn = DriverManager.getConnection(dbURL, dbUser, dbPass)
    try {
      // Configure to be read only
      val statement = cxn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      // Insert secret key and jwt
      val genToken = new GenerateToken
      val secretKey = genToken.secretKey
      println(secretKey.mkString("Array(", ", ", ")"))
    } catch {
      case e: Exception => println("Error reading secret key")
    }
  }
}
