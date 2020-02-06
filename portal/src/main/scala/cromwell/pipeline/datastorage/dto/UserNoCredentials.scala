package cromwell.pipeline.datastorage.dto

import play.api.libs.json.{ Json, OFormat }

final case class UserNoCredentials(
  userId: UUID,
  email: UserEmail,
  firstName: FirstName,
  lastName: LastName,
  active: Boolean
)

object UserNoCredentials {
  implicit val UserNoCredentialsFormat: OFormat[UserNoCredentials] =
    Json.format[UserNoCredentials]

  def fromUser(user: User): UserNoCredentials =
    UserNoCredentials(
      userId = user.userId,
      email = user.email,
      firstName = user.firstName,
      lastName = user.lastName,
      active = user.active
    )
}
