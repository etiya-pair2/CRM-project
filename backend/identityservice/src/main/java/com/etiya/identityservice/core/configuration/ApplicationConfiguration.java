//package com.etiya.identityservice.core.configuration;
//
//import org.apache.tomcat.util.descriptor.LocalResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
//
//import java.util.Locale;
//
//public class ApplicationConfiguration {
//    // 1- Dil çevirileri nereden yüklenecek? -Dosya,Veritabanı,API
//    // 2- Kullanıcıdan dil tercihi  nerede alınacak ? - Route google.com/?leng=en, Headers -> Accept-Language
//
//    @Bean
//    public LocalResolver localResolver() {
//        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
//        acceptHeaderLocaleResolver.setDefaultLocale(Locale.of("tr"));
//        return acceptHeaderLocaleResolver;
//    }
//}
