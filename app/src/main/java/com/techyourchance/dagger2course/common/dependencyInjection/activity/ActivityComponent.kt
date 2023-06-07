package com.techyourchance.dagger2course.common.dependencyInjection.activity

import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(): PresentationComponent

}