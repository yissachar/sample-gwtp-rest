package com.fave100.samples.gwtprest.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.gwtplatform.dispatch.client.gin.RestDispatchAsyncModule;
import com.gwtplatform.dispatch.client.rest.RestApplicationPath;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class DispatchModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
    	install(new DefaultModule());
        install(new RestDispatchAsyncModule.Builder().build());
        
        bindConstant().annotatedWith(RestApplicationPath.class).to("/_ah/api");
        
        bindConstant().annotatedWith(DefaultPlace.class).to("login");
        bindConstant().annotatedWith(ErrorPlace.class).to("login");
        bindConstant().annotatedWith(UnauthorizedPlace.class).to("login");
    }    
}