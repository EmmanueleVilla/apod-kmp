package com.shadowings.apodkmp.redux

import co.touchlab.kermit.Kermit
import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.reduxkotlin.Store
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createThreadSafeStore
import org.reduxkotlin.middleware

val middleware = middleware<AppState> { _, next, action ->
    dep.utils.log.v { "dispatching action " + dep.utils.getActionName(action as Action) }
    next(action)
    appStateTales.forEach {
        MainScope().launch {
            it(action as Action, dep).forEach { store.dispatch(it) }
        }
    }
}

val store: Store<AppState> = createThreadSafeStore(
    ::rootReducer,
    AppState(),
    applyMiddleware(middleware))

fun getDep(): Dependencies {
    return dep
}

data class Dependencies(
    val utils: Utils,
    val storage: Storage,
    val http: Http,
    val constants: Constants
)

data class Constants(
    val latestTimestampKey: String = "LATEST_DOWNLOAD_TIMESTAMP",
    val latestKey: String = "LATEST_DOWNLOAD_KEY"
)

data class Utils(
    val log: Kermit,
    val date: (offset: Int) -> String,
    val currentTimeMillis: () -> Long,
    val getActionName: (action: Action) -> String,
    val platform: Platforms
)

data class Storage(
    val settings: Settings
)

data class Http(
    val httpClient: HttpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    val logger: Kermit = dep.utils.log
                    logger.v("Network") { message }
                }
            }
            level = LogLevel.INFO
        }
    }
)

private val dep: Dependencies = createDependencies()

expect fun createDependencies(): Dependencies

enum class Platforms {
    IOS,
    Android,
    Jvm,
    Js,
    MacOS
}
