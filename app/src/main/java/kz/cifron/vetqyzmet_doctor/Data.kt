package kz.cifron.vetqyzmet_doctor

data class Data(
    val id: Int,
    val controler_id: Long,
    val ID_LOC: Int,
    val TIP: String?,
    val TAB_NUM: String?,
    val LOC_NAME: String,
    val name: String,
    val fizYur: Int
)

data class LoginResponse(
    val user: Data,
    val token: String
)

data class LoginRequestBody(
    val email: String,
    val password: String
)