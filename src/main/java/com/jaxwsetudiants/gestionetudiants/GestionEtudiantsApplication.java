package com.jaxwsetudiants.gestionetudiants;
import com.jaxwsetudiants.gestionetudiants.services.EtudiantServiceSoap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import javax.xml.ws.Endpoint;


@SpringBootApplication
public class GestionEtudiantsApplication{

    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(GestionEtudiantsApplication.class, args);
        EtudiantServiceSoap service=ctx.getBean(EtudiantServiceSoap.class);
        Endpoint.publish("http://localhost:4444/etudiantService",service);


    }

    @Bean
    public EtudiantServiceSoap etudiantService(){
        return new EtudiantServiceSoap() ;}

}



