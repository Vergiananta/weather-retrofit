package com.example.myweather.utils

class ResourceState(val resourceStatus: ResourceStatus, val data: Any?, val message: Any?) {
    companion object {
        fun success(data: Any?): ResourceState {
            return ResourceState(
                resourceStatus = ResourceStatus.SUCCESS,
                data = data,
                message = null
            )
        }

        fun loading(): ResourceState {
            return ResourceState(
                resourceStatus = ResourceStatus.LOADING,
                data = null,
                message = null
            )
        }

        fun error(message: Any?): ResourceState {
            return ResourceState(
                resourceStatus = ResourceStatus.FAIL,
                data = null,
                message = message
            )
        }

    }
}