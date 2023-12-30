package com.stackunderflow.exceptions

class ServiceException(message: String, ex: Throwable) : Throwable(message, ex)