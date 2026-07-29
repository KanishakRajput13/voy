package com.kanishak.voy.api

import com.google.gson.JsonObject
import com.kanishak.voy.api.dataclasses.AvailableRides
import com.kanishak.voy.api.dataclasses.AvailableRidesSearchRequest
import com.kanishak.voy.api.dataclasses.DriverManageRequestResponse
import com.kanishak.voy.api.dataclasses.DriverRequestList
import com.kanishak.voy.api.dataclasses.ForgotRequest
import com.kanishak.voy.api.dataclasses.ForgotResponse
import com.kanishak.voy.api.dataclasses.LoginRequest
import com.kanishak.voy.api.dataclasses.LoginResponse
import com.kanishak.voy.api.dataclasses.ResetRequest
import com.kanishak.voy.api.dataclasses.ResetResponse
import com.kanishak.voy.api.dataclasses.EmailVerifyRequest
import com.kanishak.voy.api.dataclasses.EmailVerifyResponse
import com.kanishak.voy.api.dataclasses.GetUserResponse
import com.kanishak.voy.api.dataclasses.OfferRideRequest
import com.kanishak.voy.api.dataclasses.OfferRideResponse
import com.kanishak.voy.api.dataclasses.mapsDataClasses.RoutesRequest
import com.kanishak.voy.api.dataclasses.mapsDataClasses.RoutesResponse
import com.kanishak.voy.api.dataclasses.PhoneVerifyRequest
import com.kanishak.voy.api.dataclasses.RideHistoryResponse
import com.kanishak.voy.api.dataclasses.RideRequestResponse
import com.kanishak.voy.api.dataclasses.SignUpRequest
import com.kanishak.voy.api.dataclasses.SignUpResponse
import com.kanishak.voy.api.dataclasses.UpdateRideStatusResponse
import com.kanishak.voy.api.dataclasses.UserResponseData
import com.kanishak.voy.api.dataclasses.VerifyRequest
import com.kanishak.voy.api.dataclasses.VerifyResponse
import com.kanishak.voy.api.dataclasses.phoneVerifyResponseX
import com.kanishak.voy.api.dataclasses.resendEmailOTP
import com.kanishak.voy.api.dataclasses.resendEmailRequest
import com.kanishak.voy.api.dataclasses.resendForgotOTP
import com.kanishak.voy.api.dataclasses.resendOTPRequest
import com.kanishak.voy.api.dataclasses.resendPhoneOTP
import com.kanishak.voy.api.dataclasses.resendPhoneRequest
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("auth/register/")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>

    @POST("auth/login/")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("auth/forgot-password/")
    suspend fun forgotPassword(@Body forgotRequest: ForgotRequest): ForgotResponse

    @POST("auth/verify-otp/")
    suspend fun verifyOtp(@Body verifyRequest: VerifyRequest): VerifyResponse

    @POST("auth/reset-password/")
    suspend fun resetPassword(@Body resetRequest: ResetRequest): ResetResponse

    @POST("auth/verify-email/")
    suspend fun EmailVerify(@Body request: EmailVerifyRequest): EmailVerifyResponse

    @POST("auth/verify-phone/")
    suspend fun PhoneVerify(@Body request: PhoneVerifyRequest): phoneVerifyResponseX

    @POST("auth/resend-otp/")
    suspend fun resendOtp(@Body request: resendOTPRequest): resendForgotOTP

    @POST("auth/resend-emailotp/")
    suspend fun resendEmailOtp(@Body request: resendEmailRequest): resendEmailOTP

    @POST("auth/resend-phoneotp/")
    suspend fun resendPhoneOtp(@Body request: resendPhoneRequest): resendPhoneOTP

    @GET("auth/user/")
    suspend fun getUserData(@Header("Authorization") authHeader: String): GetUserResponse

    @POST("directions/v2:computeRoutes")
    suspend fun computeRoutes(
        @Body request: RoutesRequest,
        @Query("key") apiKey: String,
        @Query("fields") fieldMask: String = "routes.duration,routes.distanceMeters,routes.polyline.encodedPolyline",
    ): RoutesResponse

    @Multipart
    @PUT("auth/user/")
    suspend fun updateUserData(
        @Header("Authorization") token: String,
        @Part profile_photo: MultipartBody.Part,
    ): UserResponseData

    @FormUrlEncoded
    @PUT("auth/user/")
    suspend fun updateGender(
        @Header("Authorization") token: String,
        @Field("gender") gender: String?,
    ): UserResponseData

    @FormUrlEncoded
    @PUT("auth/user/")
    suspend fun updateUserName(
        @Header("Authorization") token: String,
        @Field("first_name") firstName: String?,
        @Field("last_name") lastName: String?,
    ): UserResponseData

    @FormUrlEncoded
    @PUT("auth/user/")
    suspend fun updateEmergencyContactNo(
        @Header("Authorization") token: String,
        @Field("emergency_contact_phone") emergencyContactNo: String?,
    ): UserResponseData

    @FormUrlEncoded
    @PUT("auth/user/")
    suspend fun addVehicleDetails(
        @Header("Authorization") token: String,
        @Field("vehicle_model") vehicleModel: String?,
        @Field("vehicle_number") vehicleNumber: String?,
        @Field("total_seats") vehicleSeats: String?,
    ): UserResponseData

    @Multipart
    @PUT("auth/user/")
    suspend fun VerifyUser(
        @Header("Authorization") token: String,
        @Part drivers_license_image: MultipartBody.Part,
    ): UserResponseData

    @POST("rides/passenger/search/")
    suspend fun getAvailableRides(
        @Header("Authorization") authHeader: String,
        @Body requestBody: AvailableRidesSearchRequest,
    ): AvailableRides

    @POST("rides/passenger/{requestId}/request/")
    suspend fun requestRide(
        @Header("Authorization") authHeader: String,
        @Path("requestId") requestId: Int,
        @Body rideRequest: JsonObject,
    ): RideRequestResponse

    @POST("rides/driver/create/")
    suspend fun offerRide(
        @Header("Authorization") authHeader: String,
        @Body rideRequest: OfferRideRequest,
    ): OfferRideResponse

    @GET("rides/driver/requests/{driverId}/")
    suspend fun driverListRequest(
        @Header("Authorization") authHeader: String,
        @Path("driverId") driverId: Int,
    ): DriverRequestList

    @POST("rides/driver/manage-request/{requestId}/")
    suspend fun driverManageRequest(
        @Header("Authorization") authHeader: String,
        @Path("requestId") driverId: Int,
        @Body manageRequest: JsonObject,
    ): DriverManageRequestResponse

    @GET("rides/ride-history/")
    suspend fun getRideHistory(
        @Header("Authorization") authHeader: String,
    ): RideHistoryResponse

    @POST("rides/driver/{requestId}/status/")
    suspend fun driverUpdateRideStatus(
        @Header("Authorization") authHeader: String,
        @Path("requestId") requestId: Int,
        @Body updateRequest: JsonObject,
    ): UpdateRideStatusResponse

    @GET("rides/emissions-savings/{rideId}/")
    suspend fun eco(
        @Header("Authorization") authHeader: String,
        @Path("rideId") rideId: Int,
    ): DriverRequestList

}