package com.example.quizapp.di;

import com.example.quizapp.QuizApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class})
public interface ApplicationComponent {

    void inject(QuizApplication quizApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder applicationBind(QuizApplication application);

        ApplicationComponent build();
    }
}
