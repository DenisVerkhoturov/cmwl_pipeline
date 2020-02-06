package cromwell.pipeline.utils.auth

import cromwell.pipeline.datastorage.dto.{ UserEmail, FirstName, LastName, User, UUID => UserId }
import cromwell.pipeline.utils.StringUtils
import cats.implicits._

object TestUserUtils {
  val userPassword = "-Pa$$w0rd-"

  def getDummyUser(
    uuid: UserId = UserId.random,
    email: UserEmail = UserEmail("JohnDoe-@cromwell.com"),
    password: String = userPassword,
    passwordSalt: String = "salt",
    firstName: FirstName = FirstName("FirstName"),
    lastName: LastName = LastName("LastName"),
    active: Boolean = true
  ): User = {
    val passwordHash = StringUtils.calculatePasswordHash(password, passwordSalt)
    User(
      uuid,
      UserEmail(s"JohnDoe-$uuid@cromwell.com"),
      passwordHash,
      passwordSalt,
      firstName,
      lastName,
      None,
      active
    )
  }
}
