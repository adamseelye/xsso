import pdi.jwt.{Jwt, JwtAlgorithm, JwtClaim}

import java.security.SecureRandom
import java.time.Instant
import java.util.Base64

class GenerateToken {

    val claim: JwtClaim = JwtClaim(
      content = """{"user":"UsernameTest"}""",
      issuer = Some("xsso"),
      expiration = Some(Instant.now.getEpochSecond + 3600)
    )

    val secureRandom = new SecureRandom()
    var secretKey = new Array[Byte](32)
    secureRandom.nextBytes(secretKey)
    val encodedKey: String = Base64.getEncoder.encodeToString(secretKey)

    val jwt: String = Jwt.encode(claim, encodedKey, JwtAlgorithm.HS256)
}