package com.kryptkode.flashalerts.app.di.app

import com.kryptkode.flashalerts.app.di.app.data.DataModule
import com.kryptkode.flashalerts.app.di.app.util.UtilModule
import com.kryptkode.flashalerts.app.di.controller.ControllerComponent
import com.kryptkode.flashalerts.app.di.controller.ControllerModule
import com.kryptkode.flashalerts.app.di.service.ServiceComponent
import com.kryptkode.flashalerts.app.di.service.ServiceModule
import dagger.Component

/**
 * Created by kryptkode on 5/21/2020.
 */
@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class,
        DataModule::class,
        UtilModule::class,
    ]
)
interface ApplicationComponent {
    fun controllerComponent(controllerModule: ControllerModule): ControllerComponent
    fun serviceComponent(serviceModule: ServiceModule): ServiceComponent
}