package com.example.quizapp.di;

import com.example.quizapp.QuizApplication;
import com.example.quizapp.di.modules.ActivityModule;
import com.example.quizapp.di.modules.ContractsModule;
import com.example.quizapp.di.modules.FragmentsModule;
import com.example.quizapp.di.modules.ThreadModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        ActivityModule.class,
        FragmentsModule.class,
        ContractsModule.class,
        ThreadModule.class

})
public interface ApplicationComponent {

    void inject(QuizApplication quizApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder applicationBind(QuizApplication application);

        ApplicationComponent build();
    }
}
